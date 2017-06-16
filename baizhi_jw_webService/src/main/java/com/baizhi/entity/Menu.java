package com.baizhi.entity;

import java.util.List;

public class Menu {
    private String id;

    private String name;
    private List<Menu> child;
    private String href;

    private String iconCls;

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                '}';
    }

    public Menu(String id, String name, String href, String iconCls) {
        this.id = id;
        this.name = name;
        this.href = href;
        this.iconCls = iconCls;
    }
}