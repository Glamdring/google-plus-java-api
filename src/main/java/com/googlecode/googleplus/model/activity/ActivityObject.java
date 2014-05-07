package com.googlecode.googleplus.model.activity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown=true)
public class ActivityObject {
    private ActivityObjectCount resharers;
    private List<ActivityObjectAttachments> attachments;
    private String originalContent;
    private ActivityObjectCount plusoners;
    private ActivityActor actor;
    private String content;
    private String url;
    private ActivityObjectCount replies;
    private String id;
    private String objectType;

    public ActivityObjectCount getResharers() {
        return resharers;
    }

    public void setResharers(ActivityObjectCount resharers) {
        this.resharers = resharers;
    }

    public List<ActivityObjectAttachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<ActivityObjectAttachments> attachments) {
        this.attachments = attachments;
    }

    public String getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
    }

    public ActivityObjectCount getPlusoners() {
        return plusoners;
    }

    public void setPlusoners(ActivityObjectCount plusoners) {
        this.plusoners = plusoners;
    }

    public ActivityActor getActor() {
        return actor;
    }

    public void setActor(ActivityActor actor) {
        this.actor = actor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ActivityObjectCount getReplies() {
        return replies;
    }

    public void setReplies(ActivityObjectCount replies) {
        this.replies = replies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
