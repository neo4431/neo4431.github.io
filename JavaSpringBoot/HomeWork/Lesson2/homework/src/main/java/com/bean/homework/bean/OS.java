package com.bean.homework.bean;

public class OS {
    private String model;

    public String getModel() {
        return model;
    }
    public OS(String model){
        this.model = model;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return model;
    }
}
