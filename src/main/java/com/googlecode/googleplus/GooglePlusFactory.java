package com.googlecode.googleplus;


import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;

import com.googlecode.googleplus.core.OAuth2RefreshCallback;
import com.googlecode.googleplus.core.OAuth2RefreshListener;
import com.googlecode.googleplus.impl.PlusImpl;

/**
 * Suitable for direct use - if you are using Spring Social configuration builder see GooglePlusConnectionFactory.
 *
 */
public class GooglePlusFactory extends AbstractOAuth2ServiceProvider<Plus> {

    private static final String TOKEN_URL = "https://accounts.google.com/o/oauth2/token";
    private static final String AUTH_URL = "https://accounts.google.com/o/oauth2/auth";

    private GooglePlusConfiguration config;

    public GooglePlusFactory(String clientId, String clientSecret, GooglePlusConfiguration config) {
        super(createOAuthTemplate(clientId, clientSecret));
        this.config = config;
    }

    private static OAuth2Template createOAuthTemplate(String clientId, String clientSecret) {
        OAuth2Template template = new OAuth2Template(clientId, clientSecret, AUTH_URL, TOKEN_URL);
        template.setUseParametersForClientAuthentication(true);
        return template;
    }

    public GooglePlusFactory(String clientId, String clientSecret) {
        this(clientId, clientSecret, new GooglePlusConfiguration());
    }

    /**
     * @deprecated This method does not support token refreshing. Use getApi(accessToken, refreshToken, listener) instead.
     */
    @Override
    @Deprecated
    public Plus getApi(String accessToken) {
        return getApi(accessToken, null, null);
    }

    public Plus getApi(String accessToken, String refreshToken, OAuth2RefreshListener listener) {
        // proxy configuring needs to be done before instantiation the client object,
        // because otherwise system settings are read instead
        configureProxy();

        // this is a custom workaround: https://jira.springsource.org/browse/SOCIAL-263
        PlusImpl plus = new PlusImpl(accessToken, config, new DefaultOAuth2RefreshCallback(accessToken, refreshToken, listener));
        plus.init();
        return plus;
    }

    private void configureProxy() {
        // overriding values specified with -D, if any
        if (config.getProxyHost() != null) {
            System.setProperty("http.proxyHost", config.getProxyHost());
        }
        if (config.getProxyPort() != 0) {
            System.setProperty("http.proxyPort", String.valueOf(config.getProxyPort()));
        }
    }

    public final class DefaultOAuth2RefreshCallback implements OAuth2RefreshCallback {
        private String accessToken;
        private String refreshToken;
        private OAuth2RefreshListener listener;

        public DefaultOAuth2RefreshCallback(String accessToken, String refreshToken, OAuth2RefreshListener listener) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
            this.listener = listener;
        }
        public String refreshToken() {
            if (refreshToken == null) {
                return null;
            }
            AccessGrant grant = GooglePlusFactory.this.getOAuthOperations().refreshAccess(refreshToken, null);
            if (listener != null) {
                listener.tokensRefreshed(accessToken, grant);
            }
            return grant.getAccessToken();
        }
    }
}
