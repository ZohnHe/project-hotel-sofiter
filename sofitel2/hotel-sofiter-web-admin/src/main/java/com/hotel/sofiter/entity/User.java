package com.hotel.sofiter.entity;

public class User {
    private String username;
    private String password;
    private String code;
    private String newCode;
    private String remember;

    public User(String username, String password, String code, String newCode, String remember) {
        this.username = username;
        this.password = password;
        this.code = code;
        this.newCode = newCode;
        this.remember = remember;
    }

    public User(String username) {
        this.username = username;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    public User(String username, String password, String code, String newCode) {
        this.username = username;
        this.password = password;
        this.code = code;
        this.newCode = newCode;
    }

    public User(String username, String password, String code) {
        this.username = username;
        this.password = password;
        this.code = code;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNewCode() {
        return newCode;
    }

    public void setNewCode(String newCode) {
        this.newCode = newCode;
    }
}
