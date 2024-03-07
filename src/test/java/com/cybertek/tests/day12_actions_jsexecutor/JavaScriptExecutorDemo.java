package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void clickWithJS() throws InterruptedException {

        driver.get("http://practice.cydeo.com");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));

        //clicking with JavaScript Executor
        //create js executor object

        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // use executescript
        // how to click with javascript using selenium --> google --> stackoverflow.com

        // Assume driver is a valid WebDriver instance that
        // has been properly instantiated elsewhere.
        //WebElement element = driver.findElement(By.id("gbqfd"));
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", dropdownLink);




    }


    @Test
    public void type() throws InterruptedException {

        driver.get("https://practice.cydeo.com/dynamic_controls");

        WebElement inputbox = driver.findElement(By.xpath("//form[@id='input-example']/input"));

        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].value='enter the value here';", inputbox);

        Thread.sleep(2000);


    }


    @Test
    public void scrollDownandUp() throws InterruptedException {

        driver.get("https://practice.cydeo.com/");

        Thread.sleep(1000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,250)");
            Thread.sleep(1000);
        }

        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,-250)"); //XXX scroll XXX only once
            Thread.sleep(1000);
        }




    }






}
