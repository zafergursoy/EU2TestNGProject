package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {

    public static void main(String[] args) throws InterruptedException {

        /**
         * Verify URL Changed
         * open browser
         * go to http://practice.cydeo.com/forgot_password
         * enter any email
         * click on Retrieve password
         * verify that url changed to http://practice.cydeo.com/email_sent
         *
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cydeo.com/forgot_password");

        // save url before entering email and click
        String beforeUrl = driver.getCurrentUrl();

        // enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("test@gmail.com");

        //enter button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        // save url after click
        String afterUrl = driver.getCurrentUrl();

        // compare url
        if(beforeUrl.equals(afterUrl)){
            System.out.println("URL not changed");
        }else{
            System.out.println("URL changed");
            System.out.println("Before URL is -->" + beforeUrl);
            System.out.println("After URL is -->" + afterUrl);
        }

        // wait 2 seconds
        Thread.sleep(3000);

        driver.quit();


    }


}
