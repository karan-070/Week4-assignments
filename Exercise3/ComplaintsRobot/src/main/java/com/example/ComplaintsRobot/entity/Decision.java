package com.example.ComplaintsRobot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Decision {
    private Long id;
    private String reference;
    private String judgmentDate;
    private String level;
    private String nature;
    private String robotSource;

    public Decision() {
    }
    public Decision(Long id, String reference, String judgmentDate, String level, String nature, String robotSource) {
        this.id = id;
        this.reference = reference;
        this.judgmentDate = judgmentDate;
        this.level = level;
        this.nature = nature;
        this.robotSource = robotSource;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getJudgmentDate() {
        return judgmentDate;
    }

    public void setJudgmentDate(String judgmentDate) {
        this.judgmentDate = judgmentDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getRobotSource() {
        return robotSource;
    }

    public void setRobotSource(String robotSource) {
        this.robotSource = robotSource;
    }


}