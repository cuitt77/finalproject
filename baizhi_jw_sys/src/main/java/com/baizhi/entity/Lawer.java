package com.baizhi.entity;

import java.math.BigDecimal;
import java.util.List;

public class Lawer {
    private String id;

    private String name;

    private String address;

    private String year;

    private String number;

    private String workspace;

    private String description;

    private BigDecimal wordprice;

    private BigDecimal phoneprice;

    private String photo;
    private String phone;
    private String status;
    //一个律师对多个订单
    private List<Order> orders;
    //一个律师对应多个红包
    private List<Redpackage> redpackages;
    //一个律师对应多个分类
    private List<Lawertype> lawertypes;
    //一个律师被对个用户收藏
    private List<User> users;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Lawertype> getLawertypes() {
        return lawertypes;
    }

    public void setLawertypes(List<Lawertype> lawertypes) {
        this.lawertypes = lawertypes;
    }

    @Override
    public String toString() {
        return "Lawer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", year='" + year + '\'' +
                ", number='" + number + '\'' +
                ", workspace='" + workspace + '\'' +
                ", description='" + description + '\'' +
                ", wordprice=" + wordprice +
                ", phoneprice=" + phoneprice +
                ", photo='" + photo + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Lawer(String id, String name, String address, String year, String number, String workspace, String description, BigDecimal wordprice, BigDecimal phoneprice, String photo, String phone, String status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.year = year;
        this.number = number;
        this.workspace = workspace;
        this.description = description;
        this.wordprice = wordprice;
        this.phoneprice = phoneprice;
        this.photo = photo;
        this.phone = phone;
        this.status = status;
    }

    public Lawer() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Redpackage> getRedpackages() {
        return redpackages;
    }

    public void setRedpackages(List<Redpackage> redpackages) {
        this.redpackages = redpackages;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public BigDecimal getWordprice() {
        return wordprice;
    }

    public void setWordprice(BigDecimal wordprice) {
        this.wordprice = wordprice;
    }

    public BigDecimal getPhoneprice() {
        return phoneprice;
    }

    public void setPhoneprice(BigDecimal phoneprice) {
        this.phoneprice = phoneprice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}