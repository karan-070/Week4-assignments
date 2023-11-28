package com.example.ComplaintsRobot.service;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

    public SearchResultPage(WebDriver driver, JavascriptExecutor js) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = js;
    }

    public void sortByCaseNumber(){
        WebElement sortResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@class=\"headersortedup\"]")));
        js.executeScript("arguments[0].scrollIntoView();",sortResult);
        sortResult.click();
    }

    public void openCase(String caseNo){
        WebElement caseNumber = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(caseNo)));
        caseNumber.click();
    }
}