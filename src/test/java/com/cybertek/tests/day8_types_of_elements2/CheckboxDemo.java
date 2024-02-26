package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/checkboxes");
        driver.manage().window().maximize();

        WebElement checbox1 = driver.findElement(By.cssSelector("#checkboxes>input:nth-of-type(1)"));    /// CTRL + D   copy and paste below
        WebElement checbox2 = driver.findElement(By.cssSelector("#checkboxes>input:nth-of-type(2)"));  //  (By.xpath("//input[1]"))

        // how to verify checkbox is selected or not?
        System.out.println("checbox1.isSelected() = " + checbox1.isSelected());
        System.out.println("checbox2.isSelected() = " + checbox2.isSelected());

        //verify checkbox 1 is NOT selected, 2 is selected
        Assert.assertFalse(checbox1.isSelected(),"verify checkbox 1 is NOT selected");
        Assert.assertTrue(checbox2.isSelected(),"verify checkbox 2 is selected");

        //how to click checkbox?
        checbox1.click();

        //************* AFTER CLICK **************
        System.out.println("*************AFTER CLICK************");
        System.out.println("checbox1.isSelected() = " + checbox1.isSelected());
        System.out.println("checbox2.isSelected() = " + checbox2.isSelected());

        //verify checkboxes again
        Assert.assertTrue(checbox1.isSelected(),"verify checkbox 1 is selected");
        Assert.assertTrue(checbox2.isSelected(),"verify checkbox 2 is selected");



        Thread.sleep(5000);



        driver.quit();

    }


}
