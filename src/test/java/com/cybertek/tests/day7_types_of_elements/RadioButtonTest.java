package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void radioBtnTest1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        //how to check is radio button selected?
        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());

        //Task verify blue is selected, red is not selected
        Assert.assertFalse(redRadioButton.isSelected(),"verify red is NOT selected");
        Assert.assertTrue(blueRadioButton.isSelected(),"verify blue is selected");

        //how to select radio button?
        //we use click method to select radio buttons
        redRadioButton.click();

        Assert.assertTrue(redRadioButton.isSelected(),"verify red is selected");
        Assert.assertFalse(blueRadioButton.isSelected(),"verify blue is NOT selected");


        driver.quit();




    }




}
