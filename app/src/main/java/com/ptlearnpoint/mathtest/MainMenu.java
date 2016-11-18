package com.ptlearnpoint.mathtest;

/**
 * Created by pt on 11/17/16.
 */

public class MainMenu {
    private String name;
    private int photo ;

    public MainMenu(String name , int photo){
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
