package com.example.talkingroom;

import androidx.annotation.NonNull;

public class Talk {
    @Override
    public String toString() {
        return "Talk{" +
                "text='" + text + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private String text;
    private String name;


    public Talk(String name, String text){
        this.text = text;
        this.name = name;

    }

    public String getText(){
        return  text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
