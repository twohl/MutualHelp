package com.script.entity;

import javafx.scene.chart.PieChart;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class NoMoneyWork implements Serializable{
    private int id;
    private String name;
    private User organiser;
    private User accpter;
    private int status;
    private Date organTime;
    private Date accTime;
    private Note note;

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

    public User getAccpter() {
        return accpter;
    }

    public void setAccpter(User accpter) {
        this.accpter = accpter;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getOrganTime() {
        return organTime;
    }

    public void setOrganTime(Date organTime) {
        this.organTime = organTime;
    }

    public Date getAccTime() {
        return accTime;
    }

    public void setAccTime(Date accTime) {
        this.accTime = accTime;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
