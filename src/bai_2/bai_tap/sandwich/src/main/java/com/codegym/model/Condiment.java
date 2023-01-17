package com.codegym.model;

public class Condiment {
    private int condimentId;
    private String condimentName;
    private String img;

    public Condiment() {
    }

    public Condiment(int condimentId, String condimentName, String img) {
        this.condimentId = condimentId;
        this.condimentName = condimentName;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCondimentId() {
        return condimentId;
    }

    public void setCondimentId(int condimentId) {
        this.condimentId = condimentId;
    }

    public String getCondimentName() {
        return condimentName;
    }

    public void setCondimentName(String condimentName) {
        this.condimentName = condimentName;
    }
}
