package com.example.biotiapp;

import android.content.Context;

import java.io.Serializable;

public class ListElement implements Serializable {
    public int imagePos;
    public String name;
    public int scale;

    public ListElement( String name, int scale, int imagePos) {
        this.imagePos = imagePos;
        this.name = name;
        this.scale = scale;
    }

    public ListElement( String name, String scale, String imagePos) {
        this.name = name;
        setScale(scale);
        setImagePos(imagePos);
    }

    public ListElement( String name, int scale, String imagePos) {
        this.name = name;
        this.scale = scale;
        setImagePos(imagePos);
    }

    public ListElement (String name, Context context){
        DBHelper DB = new DBHelper(context);
        String tscale = DB.getScale(name);
        int scale = Integer.parseInt(tscale);
        String tpos = DB.getPos(name);
        this.name = name;
        this.scale = scale;
        setImagePos(tpos);
    }


    public void setImagePos(int imagePos) { this.imagePos = imagePos; }

    public void setImagePos(String imagePos) { this.imagePos = Integer.parseInt(imagePos); }

    public void setName(String name) {
        this.name = name;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public void setScale(String scale) { this.imagePos = Integer.parseInt(scale); }



    public int getImagePos() { return imagePos; }

    public String getName() {
        return name;
    }

    public int getScale() {
        return scale;
    }
}
