package com.googlecode.googleplus.impl;

import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.googlecode.googleplus.GooglePlusConstants;
import com.googlecode.googleplus.Paging;
import com.googlecode.googleplus.PeopleOperations;
import com.googlecode.googleplus.PlusUtils;
import com.googlecode.googleplus.model.activity.ActivityPeopleCollection;
import com.googlecode.googleplus.model.person.PeopleCollection;
import com.googlecode.googleplus.model.person.Person;
import com.googlecode.googleplus.model.person.PersonFeed;

public class PeopleOperationsImpl implements PeopleOperations {

    private static final String GET_URL = GooglePlusConstants.API_URL_ROOT + "/people/{id}";
    private static final String SEARCH_URL = GooglePlusConstants.API_URL_ROOT + "/people";
    private static final String GET_BY_ACTIVITY_URL = GooglePlusConstants.API_URL_ROOT + "/activities/{activityId}/people/{collection}";
    private static final String LIST_URL = GooglePlusConstants.API_URL_ROOT + "/people/{userId}/people/{collection}";

    private RestTemplate restTemplate;

    public PeopleOperationsImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Person get(String id) {
        Assert.notNull(id);
        return restTemplate.getForObject(GET_URL, Person.class, id);
    }

    public PersonFeed search(String query, Paging paging) {
        Map<String, String> params = PlusUtils.createParamMap(paging);
        if (query != null) {
            params.put("query", query);
        }
        return restTemplate.getForObject(PlusUtils.addParameters(SEARCH_URL, params), PersonFeed.class);
    }

    public PersonFeed search(String query) {
        return search(query, null);
    }

    public PersonFeed listByActivity(String activityId, ActivityPeopleCollection collection) {
        return listByActivity(activityId, collection, null);
    }

    public PersonFeed listByActivity(String activityId, ActivityPeopleCollection collection, Paging paging) {
        Assert.notNull(activityId);
        Assert.notNull(collection);
        Map<String, String> params = PlusUtils.createParamMap(paging);
        return restTemplate.getForObject(PlusUtils.addParameters(GET_BY_ACTIVITY_URL, params), PersonFeed.class, activityId, collection.getCollectionName());
    }

    public PersonFeed list(String userId, PeopleCollection collection) {
        return list(userId, collection, null);
    }

    public PersonFeed list(String userId, PeopleCollection collection, Paging paging) {
        Assert.notNull(userId);
        Assert.notNull(collection);
        Map<String, String> params = PlusUtils.createParamMap(paging);
        return restTemplate.getForObject(PlusUtils.addParameters(LIST_URL, params), PersonFeed.class, userId, collection.getCollectionName());
    }
}
