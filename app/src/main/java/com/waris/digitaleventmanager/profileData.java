package com.waris.digitaleventmanager;

/**
 * Created by lalli on 10/26/2015.
 */
public class profileData {

    private int image;
    String rat,pics,review,desc;

    public profileData(int image, String rat, String pics, String review, String desc) {
        this.image = image;
        this.rat = rat;
        this.pics = pics;
        this.review = review;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public String getRat() {
        return rat;
    }

    public String getPics() {
        return pics;
    }

    public String getReview() {
        return review;
    }

    public String getDesc() {
        return desc;
    }
}
