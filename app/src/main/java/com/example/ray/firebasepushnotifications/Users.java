package com.example.ray.firebasepushnotifications;

/**
 * Created by Ray on 2018/2/28.
 */

public class Users extends UserId{

    String name, image;

    public Users(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Users(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
