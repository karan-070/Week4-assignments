package com.example.ComplaintsRobot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Binder {
    private Long id;
    private String firstAction;
    private String firstActionDate;
    private String domain;

    private List<Docket> dockets;
    private List<Decision> decisions;
    private List<Party> parties;
    private List<Right> rights;

    public Binder() {
    }

    public Binder(Long id, String firstAction, String firstActionDate, String domain, List<Docket> dockets, List<Decision> decisions, List<Party> parties, List<Right> rights) {
        this.id = id;
        this.firstAction = firstAction;
        this.firstActionDate = firstActionDate;
        this.domain = domain;
        this.dockets = dockets;
        this.decisions = decisions;
        this.parties = parties;
        this.rights = rights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstAction() {
        return firstAction;
    }

    public void setFirstAction(String firstAction) {
        this.firstAction = firstAction;
    }

    public String getFirstActionDate() {
        return firstActionDate;
    }

    public void setFirstActionDate(String firstActionDate) {
        this.firstActionDate = firstActionDate;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<Docket> getDockets() {
        return dockets;
    }

    public void setDockets(List<Docket> dockets) {
        this.dockets = dockets;
    }

    public List<Decision> getDecisions() {
        return decisions;
    }

    public void setDecisions(List<Decision> decisions) {
        this.decisions = decisions;
    }

    public List<Party> getParties() {
        return parties;
    }

    public void setParties(List<Party> parties) {
        this.parties = parties;
    }

    public List<Right> getRights() {
        return rights;
    }

    public void setRights(List<Right> rights) {
        this.rights = rights;
    }
}
