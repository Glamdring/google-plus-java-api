package com.googlecode.googleplus.impl;

import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.googlecode.googleplus.ActivityOperations;
import com.googlecode.googleplus.GooglePlusConstants;
import com.googlecode.googleplus.Paging;
import com.googlecode.googleplus.PlusUtils;
import com.googlecode.googleplus.model.OrderBy;
import com.googlecode.googleplus.model.activity.Activity;
import com.googlecode.googleplus.model.activity.ActivityCollection;
import com.googlecode.googleplus.model.activity.ActivityFeed;

public class ActivityOperationsImpl implements ActivityOperations {

    private static final String LIST_URL = GooglePlusConstants.API_URL_ROOT + "/people/{userId}/activities/{collection}";
    private static final String GET_URL = GooglePlusConstants.API_URL_ROOT + "/activities/{activityId}";
    private static final String SEARCH_URL = GooglePlusConstants.API_URL_ROOT + "/activities";
    private RestTemplate restTemplate;

    public ActivityOperationsImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ActivityFeed list(String userId, ActivityCollection collection, Paging paging) {
        Assert.notNull(userId);
        Assert.notNull(collection);
        // TODO when google add more representations, configure the "alt" parameter
        Map<String, String> params = PlusUtils.createParamMap(paging);
        return restTemplate.getForObject(PlusUtils.addParameters(LIST_URL, params), ActivityFeed.class, userId, collection.getCollectionName());
    }

    public ActivityFeed list(String userId, ActivityCollection collection) {
        return list(userId, collection, null);
    }

    public Activity get(String activityId) {
        return restTemplate.getForObject(GET_URL, Activity.class, activityId);
    }

    public ActivityFeed search(String query, OrderBy orderBy) {
        return search(query, orderBy, null);
    }

    public ActivityFeed search(String query, OrderBy orderBy, Paging paging) {
        Map<String, String> params = PlusUtils.createParamMap(paging);
        if (orderBy != null) {
            params.put("orderBy", orderBy.getOrderBy());
        }
        if (query != null) {
            params.put("query", query);
        }
        return restTemplate.getForObject(PlusUtils.addParameters(SEARCH_URL, params), ActivityFeed.class);
    }

}
