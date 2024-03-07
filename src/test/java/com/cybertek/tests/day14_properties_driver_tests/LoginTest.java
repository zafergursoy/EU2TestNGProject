package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {


    @Test
    public void test1(){

        driver.get(ConfigurationReader.get("url"));    // old usage -->    driver.get("https://qa1.vytrack.com");
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password+ Keys.ENTER);


    }




}
