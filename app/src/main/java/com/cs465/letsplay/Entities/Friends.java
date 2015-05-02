package com.cs465.letsplay.Entities;


/**
 * Created by Piyush on 4/29/2015.
 */
public class Friends {
    private String friendName;
    private int friendId;
    private String sportsName;
    private String sportsId;

    public Friends() {

    }

    public Friends(String friendName, int friendId) {
        this.friendName = friendName;
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getSportsName() {
        return sportsName;
    }

    public void setSportsName(String sportsName) {
        this.sportsName = sportsName;
    }

    public String getSportsId() {
        return sportsId;
    }

    public void setSportsId(String sportsId) {
        this.sportsId = sportsId;
    }
}
