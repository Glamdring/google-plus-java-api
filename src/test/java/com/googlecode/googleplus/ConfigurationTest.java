package com.googlecode.googleplus;

import org.junit.Test;

import com.googlecode.googleplus.impl.PlusImpl;

public class ConfigurationTest {

    @Test
    public void timeoutTest() {
        GooglePlusConfiguration config = new GooglePlusConfiguration();
        config.setConnectTimeout(100);
        config.setReadTimeout(100);

        Plus plus = new PlusImpl("", config, null);
    }
}
