package com.example.ComplaintsRobot.service;

import com.example.ComplaintsRobot.entity.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintsRobotService {
    public String runRobot() throws InterruptedException {

        ApplicantDetails applicantDetails = new ApplicantDetails();
        Classification classification = new Classification();
        Decision decision = new Decision();
        Docket docket = new Docket();
        Party party = new Party();
        Right right = new Right();
        Binder binder = new Binder();


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String downloadPath = "C:\\DartsIp\\NZipo";

        NZipotmComplaintHomePage nZipotmComplaintHomePage = new NZipotmComplaintHomePage(driver, js);
        CaseStatusDialoguePage caseStatusDialoguePage = new CaseStatusDialoguePage(driver,js);
        SearchResultPage searchResultPage = new SearchResultPage(driver,js);
        CaseDataPage caseDataPage = new CaseDataPage(driver,js,applicantDetails,binder);
        DocumentDownloader documentDownloader = new DocumentDownloader(driver,js);

        nZipotmComplaintHomePage.navigateToWebsite("https://app.iponz.govt.nz/app/Extra/IP/TM/Qbe.aspx?sid=638358481567740745&op=EXTRA_tm_qbe&fcoOp=EXTRA__Default&directAccess=true");
        nZipotmComplaintHomePage.clickClassificationStatusSearch();;
        nZipotmComplaintHomePage.clickSelectStatus();

        caseStatusDialoguePage.SelectCaseStatus();
        Thread.sleep(5000);

        nZipotmComplaintHomePage.clickSearchButton();
        Thread.sleep(5000);

        searchResultPage.sortByCaseNumber();
        Thread.sleep(5000);

        searchResultPage.openCase("1240739");

        caseDataPage.getCaseData();

        //Applicant
        caseDataPage.getApplicantData();

        //Mark Information
        caseDataPage.getMarkInformation(downloadPath);


        //Red Party
        caseDataPage.getRedParty();

        //HistoryTab
        caseDataPage.getFirstActinInfo();

        //Document Tab
        documentDownloader.getPDF(downloadPath);

        documentDownloader.writeToJsonFIle(downloadPath,binder);
        driver.quit();
        return "Success";
    }
}
