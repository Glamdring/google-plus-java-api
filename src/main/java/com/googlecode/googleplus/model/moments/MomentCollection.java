package com.googlecode.googleplus.model.moments;

public enum MomentCollection {
    VAULT("vault");
    private String collectionName;

    private MomentCollection(String collectionName) {
        this.collectionName = collectionName;
    }
    public String getCollectionName() {
        return collectionName;
    }
}
