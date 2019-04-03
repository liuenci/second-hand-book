package com.gxy.vbook.pojo;

public class User {
    private Integer id;

    private String name;

    private String password;

    private Double balance;

    private Byte role;

    public User(Integer id, String name, String password, Double balance, Byte role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }
}