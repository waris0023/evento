package com.waris.digitaleventmanager;

/**
 * Created by lalli on 10/21/2015.
 */
public class DataClass {
private int img;
private String name;
    private int img1;

    public DataClass(int img, String name,int img1) {
        this.img = img;
        this.name = name;
        this.img1= img1;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public int getImg1() {
        return img1;
    }
}
