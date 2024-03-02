package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://practice.cydeo.com/iframe");

        Thread.sleep(2000);

        //how to switch frames
        //1. switch by using name or id attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        // clear before send keys
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");

        // 1 ST WAY
        //go back to first frame(main html)
        driver.switchTo().defaultContent();

        Thread.sleep(2000);

        // 2 ND WAY -- USING INDEX
        driver.switchTo().frame(0);
        // clear before send keys
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith - using index");

        Thread.sleep(2000);

        //second way to switch parent
        driver.switchTo().parentFrame();

        //3. USING WEB ELEMENT
        // Locating iframe with any valid locator

        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith - using WEB Element");


    }


    @Test
    public void test2(){

        driver.get("https://practice.cydeo.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 children --> left - middle -right
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        // HTML (defaultContent) --> first HTML
        //      frame-top (parentFrame) --> one level up
        //         0 left
        //         1 middle
        //         2 right
        //      frame-bottom

        // switch to parent -- frame top
        driver.switchTo().parentFrame();

        // switch to right frame
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        // to switch main html we can use default content
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());




    }




}
