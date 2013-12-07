package com.googlecode.googleplus.impl;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.googlecode.googleplus.CommentOperations;
import com.googlecode.googleplus.GooglePlusConstants;
import com.googlecode.googleplus.Paging;
import com.googlecode.googleplus.PlusUtils;
import com.googlecode.googleplus.model.comment.Comment;
import com.googlecode.googleplus.model.comment.CommentFeed;


public class CommentOperationsImpl implements CommentOperations {

    private static final String LIST_URL = GooglePlusConstants.API_URL_ROOT + "/activities/{activityId}/comments";
    private static final String GET_URL = GooglePlusConstants.API_URL_ROOT + "/comments/{commentId}";

    private RestTemplate restTemplate;

    public CommentOperationsImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CommentFeed list(String activityId, Paging paging) {
        Map<String, String> params = PlusUtils.createParamMap(paging);
        return restTemplate.getForObject(PlusUtils.addParameters(LIST_URL, params), CommentFeed.class, activityId);
    }

    public CommentFeed list(String activityId) {
        return list(activityId, null);
    }

    public Comment get(String commentId) {
        return restTemplate.getForObject(GET_URL, Comment.class, commentId);
    }
}
