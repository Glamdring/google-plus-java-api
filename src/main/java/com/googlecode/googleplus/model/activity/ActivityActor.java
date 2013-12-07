package com.googlecode.googleplus.model.activity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ActivityActor {
    private String url;
    private ActivityActorImage image;
    private String displayName;
    private String id;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public ActivityActorImage getImage() {
        return image;
    }
    public void setImage(ActivityActorImage image) {
        this.image = image;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
