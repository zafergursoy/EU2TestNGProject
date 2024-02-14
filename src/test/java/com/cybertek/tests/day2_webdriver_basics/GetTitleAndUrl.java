package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cydeo.com");
//        driver.get("https://www.facebook.com");

        String title = driver.getTitle();  // ALT + Enter + Enter driver.getTitle()
        System.out.println("title = " + title);  // soutv  --> Enter

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        System.out.println("**********************************************************************");

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);


    }


}
