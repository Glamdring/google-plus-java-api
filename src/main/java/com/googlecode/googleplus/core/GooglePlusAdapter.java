package com.googlecode.googleplus.core;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

import com.googlecode.googleplus.Plus;
import com.googlecode.googleplus.model.person.Person;

public class GooglePlusAdapter implements ApiAdapter<Plus> {

    public boolean test(Plus api) {
        try {
            api.getPeopleOperations().get("me");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setConnectionValues(Plus api, ConnectionValues values) {
        Person person = api.getPeopleOperations().get("me");
        values.setProviderUserId(person.getId());
        values.setDisplayName(person.getName().getFormatted());
        values.setProfileUrl(person.getUrl());
        values.setImageUrl(person.getImage().getUrl());
    }

    public UserProfile fetchUserProfile(Plus api) {
        Person person = api.getPeopleOperations().get("me");
        UserProfileBuilder builder = new UserProfileBuilder().setFirstName(person.getName().getGivenName()).setLastName(person.getName().getFamilyName());
        builder.setEmail(person.getGoogleAccountEmail());
        builder.setName(person.getName().getFormatted());
        return builder.build();
    }

    public void updateStatus(Plus api, String message) {
        throw new UnsupportedOperationException("Google+ API does not allow updating status");
    }

}
