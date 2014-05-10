package com.googlecode.googleplus.model.moments;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.googlecode.googleplus.model.BaseFeed;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MomentFeed extends BaseFeed<Moment> {

}
