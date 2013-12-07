package com.googlecode.googleplus;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class PlusUtilsTest {

    @Test
    public void createParameMapTest() {
        Paging paging = new Paging(30, "foo");
        Map<String, String> params = PlusUtils.createParamMap(paging);
        Assert.assertTrue(params.containsKey("maxResults"));
        Assert.assertTrue(params.get("maxResults").equals("30"));
        Assert.assertTrue(params.containsKey("pageToken"));
        Assert.assertTrue(params.get("pageToken").equals("foo"));
    }

    @Test
    public void addParametersTest() {
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("a", "a");
        params.put("b", "b");
        String url = PlusUtils.addParameters("http://foo.com", params);
        Assert.assertEquals("http://foo.com?a=a&b=b", url);
    }
}
