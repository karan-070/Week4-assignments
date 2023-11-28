package com.example.ComplaintsRobot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Classification {
    private String name;
    private String type;
    private Long classNo;
    private String images;

    public Classification() {
    }

    public Classification(String name, String type, Long classNo, String images) {
        this.name = name;
        this.type = type;
        this.classNo = classNo;
        this.images = images;
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

    public Long getClassNo() {
        return classNo;
    }

    public void setClassNo(Long classNo) {
        this.classNo = classNo;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}