package com.example.demo.webdrive;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class userProfile {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("http://localhost:3000/login");
    }


    @Test
    void AtestLogout() throws InterruptedException {

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("notaila7@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/button"));
        logoutBtn.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.urlContains("/login"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("/login"), "User should be redirected to /user-dashboard.");

    }

    @Test
    void BhistoriquePage() throws InterruptedException {

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("notaila7@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement hestoriqueBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/ul/li[2]/a"));
        hestoriqueBtn.click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.urlContains("/history"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("/history"), "User should be redirected to /user-dashboard.");

    }

    @Test
    void CcalculePage() throws InterruptedException {

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("notaila7@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement calculeBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/ul/li[1]/a"));
        calculeBtn.click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.urlContains("/polynomial-form"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("/polynomial-form"), "User should be redirected to /user-dashboard.");

    }


    @Test
    void DcalculeSymPyValid() throws InterruptedException {

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("notaila7@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement calculeInBut = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input"));
        calculeInBut.sendKeys("x2+1+x");

        WebElement sympyBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div/button[1]"));
        sympyBtn.click();
        Thread.sleep(1000);

        WebElement ExpressionSimplifiee = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div")));
        Assertions.assertNotEquals("Polynome irrecevable", ExpressionSimplifiee.getText(), "Error message does not match.");


    }

    @Test
    void EcalculeSymPyInalid() throws InterruptedException {

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("notaila7@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement calculeInBut = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input"));
        calculeInBut.sendKeys("1a");

        WebElement sympyBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div/button[1]"));
        sympyBtn.click();
        Thread.sleep(1000);

        WebElement ExpressionSimplifiee = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div")));
        Assertions.assertEquals("Polynôme irrecevable", ExpressionSimplifiee.getText(), "Error message does not match.");


    }




    @Test
    void FcalculeNewtonRaphsonValid() throws InterruptedException {

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("notaila7@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement calculeInBut = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input"));
        calculeInBut.sendKeys("x1+2");

        WebElement sympyBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div/button[2]"));
        sympyBtn.click();
        Thread.sleep(1000);

        WebElement ExpressionSimplifiee = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div")));
        Assertions.assertNotEquals("Polynome irrecevable", ExpressionSimplifiee.getText(), "Error message does not match.");


    }

    @Test
    void GcalculeNewtonRaphsonInalid() throws InterruptedException {

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("notaila7@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement calculeInBut = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input"));
        calculeInBut.sendKeys("1a");

        WebElement sympyBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div/button[2]"));
        sympyBtn.click();
        Thread.sleep(1000);

        WebElement ExpressionSimplifiee = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div")));
        Assertions.assertEquals("Polynôme irrecevable", ExpressionSimplifiee.getText(), "Error message does not match.");


    }



    @Test
    void HcalculeNumPyValid() throws InterruptedException {

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("notaila7@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement calculeInBut = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input"));
        calculeInBut.sendKeys("x1+2");

        WebElement sympyBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div/button[3]"));
        sympyBtn.click();
        Thread.sleep(1000);

        WebElement ExpressionSimplifiee = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div")));
        Assertions.assertNotEquals("Polynome irrecevable", ExpressionSimplifiee.getText(), "Error message does not match.");


    }

    @Test
    void IcalculeNumPyIvnalid() throws InterruptedException {

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("notaila7@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement calculeInBut = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input"));
        calculeInBut.sendKeys("1a");

        WebElement sympyBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div/button[3]"));
        sympyBtn.click();
        Thread.sleep(1000);

        WebElement ExpressionSimplifiee = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div")));
        Assertions.assertEquals("Polynôme irrecevable", ExpressionSimplifiee.getText(), "Error message does not match.");


    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}