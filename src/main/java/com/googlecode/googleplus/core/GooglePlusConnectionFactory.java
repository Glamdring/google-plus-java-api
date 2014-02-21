package com.googlecode.googleplus.core;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.googlecode.googleplus.GooglePlusFactory;
import com.googlecode.googleplus.Plus;

public class GooglePlusConnectionFactory extends OAuth2ConnectionFactory<Plus> {

    public GooglePlusConnectionFactory(String clientId, String consumerSecret) {
        super("googleplus", new GooglePlusFactory(clientId, consumerSecret), new GooglePlusAdapter());
    }

}
