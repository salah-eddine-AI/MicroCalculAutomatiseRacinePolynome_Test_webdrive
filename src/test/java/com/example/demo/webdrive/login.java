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
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;


public class login {

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
    void testLoginWithInvalidCredentials() {
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("invaliduser@example.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("wrongPassword123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement errorMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error-message")));
        Assertions.assertEquals("Nom d'utilisateur ou mot de passe incorrect.", errorMsg.getText(), "Error message does not match.");
    }


    @Test
    void testLoginWithValidEmailAndInvalidPassword() {
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("notaila7@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("wrongPassword123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement errorMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.error-message")));
        Assertions.assertEquals("Mot de passe incorrect.", errorMsg.getText(), "Error message does not match.");
    }

    @Test
    void testLoginWithInvalidEmailAndValidPassword() {
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("invalid@example.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement errorMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.error-message")));
        Assertions.assertEquals("Nom d'utilisateur ou mot de passe incorrect.", errorMsg.getText(), "Error message does not match.");
    }

    @Test
    void testRedirectToUserDashboard() throws InterruptedException {

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("notaila7@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.urlContains("/polynomial-form"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("/polynomial-form"), "User should be redirected to /user-dashboard.");
    }

    @Test
    void testRedirectToAdminDashboard() throws InterruptedException {
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("root@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("root");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(3000);

        wait.until(ExpectedConditions.urlContains("/manage-calculators"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("/manage-calculators"), "Admin should be redirected to /admin-dashboard.");
    }
    @Test
    void testRedirectToForgatPassword() throws InterruptedException {

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/p/span"));
        Thread.sleep(1000);
        loginButton.click();
        Thread.sleep(3000);

        wait.until(ExpectedConditions.urlContains("/forgot-password"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("/forgot-password"), "Admin should be redirected to /admin-dashboard.");
    }
    @Test
    void testRedirectToRegister() throws InterruptedException {


        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/p[2]/span"));
        Thread.sleep(1000);
        loginButton.click();
        Thread.sleep(3000);

        wait.until(ExpectedConditions.urlContains("/register"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("/register"), "Admin should be redirected to /admin-dashboard.");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
