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

public class ForgetPwd {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("http://localhost:3000/forgot-password"); // Update URL if necessary
    }


    @Test
    void testInvalideEmail() throws InterruptedException {


        WebElement emailInPut = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailInPut.sendKeys("non@example.com");


        WebElement resetPwdBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/button"));
        resetPwdBtn.click();
        Thread.sleep(1000);

        WebElement errMesg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/form/div[2]")));
        Assertions.assertEquals("Calculattor non trouvé.", errMesg.getText(), "Error message does not match.");

    }

    @Test
    void testValideEmail() throws InterruptedException {


        WebElement emailInPut = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailInPut.sendKeys("test@example.com");


        WebElement resetPwdBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/button"));
        resetPwdBtn.click();
        Thread.sleep(1000);

        WebElement errMesg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/form/div[2]")));
        Assertions.assertEquals("Un e-mail avec votre nouveau mot de passe a été envoyé.", errMesg.getText(), "Error message does not match.");

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}