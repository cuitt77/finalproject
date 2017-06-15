package com.baizhi.entity;

import java.util.Date;

public class Deal {
    private String id;

    private String title;

    private Date createtime;

    private String content;
    //与解决方案分类一对一
    private Dealtype dealtype;

    public Dealtype getDealtype() {
        return dealtype;
    }

    public void setDealtype(Dealtype dealtype) {
        this.dealtype = dealtype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}