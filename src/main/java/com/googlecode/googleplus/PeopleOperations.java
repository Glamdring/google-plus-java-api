package com.googlecode.googleplus;

import com.googlecode.googleplus.model.activity.ActivityPeopleCollection;
import com.googlecode.googleplus.model.person.Person;
import com.googlecode.googleplus.model.person.PeopleCollection;
import com.googlecode.googleplus.model.person.PersonFeed;


public interface PeopleOperations {

    Person get(String id);

    PersonFeed search(String query, Paging paging);
    PersonFeed search(String query);

    PersonFeed listByActivity(String activityId, ActivityPeopleCollection collection);
    PersonFeed listByActivity(String activityId, ActivityPeopleCollection collection, Paging paging);

    PersonFeed list(String userId, PeopleCollection collection);
    PersonFeed list(String userId, PeopleCollection collection, Paging paging);
}
