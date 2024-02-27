package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/multiple_buttons");

        //save our Web Elements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("buttons.size() = " + buttons.size());

        //verify we have 6 button
        Assert.assertEquals(buttons.size(),6);
        
        // iter AND click >>>> for-each loop
        for (WebElement button : buttons) {
            System.out.println(button.getText());
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed());
        }

        //get only second button from the list
        buttons.get(1).click();

        driver.quit();



    }

    @Test
    public void test2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.tagName("sadgfsarggdsdf"));
        System.out.println("buttons.size() = " + buttons.size());

        driver.quit();


    }

}
