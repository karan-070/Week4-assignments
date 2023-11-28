package com.example.Leetcode.Controller;

import com.example.Leetcode.Resource.DataLoader;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/leetcode")
public class LeetcodeController {
    @GetMapping("/launch")
    public String getResults() throws InterruptedException, IOException {
        //String assignmentsWeek1 =" public class Week1 { public static void main (String[]args){ int[] a = {5, 7, 6, 9, 8, 1, -15, 2, 6}; int sum = 0; for (int num : a) { sum += num;} System.out.println(\"Sum: \" + sum);}}";
        //String assignmentsWeek1 = "public class Week1 { public static void main(String[] args) { int[] a = {5, 7, 6, 9, 8, 1, -15, 2, 6}; int sum = calculateSum(a); System.out.println(\"Question 1: Sum of the array is \" + sum); double average = calculateAverage(a); System.out.println(\"Question 2: Average of the array is \" + average); int[] b = {2, 4, 5, -3, 10, 6, 8, 1, 7}; int[] c = calculateC(a, b); System.out.print(\"Question 3: Array c = \"); for (int value : c) { System.out.print(value + \" \"); } String inputString = \"Welcome to Clarivate!\"; int length = calculateStringLength(inputString); System.out.println(\"\\nQuestion 4: Length of the string is \" + length); } private static int calculateSum(int[] array) { int sum = 0; for (int value : array) { sum += value; } return sum; } private static double calculateAverage(int[] array) { int sum = calculateSum(array); return (double) sum / array.length; } private static int[] calculateC(int[] a, int[] b) { int[] c = new int[a.length]; for (int i = 0; i < a.length; i++) { int max = Math.max(a[i], b[i]); c[i] = max + a[i] / b[i]; } return c; } private static int calculateStringLength(String inputString) { return inputString.length(); } }";
        String assignmentsWeek1 = DataLoader.loadCodeFromFile("code.txt");
        WebDriver driver = new ChromeDriver();
        driver.manage().

                timeouts().

                implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://leetcode.com/playground/UpwhGDg6");
        driver.manage().

                window().

                maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"langMenu\"]/div")));
        Element.click();

        WebElement javaButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[1]/div[2]/span/div/ul/div[2]")));
        javaButton.click();
        WebElement codeEditor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("editor")));
        Actions actions = new Actions(driver);
        actions.click(codeEditor).

                keyDown(Keys.CONTROL).

                sendKeys("a").

                keyUp(Keys.CONTROL).

                sendKeys(Keys.DELETE).

                build().

                perform();
        actions.sendKeys(codeEditor, assignmentsWeek1).

                build().

                perform();
        Thread.sleep(2000);
        WebElement runCodeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div > div > div > div.col-sm-7.editor-base > div.toolbar-base > div.left-side > button")));
        runCodeButton.click();
        Thread.sleep(5000);
        WebElement outputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"output\"]/div[2]")));
        String output = outputElement.getText();
        driver.quit();
        return output;

    }

}
