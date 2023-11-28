package com.example.ComplaintsRobot.service;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CaseStatusDialoguePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

    public CaseStatusDialoguePage(WebDriver driver, JavascriptExecutor js) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = js;
    }

    public void SelectCaseStatus(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("MainContent_ctrlTMSearch_ctrlCaseStatusSearchDialog_ctrlCaseStatusSearch_ctrlCaseStatusList_gvCaseStatuss_chckbxSelected_7"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("MainContent_ctrlTMSearch_ctrlCaseStatusSearchDialog_ctrlCaseStatusSearch_ctrlCaseStatusList_gvCaseStatuss_chckbxSelected_8"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@ui-button=\"ui-icon-accept\"]"))).click();

    }
}
