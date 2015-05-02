package com.cs465.letsplay.Entities;


/**
 * Created by Piyush on 4/29/2015.
 */
public class Sports {
    private String sportsName;
    private String sportsId;
    private int sportsType; // 0 for outdoor, 1 for indoor

    public Sports() {

    }

    public Sports(String sportsName, String sportsId, int sportsType) {
        this.sportsName = sportsName;
        this.sportsId = sportsId;
        this.sportsType = sportsType;
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

    public void setSportsId(int sportsId) {
        //this.sportsId = sportsId;
    }

    public int getSportsType() {
        return sportsType;
    }

    public void setSportsType(int sportsType) {
        this.sportsType = sportsType;
    }
}
