package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class mypractice1 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice.cydeo.com/multiple_buttons");

        WebElement multipleButtonsHeader = driver.findElement(By.xpath("//h3[@class='h3']"));

        System.out.println("multipleButtonsHeader.getText() = " + multipleButtonsHeader.getText());

        WebElement dontclick = driver.findElement(By.xpath("//button[contains(text(),'click')]"));

        dontclick.click();

    }


}
