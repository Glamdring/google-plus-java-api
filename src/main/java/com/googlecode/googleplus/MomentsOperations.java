package com.googlecode.googleplus;

import com.googlecode.googleplus.model.moments.Moment;
import com.googlecode.googleplus.model.moments.MomentCollection;
import com.googlecode.googleplus.model.moments.MomentFeed;

public interface MomentsOperations {

    void insert(Moment moment, MomentCollection collection);

    MomentFeed list(String userId, MomentCollection collection, String targetUrlFilter, String typeFilter);
    MomentFeed list(String userId, MomentCollection collection, String targetUrlFilter, String typeFilter, Paging paging);

    void remove(String momentId);
}
