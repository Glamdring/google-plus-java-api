package com.googlecode.googleplus.core;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.googlecode.googleplus.GooglePlusFactory;
import com.googlecode.googleplus.Plus;

/**
 * For use in accordance with Section 2.2.3 ConnectionFactory instances of Spring Social documentation.
 *
 * When providing scopes, supply URLs from https://www.googleapis.com/discovery/v1/apis/oauth2/v2/rest?fields=auth(oauth2(scopes))
 *
 */
public class GooglePlusConnectionFactory extends OAuth2ConnectionFactory<Plus> {

    public GooglePlusConnectionFactory(String clientId, String consumerSecret) {
        super("googleplus", new GooglePlusFactory(clientId, consumerSecret), new GooglePlusAdapter());
    }

}
