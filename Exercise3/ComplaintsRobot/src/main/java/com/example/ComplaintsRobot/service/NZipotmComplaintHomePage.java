package com.example.ComplaintsRobot.service;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NZipotmComplaintHomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

    public NZipotmComplaintHomePage(WebDriver driver, JavascriptExecutor js){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = js;
    }

    public void navigateToWebsite(String url){
        driver.get(url);
    }

    public void clickClassificationStatusSearch(){
        WebElement classificationStatusSearch = wait.until(ExpectedConditions.elementToBeClickable(By.id("MainContent_ctrlTMSearch_hdrClassifStatusCriteria_header")));
        classificationStatusSearch.click();
    }

    public void clickSelectStatus(){
        WebElement selectStatusBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("MainContent_ctrlTMSearch_ctrlCaseStatusSearchDialog_lnkBtnSearch")));
        selectStatusBtn.click();
    }

    public void clickSearchButton(){
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement searchButton = driver.findElement(By.id("MainContent_ctrlTMSearch_lnkbtnSearch"));
        searchButton.click();
    }
}