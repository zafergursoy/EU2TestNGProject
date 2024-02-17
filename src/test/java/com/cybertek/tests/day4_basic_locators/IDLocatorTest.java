package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice.cydeo.com/multiple_buttons");

        // HOW TO IDENTIFY WEB ELEMENTS?

        // 1. Navigate to application
        // 2. open the source code (inspect on the element, input box, button etc.)
        // 3. Find the unique property for the element 1. id  2.name

        WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));

        dontClickButton.click();

        Thread.sleep(5000);

        driver.quit();



    }

}
