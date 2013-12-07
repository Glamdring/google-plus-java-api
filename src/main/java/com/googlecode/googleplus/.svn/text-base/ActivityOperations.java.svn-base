package com.googlecode.googleplus;

import com.googlecode.googleplus.model.OrderBy;
import com.googlecode.googleplus.model.activity.Activity;
import com.googlecode.googleplus.model.activity.ActivityCollection;
import com.googlecode.googleplus.model.activity.ActivityFeed;


public interface ActivityOperations {

    ActivityFeed list(String userId, ActivityCollection collection, Paging paging);
    ActivityFeed list(String userId, ActivityCollection collection);
    Activity get(String activityId);
    ActivityFeed search(String query, OrderBy orderBy);
    ActivityFeed search(String query, OrderBy orderBy, Paging paging);

}
