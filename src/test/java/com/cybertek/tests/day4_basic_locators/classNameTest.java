package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/sign_up");

        Thread.sleep(2000);

        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();

        driver.get("https://practice.cydeo.com/multiple_buttons");

        //print multiple buttons title
        System.out.println(driver.findElement(By.className("h3")).getText());

        Thread.sleep(2000);

        driver.quit();



    }

}
