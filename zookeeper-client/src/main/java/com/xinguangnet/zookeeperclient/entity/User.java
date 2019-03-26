package com.xinguangnet.zookeeperclient.entity;

/**
 * @Author: duozl
 * @Date: 2018/3/30 16:53
 */
public class User {

    private String userId;

    private String userName;

    private String gender;

    private String password;

    private String version;

    public User(String userId, String userName, String gender, String password, String version) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.password = password;
        this.version = version;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
