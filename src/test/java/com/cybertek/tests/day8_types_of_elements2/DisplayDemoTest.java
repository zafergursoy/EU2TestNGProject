package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayDemoTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));


        //verify that username NOT displayed on the screen
        // click start button
        //verify that username displayed on the screen

        //verify that username NOT displayed on the screen
        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());
        Assert.assertFalse(usernameInput.isDisplayed(),"verify that username NOT displayed");

        // click start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
        startButton.click();

        //waiting the page fully loaded
        Thread.sleep(8000);

        //verify that username displayed on the screen
        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());
        Assert.assertTrue(usernameInput.isDisplayed(),"verify that username displayed");


        driver.quit();

    }



}
