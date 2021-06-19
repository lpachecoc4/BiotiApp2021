package com.example.biotiapp;

import java.io.Serializable;

public class ListElement implements Serializable {
    public int imagePos;
    public String name;
    public int scale;

    public ListElement(String name, int scale, int imagePos) {
        this.imagePos = imagePos;
        this.name = name;
        this.scale = scale;
    }

    public void setImagePos(int imagePos) { this.imagePos = imagePos; }

    public void setName(String name) {
        this.name = name;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getImagePos() { return imagePos; }

    public String getName() {
        return name;
    }

    public int getScale() {
        return scale;
    }
}
