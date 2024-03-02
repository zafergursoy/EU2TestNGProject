package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }





    @Test
    public void test1() throws InterruptedException {

        driver.get("https://practice.cydeo.com/dynamic_loading/1");

        Thread.sleep(2000);

        // click start button
        driver.findElement(By.tagName("button")).click();

        // locate username inputbox
        WebElement usernameInputbox = driver.findElement(By.id("username"));

        // How to wait explicitly?
        // Create Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // calling until method from wait object
        wait.until(ExpectedConditions.visibilityOf(usernameInputbox));
        // wait.until(ExpectedConditions.invisibilityOf(loadingBar))   >> possible


        usernameInputbox.sendKeys("MikeSmith");

    }


    @Test
    public void test2(){

        driver.get("https://practice.cydeo.com/dynamic_controls");

        //click enable
        driver.findElement(By.xpath("//form[@id='input-example']/button")).click();

        // inputbox
        WebElement inputBox = driver.findElement(By.xpath("//form[@id='input-example']/input"));

        // create wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // explicit wait - wait until input box is clickable
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("MikeSmith");




    }


}
