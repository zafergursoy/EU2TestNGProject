package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");

        //can moved here
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        // Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {

        driver.get("https://practice.cydeo.com/dynamic_loading/4");

        //1. way - Thread.sleep
        // Thread.sleep(6000);

        // 2. way - implicit wait (wait to loading element, ask element is ready??)
        // wait up to 20 seconds
        // moved to Before method
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String message = driver.findElement(By.cssSelector("#finish")).getText();
        System.out.println(message);

        // implicit wait only looks for the searching element is whether part of HTML or not..
        // doesn't care clickable or visible..


    }


}
