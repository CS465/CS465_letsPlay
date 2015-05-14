package com.cs465.letsplay.Entities;


/**
 * Created by Piyush on 4/29/2015.
 */
public class Events {

    private String name;
    private String place;
    private String miles;
    private int icon;

    public Events(String name, String place, String miles, int icon){
        super();
        this.name = name;
        this.place = place;
        this.miles = miles;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }
    public String getPlace() {
        return place;
    }
    public String getMiles() {
        return miles;
    }
    public int getIcon() {
        return icon;
    }
}
