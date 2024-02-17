package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // make browser full screen
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/sign_up");

        WebElement fullNameInputbox = driver.findElement(By.name("full_name"));
        fullNameInputbox.sendKeys("Mike Smith");

        WebElement emailInputbox = driver.findElement(By.name("email"));
        emailInputbox.sendKeys("mike@smith.com");

        Thread.sleep(3000);

        // proper way
        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

        // lazy way
        // driver.findElement(By.name("wooden_spoon")).click();

//        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
//
//        WebElement actualMessageElement = driver.findElement(By.name("signup_message"));
//        String actualMessage = actualMessageElement.getText();
//
//        if(actualMessage.equals(expectedMessage)){
//            System.out.println("PASS");
//        }else{
//            System.out.println("FAIL");
//        }


        driver.quit();


    }
}
