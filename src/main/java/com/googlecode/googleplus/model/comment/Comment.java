package com.googlecode.googleplus.model.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

import org.joda.time.DateTime;

import com.googlecode.googleplus.model.activity.ActivityActor;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Comment {
    private String kind;
    private DateTime updated;
    private CommentObject object;
    private ActivityActor actor;
    private String id;
    private String verb;
    private List<InReplyTo> inReplyTo;
    private String selfLink;
    private DateTime published;

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public DateTime getUpdated() {
        return updated;
    }
    public void setUpdated(DateTime updated) {
        this.updated = updated;
    }
    public CommentObject getObject() {
        return object;
    }
    public void setObject(CommentObject object) {
        this.object = object;
    }
    public ActivityActor getActor() {
        return actor;
    }
    public void setActor(ActivityActor actor) {
        this.actor = actor;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getVerb() {
        return verb;
    }
    public void setVerb(String verb) {
        this.verb = verb;
    }
    public List<InReplyTo> getInReplyTo() {
        return inReplyTo;
    }
    public void setInReplyTo(List<InReplyTo> inReplyTo) {
        this.inReplyTo = inReplyTo;
    }
    public String getSelfLink() {
        return selfLink;
    }
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }
    public DateTime getPublished() {
        return published;
    }
    public void setPublished(DateTime published) {
        this.published = published;
    }
}
