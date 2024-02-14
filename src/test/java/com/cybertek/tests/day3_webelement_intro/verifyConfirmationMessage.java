package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) throws InterruptedException {

        /**
         * Verify confirmation message
         * open browser
         * go to http://practice.cydeo.com/forgot_password
         * enter any email
         * verify that email is displayed in the input box
         * click on Retrieve password
         * verify that confirmation message says 'your email's been sent!'
         *
         */

        String expectedConfirmMsg = "Your e-mail's been sent!";

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cydeo.com/forgot_password");

        // save url before entering email and click
        String beforeUrl = driver.getCurrentUrl();

        // enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //* verify that email is displayed in the input box
        String expectedEmail = "test@gmail.com";
        emailInputBox.sendKeys(expectedEmail);

        // two ways to get text from web elements
        // 1.getText()  --> %99 work  return string
        // 2.getAttribute("value") --> second way especially input boxes

        String actualEmail = emailInputBox.getAttribute("value");

        if (actualEmail.equals(expectedEmail)) {
            System.out.println("PASS");          /// "PASS".sout --> enter
        } else {
            System.out.println("FAIL");          /// "FAIL".sout --> enter
            System.out.println("expectedEmail = " + expectedEmail);
            System.out.println("actualEmail = " + actualEmail);
        }

        //
        //enter button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        // enter any email
        WebElement confirmMsg = driver.findElement(By.name("confirmation_message"));
        String actualConfirmMsg = confirmMsg.getText();

        // compare messages
        if (expectedConfirmMsg.equals(actualConfirmMsg)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected message is -->" + expectedConfirmMsg);
            System.out.println("Actual message is -->" + actualConfirmMsg);
        }

        // wait 2 seconds
        Thread.sleep(3000);

        driver.quit();


        // HOW TO READ AN ERROR ????

        // 1. Go to Error, it is starting with EXCEPTION keyword.
        // 2. Read rest of the line to understand cause of the error.
        // 3. go find blue link at the end to find error line.




    }

}
