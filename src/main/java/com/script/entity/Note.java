package com.script.entity;

import java.io.Serializable;

public class Note implements Serializable {
    private int evaluateId ;
    private String content;

    public int getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(int evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
