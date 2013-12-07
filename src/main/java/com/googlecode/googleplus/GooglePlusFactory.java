package com.googlecode.googleplus;


import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;

import com.googlecode.googleplus.core.OAuth2RefreshCallback;
import com.googlecode.googleplus.core.OAuth2RefreshListener;
import com.googlecode.googleplus.impl.PlusImpl;

public class GooglePlusFactory extends AbstractOAuth2ServiceProvider<Plus> {

    private GooglePlusConfiguration config;

    public GooglePlusFactory(String clientId, String clientSecret, GooglePlusConfiguration config) {
        super(new OAuth2Template(clientId, clientSecret,
                "https://accounts.google.com/o/oauth2/auth",
                "https://accounts.google.com/o/oauth2/token"));
        this.config = config;
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
        // this is a custom workaround: https://jira.springsource.org/browse/SOCIAL-263
        PlusImpl plus = new PlusImpl(accessToken, config, new DefaultOAuth2RefreshCallback(accessToken, refreshToken, listener));
        plus.init();
        return plus;
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
            AccessGrant grant = GooglePlusFactory.this.getOAuthOperations().refreshAccess(refreshToken, null, null);
            if (listener != null) {
                listener.tokensRefreshed(accessToken, grant);
            }
            return grant.getAccessToken();
        }

    }
}
