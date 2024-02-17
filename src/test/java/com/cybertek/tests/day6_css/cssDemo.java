package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssDemo {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/multiple_buttons");

        WebElement dontclick = driver.findElement(By.cssSelector("button#disappearing_button"));

        System.out.println(dontclick.getText());

        driver.quit();




    }


}
