package com.googlecode.googleplus.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.http.client.HttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import com.googlecode.googleplus.ActivityOperations;
import com.googlecode.googleplus.CommentOperations;
import com.googlecode.googleplus.GooglePlusConfiguration;
import com.googlecode.googleplus.MomentsOperations;
import com.googlecode.googleplus.PeopleOperations;
import com.googlecode.googleplus.Plus;
import com.googlecode.googleplus.core.OAuth2RefreshCallback;
import com.googlecode.googleplus.core.TokenRefreshingClientHttpRequestFactory;

public class PlusImpl extends AbstractOAuth2ApiBinding implements Plus {

    private static boolean HTTP_COMPONENTS_AVAILABLE = ClassUtils.isPresent("org.apache.http.client.HttpClient", ClientHttpRequestFactory.class.getClassLoader());

    private ActivityOperations activityOperations;
    private PeopleOperations peopleOperations;
    private CommentOperations commentOperations;
    private MomentsOperations historyOperations;

    public PlusImpl(String accessToken, GooglePlusConfiguration config, OAuth2RefreshCallback refreshCallback) {
        super(accessToken);
        // (doing work in constructor because the superclass does it that forces us to do it)
        configure(config);
        // Wrap the request factory with a BufferingClientHttpRequestFactory so
        // that the error handler can do repeat reads on the response.getBody()
        ClientHttpRequestFactory requestFactory = ClientHttpRequestFactorySelector
                .bufferRequests(getRestTemplate().getRequestFactory());
        requestFactory = new TokenRefreshingClientHttpRequestFactory(requestFactory, refreshCallback, getRestTemplate().getInterceptors());
        getRestTemplate().setRequestFactory(requestFactory);
    }

    private static final Field requestFactoryDelegateField = ReflectionUtils.findField(InterceptingClientHttpRequestFactory.class, "requestFactory");
    static {
        requestFactoryDelegateField.setAccessible(true);
    }

    private void configure(GooglePlusConfiguration config) {
        //TODO retrying

        //well, that's ugly..  https://issues.springsource.org/browse/SOCIAL-196, https://jira.springsource.org/browse/SOCIAL-266
        ClientHttpRequestFactory clientRequestFactory = getRestTemplate().getRequestFactory();
        if (clientRequestFactory instanceof InterceptingClientHttpRequestFactory) {
            clientRequestFactory = (ClientHttpRequestFactory) ReflectionUtils.getField(requestFactoryDelegateField, clientRequestFactory);
        }
        if (HTTP_COMPONENTS_AVAILABLE) {
            if (config.getConnectTimeout() > 0) {
                Method clientGetter = ReflectionUtils.findMethod(clientRequestFactory.getClass(), "getHttpClient");
                clientGetter.setAccessible(true);
                HttpClient client = (HttpClient) ReflectionUtils.invokeMethod(clientGetter, clientRequestFactory);
                client.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, config.getConnectTimeout());
            }
            if (config.getReadTimeout() > 0) {
                Method setter = ReflectionUtils.findMethod(clientRequestFactory.getClass(), "setReadTimeout", int.class);
                setter.setAccessible(true);
                ReflectionUtils.invokeMethod(setter, clientRequestFactory, config.getReadTimeout());
            }
        } else {
            SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) clientRequestFactory;
            if (config.getConnectTimeout() > 0) {
                //factory.setConnectTimeout(config.getConnectTimeout());
            }
            if (config.getReadTimeout() > 0) {
                //factory.setReadTimeout(config.getReadTimeout());
            }
        }
    }

    public void init() {
        activityOperations = new ActivityOperationsImpl(getRestTemplate());
        peopleOperations = new PeopleOperationsImpl(getRestTemplate());
        commentOperations = new CommentOperationsImpl(getRestTemplate());
        historyOperations = new MomentsOperationsImpl(getRestTemplate());
    }

    public ActivityOperations getActivityOperations() {
        return activityOperations;
    }

    public PeopleOperations getPeopleOperations() {
        return peopleOperations;
    }

    public CommentOperations getCommentOperations() {
        return commentOperations;
    }

    @Override
    protected OAuth2Version getOAuth2Version() {
        return OAuth2Version.DRAFT_10;
    }

    public MomentsOperations getHistoryOperations() {
        return historyOperations;
    }
}
