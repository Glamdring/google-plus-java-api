package com.googlecode.googleplus.model.comment;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.googlecode.googleplus.model.activity.ActivityActor;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Comment {
    private String kind;
    private Date updated;
    private CommentObject object;
    private ActivityActor actor;
    private String id;
    private String verb;
    private List<InReplyTo> inReplyTo;
    private String selfLink;
    private Date published;

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
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
    public Date getPublished() {
        return published;
    }
    public void setPublished(Date published) {
        this.published = published;
    }
}
