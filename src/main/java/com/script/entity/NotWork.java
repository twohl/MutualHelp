package com.script.entity;

import java.io.Serializable;
import java.util.Date;

public class NotWork implements Serializable {
    private static final long serialVersionUID = 6;
    private int id;
    private String name;
    private User organiser;
    private User accepter;
    private double lng;
    private double lat;
    private Date  acctime;
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOrganiser() {
        return organiser;
    }

    public void setOrganiser(User organiser) {
        this.organiser = organiser;
    }

    public User getAccepter() {
        return accepter;
    }

    public void setAccepter(User accepter) {
        this.accepter = accepter;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Date getAcctime() {
        return acctime;
    }

    public void setAcctime(Date acctime) {
        this.acctime = acctime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
