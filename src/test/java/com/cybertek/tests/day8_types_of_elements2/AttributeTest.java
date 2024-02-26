package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AttributeTest {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/radio_buttons");

        WebElement radioButton = driver.findElement(By.id("blue"));

        //get the VALUE of attribute >>> type
        System.out.println(radioButton.getAttribute("type"));

        //get the VALUE of attribute >>> name
        System.out.println(radioButton.getAttribute("name"));

        //get the VALUE of attribute >>> checked
        System.out.println(radioButton.getAttribute("checked"));

        //get the VALUE of attribute >>> outerHTML    >>>get the FULL ELEMENT
        System.out.println(radioButton.getAttribute("outerHTML"));

        //////////////////////////////////////////////////////////////////////////////

        driver.get("https://practice.cydeo.com/multiple_buttons");
        WebElement button2 = driver.findElement(By.name("button2"));
        String button2Html = button2.getAttribute("outerHTML");

        System.out.println("button2Html = " + button2Html);

        String[] array1 = button2Html.split(">");
        array1 = array1[1].split("<");
        System.out.println(array1[0]);


        driver.quit();


    }

}
