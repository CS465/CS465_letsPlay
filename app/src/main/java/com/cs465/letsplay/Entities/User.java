package com.cs465.letsplay.Entities;


/**
 * Created by Piyush on 4/29/2015.
 */
public class User {
    private String username;
    private String userId;
    private String address;
    private String gender;
    private int age;
    private String phoneNumber;
    private int tennis;
    private int soccer;
    private int baseball;
    private int snooker;
    private int football;
    private int pingpong;
    public User() {
        //default constructor
    }
    public User(String username, String userId) {
        this.username = username;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getTennis() {
        return tennis;
    }

    public void setTennis(int tennis) {
        this.tennis = tennis;
    }

    public int getSoccer() {
        return soccer;
    }

    public void setSoccer(int soccer) {
        this.soccer = soccer;
    }

    public int getBaseball() {
        return baseball;
    }

    public void setBaseball(int baseball) {
        this.baseball = baseball;
    }

    public int getSnooker() {
        return snooker;
    }

    public void setSnooker(int snooker) {
        this.snooker = snooker;
    }

    public int getFootball() {
        return football;
    }

    public void setFootball(int football) {
        this.football = football;
    }

    public int getPingpong() {
        return pingpong;
    }

    public void setPingpong(int pingpong) {
        this.pingpong = pingpong;
    }
}
