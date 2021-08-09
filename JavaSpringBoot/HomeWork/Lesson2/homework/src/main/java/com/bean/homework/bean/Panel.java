package com.bean.homework.bean;

public class Panel {
    private String model;

    public String getModel() {
        return model;
    }

    public Panel(String model){
        this.model = model;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return model;
    }
}
