package com.googlecode.googleplus.impl;

import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.googlecode.googleplus.GooglePlusConstants;
import com.googlecode.googleplus.MomentsOperations;
import com.googlecode.googleplus.Paging;
import com.googlecode.googleplus.PlusUtils;
import com.googlecode.googleplus.model.moments.Moment;
import com.googlecode.googleplus.model.moments.MomentCollection;
import com.googlecode.googleplus.model.moments.MomentFeed;

public class MomentsOperationsImpl implements MomentsOperations {

    private static final String INSERT_URL = GooglePlusConstants.API_URL_ROOT + "people/{userId}/moments/{collection}";
    private static final String LIST_URL = INSERT_URL;
    private static final String DELETE_URL = "moments/{id}";

    private RestTemplate restTemplate;

    public MomentsOperationsImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void insert(Moment moment, MomentCollection collection) {
        restTemplate.postForObject(INSERT_URL, moment, Map.class, "me", collection.getCollectionName());
    }

    public MomentFeed list(String userId, MomentCollection collection, String targetUrlFilter,
            String typeFilter) {
        return list(userId, collection, targetUrlFilter, typeFilter, null);
    }

    public MomentFeed list(String userId, MomentCollection collection, String targetUrlFilter,
            String typeFilter, Paging paging) {
        Assert.notNull(userId);
        Assert.notNull(collection);
        Map<String, String> params = PlusUtils.createParamMap(paging);
        if (targetUrlFilter != null) {
            params.put("targetUrl", targetUrlFilter);
        }
        if (typeFilter != null) {
            params.put("typeFilter", typeFilter);
        }
        return restTemplate.getForObject(PlusUtils.addParameters(LIST_URL, params), MomentFeed.class, userId, collection.getCollectionName());
    }

    public void remove(String momentId) {
        Assert.notNull(momentId);
        restTemplate.delete(DELETE_URL, momentId);
    }
}
