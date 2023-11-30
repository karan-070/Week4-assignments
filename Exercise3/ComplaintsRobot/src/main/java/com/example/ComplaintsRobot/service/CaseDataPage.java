package com.example.ComplaintsRobot.service;
import com.example.ComplaintsRobot.entity.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class CaseDataPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;
    private final ApplicantDetails applicantDetails;
    private final Binder binder;



    public CaseDataPage(WebDriver driver, JavascriptExecutor js, ApplicantDetails applicantDetails, Binder binder) {
        this.driver = driver;
        this.js = js;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.applicantDetails = applicantDetails;
        this.binder = binder;

    }

    public void getCaseData(){
        Decision decision = new Decision();
        Docket docket = new Docket();
        List<Decision> decisionList = new ArrayList<>();
        List<Docket> docketList = new ArrayList<>();

        String ipNumber = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ctrlTM_txtAppNr"))).getText();
        System.out.println("\nApplication Number Fetched");
        applicantDetails.setApplicationNumber(Long.valueOf(ipNumber));

        String judgementDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"MainContent_ctrlTM_tblCaseData\"]/div/table//tr/td[4]"))).getText();

        String decisionReference = "nz-nzipotm-op-" + ipNumber + "_" + judgementDate + "_" + "_Complaint_IS";
        String docketReference = "nz-nzipotm-op-" + ipNumber + "_" + judgementDate;

        decision.setReference(decisionReference);
        docket.setReference(docketReference);

        decision.setJudgmentDate(judgementDate);

        decisionList.add(decision);
        docketList.add(docket);

        binder.setDockets(docketList);
        binder.setDecisions(decisionList);

    }
    public void getApplicantData() {
        String applicantName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='MainContent_ctrlTM_ctrlApplicant_ctrlApplicant_gvCustomers']//tr[@class='alt1']/td[2]"))).getText();
        String applicantAddress = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='MainContent_ctrlTM_ctrlApplicant_ctrlApplicant_gvCustomers']//tr[@class='alt1']/td[3]"))).getText();
        System.out.println("\nApplicant Fetched");
        applicantDetails.setApplicantName(applicantName);
        applicantDetails.setApplicantAddress(applicantAddress);

        System.out.println(applicantName);
        System.out.println(applicantAddress);
    }

    public void getMarkInformation(String downloadPath) {
        Classification classification = new Classification();
        Right right = new Right();

        WebElement classData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='MainContent_ctrlTM_tblClass']/table//tr/td[1]")));
        js.executeScript("arguments[0].scrollIntoView();",classData);
        String goodsAndServiceClass = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id=\"MainContent_ctrlTM_ctrlClassif_gvClassifications\"]//tr[@class=\"alt1\"]/td[1]"))).getText();
        System.out.println("\nClass Fetched");
        classification.setClassNo(Long.valueOf(goodsAndServiceClass));

        System.out.println(goodsAndServiceClass);

        WebElement tmData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='MainContent_ctrlTM_tblClass']/table//tr/td[1]")));
        js.executeScript("arguments[0].scrollIntoView();",tmData);
        String tmName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@id=\"MainContent_ctrlTM_trTMName\"]/td[2]"))).getText();
        String tmType = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@id=\"MainContent_ctrlTM_trTMType\"]/td[2]"))).getText();
        System.out.println("\nMark Fetched");
        classification.setName(tmName);
        classification.setType(tmType);

        WebElement tmImage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ctrlTM_ctrlPictureList_lvDocumentView_hlnkCasePicture_0")));
        String imgURL = tmImage.getAttribute("thmb");
        try (InputStream in = new URL(imgURL).openStream()) {
            Path imgFile = Paths.get(downloadPath,"Tm_Image.jpg");
            Files.copy(in, imgFile, StandardCopyOption.REPLACE_EXISTING);

            //Image to String
            byte[] imageBytes = Files.readAllBytes(imgFile);
            String imageString = Base64.getEncoder().encodeToString(imageBytes);
            classification.setImages(imageString);

            System.out.println(imageString);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(tmName);
        System.out.println(tmType);

        List <Classification> classificationList = new ArrayList<>();
        classificationList.add(classification);

        right.setClassification(classificationList);

        List<Right> rightList = new ArrayList<>();
        rightList.add(right);

        binder.setRights(rightList);
    }


    public void getRedParty() {
        List<Party> partyList = new ArrayList<>();
        Party party = new Party();

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        String caseType = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id=\"MainContent_ctrlProcedureList_gvwIPCases\"]//tr[@class=\"alt1\"]/td[2]"))).getText();
        String redPartyName = "";
        if(caseType.contains("Proceedings")){
            redPartyName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id=\"MainContent_ctrlProcedureList_gvwIPCases\"]//tr[@class=\"alt1\"]/td[7]"))).getText();
        }
        System.out.println("\nRed Party Fetched");
        System.out.println(redPartyName);
        party.setName(redPartyName);
        partyList.add(party);

        binder.setParties(partyList);
    }

    public void getFirstActinInfo() {
        WebElement historyTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id=\"MainContent_liHistories\"]")));
        historyTab.click();
        System.out.println("\nHistory Tab Clicked");

        //First Action
        String faType = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id=\"MainContent_ctrlHistoryList_gvHistory\"]//tr[@class=\"alt1\"]/td[1]"))).getText();
        String fafd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id=\"MainContent_ctrlHistoryList_gvHistory\"]//tr[@class=\"alt1\"]/td[3]"))).getText();
        System.out.println("\nFirst Action Fetched");
        binder.setFirstAction(faType);
        binder.setFirstActionDate(fafd);

        System.out.println(faType);
        System.out.println(fafd);
    }


}
