package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlNotChanged {

    public static void main(String[] args) {

    /**
     * open chrome browser
     * go to http://practice.cydeo.com/forgot_password Links to an external site.
     * click on Retrieve password
     * verify that URL did not change
     *
     */

    // open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("ChRoMe");

     // go to http://practice.cydeo.com/forgot_password Links to an external site.
        driver.get("http://practice.cydeo.com/forgot_password");

        // save url before click
        String expectedUrl = driver.getCurrentUrl();

        // click on Retrieve Password
        // WebElement --> interface that represent elements on the webpage
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();

        // save url after click
        String actualUrl = driver.getCurrentUrl();

        // verify that url not change
        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //close browser after everything
        driver.quit();

    }

}
