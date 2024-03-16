package com.gelin.oa.pojo;

public class User {
    private Integer userId;
    private String username;
    private String password;
    private Integer employeeId;
    private Integer salt;

    public User() {
    }

    public User(Integer userId, String username, String password, Integer employeeId, Integer salt) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.employeeId = employeeId;
        this.salt = salt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

}
