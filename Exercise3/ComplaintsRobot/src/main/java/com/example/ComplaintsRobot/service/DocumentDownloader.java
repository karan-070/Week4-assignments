package com.example.ComplaintsRobot.service;


import com.example.ComplaintsRobot.entity.Binder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class DocumentDownloader {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

    public DocumentDownloader(WebDriver driver, JavascriptExecutor js) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = js;
    }

    public void getPDF(String downloadPath){
        WebElement documentTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id=\"MainContent_liDocuments\"]")));
        documentTab.click();
        System.out.println("\nDocument Tab Clicked");

        WebElement pdfLink = driver.findElement(By.id("MainContent_ctrlDocumentList_gvDocuments_hnkView_0"));
        String pdfUrl = pdfLink.getAttribute("href");

        try (InputStream in = new URL(pdfUrl).openStream()) {
            Path pdfFile = Paths.get(downloadPath,"decision_reference.pdf");
            Files.copy(in, pdfFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("PDF Downloaded at: "+ pdfFile.toAbsolutePath());

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void writeToJsonFIle(String downloadPath, Binder binder) {
        try{
            String binderResponse = convertToString(binder);
            Path outputPath = Paths.get(downloadPath,"decision_reference.js");
            Files.write(outputPath, binderResponse.getBytes());


        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    public static String convertToString(Binder binder) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(binder);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
