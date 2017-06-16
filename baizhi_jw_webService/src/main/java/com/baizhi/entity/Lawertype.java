package com.baizhi.entity;

import java.util.List;

public class Lawertype {
    private String id;

    private String name;
    //一个律师分类里有多个律师
    private List<Lawer> lawers;

    @Override
    public String toString() {
        return "Lawertype{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Lawertype(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Lawertype() {
    }

    public List<Lawer> getLawers() {
        return lawers;
    }

    public void setLawers(List<Lawer> lawers) {
        this.lawers = lawers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}