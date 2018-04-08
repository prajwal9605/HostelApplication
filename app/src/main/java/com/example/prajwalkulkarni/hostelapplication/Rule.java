package com.example.prajwalkulkarni.hostelapplication;

/**
 * Created by Prajwal kulkarni on 4/8/2018.
 */

public class Rule {
    String type;
    String description;

    public Rule(){

    }
    public Rule(String description,String type) {
        this.description = description;
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
