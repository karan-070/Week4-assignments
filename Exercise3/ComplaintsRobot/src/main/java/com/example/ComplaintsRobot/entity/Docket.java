package com.example.ComplaintsRobot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Docket {
    private Long id;
    private String reference;
    private Long courtId;
    private String judge;

    public Docket() {
    }

    public Docket(Long id, String reference, Long courtId, String judge) {
        this.id = id;
        this.reference = reference;
        this.courtId = courtId;
        this.judge = judge;
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

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }
}