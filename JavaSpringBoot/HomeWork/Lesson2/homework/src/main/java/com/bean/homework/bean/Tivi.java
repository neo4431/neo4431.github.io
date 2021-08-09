package com.bean.homework.bean;


public class Tivi {

    private Panel panel;
    private OS os;

    public Tivi(Panel panel, OS os){
        this.panel = panel;
        this.os = os;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Tivi [Panel = " + panel + ",OS = " + os +"]";
    }
}
