package com.example.noahlovato.stressreliever.models;

/**
 * Created by noah.lovato on 6/27/2017.
 */

public class LocalPhoto implements IPhoto {

    int id;
    String name;

    public LocalPhoto(){
        this.id = 0;
        this.name = "";
    }

    public LocalPhoto(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
