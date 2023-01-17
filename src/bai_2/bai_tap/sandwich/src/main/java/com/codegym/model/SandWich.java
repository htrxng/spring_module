package com.codegym.model;


import java.util.List;

public class SandWich {
    private int id;
    private String name;
    private List<Condiment> condimentList;

    public SandWich() {
    }

    public SandWich(int id, String name, List<Condiment> condimentList) {
        this.id = id;
        this.name = name;
        this.condimentList = condimentList;
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

    public List<Condiment> getCondimentList() {
        return condimentList;
    }

    public void setCondimentList(List<Condiment> condimentList) {
        this.condimentList = condimentList;
    }
}
