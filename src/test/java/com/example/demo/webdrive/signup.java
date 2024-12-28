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


public class signup {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("http://localhost:3000/register");
    }


    @Test
    void testValideInformation() throws InterruptedException {

        WebElement username = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[1]"));
        username.sendKeys("a2");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[2]"));
        email.sendKeys("a2@gmail.com");

        WebElement pwd = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[3]"));
        pwd.sendKeys("test");

        WebElement btn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/button"));
        btn.click();
        Thread.sleep(1000);

        WebElement errMesg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/form/div")));
        Assertions.assertEquals("Calculator enregistré avec succès. Veuillez vérifier votre e-mail.", errMesg.getText(), "Error message does not match.");
        Thread.sleep(1000);

    }

    @Test
    void testInvalideUserName() throws InterruptedException {

        WebElement username = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[1]"));
        username.sendKeys("root");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[2]"));
        email.sendKeys("testmyemail@gmail.com");

        WebElement pwd = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[3]"));
        pwd.sendKeys("test");

        WebElement btn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/button"));
        btn.click();
        Thread.sleep(1000);


        WebElement errMesg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/form/div")));
        Assertions.assertEquals("Nom d'utilisateur déjà pris.", errMesg.getText(), "Error message does not match.");

    }

    @Test
    void testInvalideEmail() throws InterruptedException {

        WebElement username = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[1]"));
        username.sendKeys("myusernametotest");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[2]"));
        email.sendKeys("root@gmail.com");

        WebElement pwd = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[3]"));
        pwd.sendKeys("test");

        WebElement btn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/button"));
        btn.click();
        Thread.sleep(1000);


        WebElement errMesg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/form/div")));
        Assertions.assertEquals("Nom d'utilisateur déjà pris.", errMesg.getText(), "Error message does not match.");

    }


    @Test
    void testInvalideEmailAndIvalideUserName() throws InterruptedException {

        WebElement username = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[1]"));
        username.sendKeys("root");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[2]"));
        email.sendKeys("root@gmail.com");

        WebElement pwd = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[3]"));
        pwd.sendKeys("test");

        WebElement btn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/button"));
        btn.click();
        Thread.sleep(1000);


        WebElement errMesg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/form/div")));
        Assertions.assertEquals("Calculator enregistré avec succès. Veuillez vérifier votre e-mail.", errMesg.getText(), "Error message does not match.");

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}