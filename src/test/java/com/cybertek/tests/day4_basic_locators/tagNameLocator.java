package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/sign_up");

        WebElement fullNameInputbox = driver.findElement(By.tagName("input"));
        fullNameInputbox.sendKeys("Mike Smith");

        WebElement emailInputbox = driver.findElement(By.name("email"));
        emailInputbox.sendKeys("mike@smith.com");

        WebElement signUpButton = driver.findElement(By.tagName("button"));
        signUpButton.click();

    }

}
