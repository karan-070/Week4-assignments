package com.example.ComplaintsRobot.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Right {
    private Long id;
    private boolean isOpponent;
    private String name;
    private String type;
    private String reference;
    private List<Classification> classification;

    public Right() {
    }

    public Right(Long id, boolean isOpponent, String name, String type, String reference, List<Classification> classification) {
        this.id = id;
        this.isOpponent = isOpponent;
        this.name = name;
        this.type = type;
        this.reference = reference;
        this.classification = classification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOpponent() {
        return isOpponent;
    }

    public void setOpponent(boolean opponent) {
        isOpponent = opponent;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Classification> getClassification() {
        return classification;
    }

    public void setClassification(List<Classification> classification) {
        this.classification = classification;
    }
}