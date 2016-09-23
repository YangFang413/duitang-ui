package com.yf.duitang.model;

/**
 * Created by Administrator on 2016/9/19.
 */
public class StaggeredGridViewItem {

    private int imageResource;
    private String imageDescription;
    private int collectionNumber;
    private int userImageResource;
    private String userName;
    private String collectionName;

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserImageResource() {
        return userImageResource;
    }

    public void setUserImageResource(int userImageResource) {
        this.userImageResource = userImageResource;
    }

    public int getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(int collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
