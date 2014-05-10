package com.googlecode.googleplus.model.activity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.googlecode.googleplus.model.BaseFeed;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ActivityFeed extends BaseFeed<Activity> {

}
