package com.waris.digitaleventmanager;

/**
 * Created by lalli on 10/25/2015.
 */
public class ListDataClass {
    private String above;
    private String below;
    private int pointer;
    private int image;


    public ListDataClass(String above, String below, int pointer,int image) {
        this.above = above;
        this.below = below;
        this.pointer = pointer;
        this.image=image;

    }

    public String getAbove() {
        return above;
    }

    public String getBelow() {
        return below;
    }

    public int getPointer() {
        return pointer;
    }

    public int getImage() {
        return image;
    }
}
