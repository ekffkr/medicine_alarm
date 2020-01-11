package com.example.myapplication4;

import android.graphics.drawable.Drawable;

public class DifferListItem {
    private String name;
    private int del;

    public DifferListItem(){

    }

    public  DifferListItem(String name, int del){
        this.name = name;
        this.del = del;
    }

    public void setname(String name){
        this.name = name;

    }
    public void seticon(int  dele){
        this.del = dele;

    }
    public String getname(){
        return this.name;
    }
    public int geticon(){
        return this.del;
    }



}
