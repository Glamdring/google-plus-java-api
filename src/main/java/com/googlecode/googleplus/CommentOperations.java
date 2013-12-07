package com.googlecode.googleplus;

import com.googlecode.googleplus.model.comment.Comment;
import com.googlecode.googleplus.model.comment.CommentFeed;

public interface CommentOperations {

    CommentFeed list(String activityId, Paging paging);
    CommentFeed list(String activityId);

    Comment get(String commentId);
}
