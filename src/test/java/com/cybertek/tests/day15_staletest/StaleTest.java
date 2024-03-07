package com.cybertek.tests.day15_staletest;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class StaleTest extends TestBase {

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.google.com");

        WebElement input = driver.findElement(By.tagName("textarea"));
        input.sendKeys("Selenium" + Keys.ENTER);

        WebElement results = driver.findElement(By.id("result-stats"));
        Assert.assertTrue(results.isDisplayed());

                                    String resultsText = results.getText();                 /// EXTRA
                                    String[] resultArray = resultsText.split(" ");    /// EXTRA
                                    System.out.println(resultArray[1]);                     /// EXTRA

        // go to google again
        driver.navigate().back();

        input = driver.findElement(By.tagName("textarea"));     //// WE HAVE TO FIND ELEMENT AGAIN, AFTER BACK, REFRESH ETC.
        input.sendKeys("Java" + Keys.ENTER);

        results = driver.findElement(By.id("result-stats"));     //// WE HAVE TO FIND ELEMENT AGAIN, AFTER BACK, REFRESH ETC.
        Assert.assertTrue(results.isDisplayed());


                                    resultsText = results.getText();                 /// EXTRA
                                    resultArray = resultsText.split(" ");    /// EXTRA
                                    System.out.println(resultArray[1]);            /// EXTRA





    }


}
