package com.example.Navigate.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clarivate")
public class NavigateController {

    @GetMapping("/getInfo")
    public List<Map<String, String>> getInfo() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://clarivate.com/");

            WebElement navigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("menu-item-7")));
            navigation.click();

            By subMenuLocator = By.cssSelector(".subnav-col.border-left");
            WebElement subMenu = wait.until(ExpectedConditions.presenceOfElementLocated(subMenuLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subMenu);

            List<Map<String, String>> result = new ArrayList<>();

            for (int i = 1; i <= 7; i++) {
                String mainHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-7 > div > div > div > div > div > div:nth-child(" + i + ") > p > a")))
                        .getText();

                String subHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-7 > div > div > div > div > div > div:nth-child(" + i + ")")))
                        .getText().replace("\n", ",");
                if (i > 1) {
                    String[] subHeadingArray = subHeading.trim().split(",");
                    subHeading = String.join(",", Arrays.copyOfRange(subHeadingArray, 1, subHeadingArray.length));
                }
                // Create a map for each entry
                Map<String, String> entry = new HashMap<>();
                entry.put("Title" + "->", mainHeading);
                entry.put("Subtitles" + "->", subHeading);

                result.add(entry);
            }

            return result;

        } finally {
            driver.quit();
        }
    }
}
//"#menu-item-7 > div > div > div > div > div > div:nth-child(1)"