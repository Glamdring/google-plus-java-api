package com.googlecode.googleplus;

import java.util.Map;

public class Paging {

    private int maxResults;
    private String pageToken;

    public Paging(int maxResults) {
        super();
        this.maxResults = maxResults;
    }
    public Paging(String pageToken) {
        super();
        this.pageToken = pageToken;
    }
    public Paging(int maxResults, String pageToken) {
        super();
        this.maxResults = maxResults;
        this.pageToken = pageToken;
    }
    public int getMaxResults() {
        return maxResults;
    }
    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }
    public String getPageToken() {
        return pageToken;
    }
    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    Map<String, String> fillParameterMap(Map<String, String> map) {
        if (pageToken != null) {
            map.put("pageToken", pageToken);
        }
        if (maxResults > 0) {
            map.put("maxResults", String.valueOf(maxResults));
        }

        return map;
    }
}
