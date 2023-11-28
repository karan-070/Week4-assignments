package com.example.ComplaintsRobot.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDetails {


        private Long applicationNumber;
        private String applicantName;
        private String applicantAddress;

    public ApplicantDetails() {
    }

    public ApplicantDetails(Long applicationNumber, String applicantName, String applicantAddress) {
        this.applicationNumber = applicationNumber;
        this.applicantName = applicantName;
        this.applicantAddress = applicantAddress;
    }

    public Long getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(Long applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }
}
