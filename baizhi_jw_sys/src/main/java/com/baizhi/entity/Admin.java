package com.baizhi.entity;

public class Admin {
    private String id;

    private String adminname;

    private String password;

    private String salt;

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", adminname='" + adminname + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    public Admin(String id, String adminname, String password, String salt) {
        this.id = id;
        this.adminname = adminname;
        this.password = password;
        this.salt = salt;
    }

    public Admin() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}