package com.baizhi.entity;

public class Order {
    private String id;

    private String content;

    private String type;

    private Integer status;
    //一个订单对应一个评价
    private Comment comment;
    //一个订单对应一个用户
    private User user;
    //一个订单对应一个律师
    private Lawer lawer;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lawer getLawer() {
        return lawer;
    }

    public void setLawer(Lawer lawer) {
        this.lawer = lawer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                '}';
    }

    public Order(String id, String content, String type, Integer status) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.status = status;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}