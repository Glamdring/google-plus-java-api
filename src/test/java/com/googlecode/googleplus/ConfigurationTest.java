package com.googlecode.googleplus;

import java.net.UnknownHostException;

import org.apache.http.conn.ConnectTimeoutException;
import org.junit.Test;

import com.googlecode.googleplus.GooglePlusConfiguration;
import com.googlecode.googleplus.GooglePlusFactory;
import com.googlecode.googleplus.Plus;
import com.googlecode.googleplus.impl.PlusImpl;
import com.googlecode.googleplus.model.person.PeopleCollection;

public class ConfigurationTest {

    @Test
    public void timeoutTest() throws Exception {
        GooglePlusConfiguration config = new GooglePlusConfiguration();
        config.setConnectTimeout(10);
        config.setReadTimeout(10);

        PlusImpl plus = new PlusImpl("", config, null);
        plus.init();

        // plugging into the underlying http client implementation is tough, so
        // we verify that the timeouts are properly set by invoking this method
        // with a very small timeout, expecting a timeout exception
        try {
            plus.getPeopleOperations().list("me", PeopleCollection.VISIBLE);
        } catch (Exception ex) {
            if (ex.getCause().getClass() != ConnectTimeoutException.class) {
                throw ex;
            }
        }
    }

    @Test
    public void proxyTest() throws Exception {
        GooglePlusConfiguration config = new GooglePlusConfiguration();
        config.setProxyHost("foo");
        config.setProxyPort(80);

        GooglePlusFactory factory = new GooglePlusFactory("", "", config);
        Plus plus = factory.getApi("", "", null);

        // plugging into the underlying http client implementation is tough, so
        // we verify that the proxy settings are properly set by invoking this method
        // with a non-existent proxy, expecting an UnknownHost exception
        try {
            plus.getPeopleOperations().list("me", PeopleCollection.VISIBLE);
        } catch (Exception ex) {
            if (ex.getCause().getClass() != UnknownHostException.class) {
                throw ex;
            }
        }

    }
}
