package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/dropdown");

        //1. locate your dropdown just like any other element
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2. create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //getOptions --> returns all the available options from the dropdown list
        List<WebElement> options = stateDropdown.getOptions();

        //print size of the options
        System.out.println("options.size() = " + options.size());

        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }


        driver.quit();



    }


    @Test
    public void test2() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/dropdown");

        //1. locate your dropdown just like any other element
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2. create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //verify that first selection is Select a State
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //HOW TO SELECT OPTIONS FROM DROPDOWN?
        //1. SELECT USING VISIBLE TEXT
        Thread.sleep(4000);
        stateDropdown.selectByVisibleText("Virginia");

        String expectedOption1 = "Virginia";
        String actualOption1 = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption1,expectedOption1);

        //2. SELECT USING INDEX
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        String expectedOption2 = "Wyoming";
        String actualOption2 = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption2,expectedOption2);

        //3. SELECT BY VALUE
        Thread.sleep(2000);
        stateDropdown.selectByValue("DC");
        String expectedOption3 = "District Of Columbia";
        String actualOption3 = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption3,expectedOption3);


        Thread.sleep(2000);
        driver.quit();



    }



}
