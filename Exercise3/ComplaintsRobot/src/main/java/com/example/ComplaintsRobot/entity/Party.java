package com.example.ComplaintsRobot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Party {
    private String name;
    private String type;
    private List<String> representatives;

    public Party() {
    }

    public Party(String name, String type, List<String> representatives) {
        this.name = name;
        this.type = type;
        this.representatives = representatives;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getRepresentatives() {
        return representatives;
    }

    public void setRepresentatives(List<String> representatives) {
        this.representatives = representatives;
    }
}