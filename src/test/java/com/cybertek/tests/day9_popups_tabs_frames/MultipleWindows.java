package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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
    public void switchWindowsTest() throws InterruptedException {

        driver.get("https://practice.cydeo.com/windows");

        // get Title
        System.out.println("Title before new Window: " + driver.getTitle());

        //click CLICK HERE link
        Thread.sleep(2000);
        driver.findElement(By.linkText("Click Here")).click();

        // get title again
        Thread.sleep(2000);
        System.out.println("Title after new window: " + driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);

        //we will switch to new window
        Set<String> windowHandles = driver.getWindowHandles();
        
        System.out.println(windowHandles.size());

        for (String handle : windowHandles) {
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }


        // get Title
        // Thread.sleep(2000);
        // WebElement firstTitle = driver.findElement(By.xpath("//div[@id='content']/div[@class='example']/h3"));
        // System.out.println("firstTitle = " + firstTitle.getText());

        // click CLICK HERE button
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        // get Title
        // Thread.sleep(2000);
        // WebElement secondTitle = driver.findElement(By.xpath("//div[@class='example']/h3"));
        // System.out.println("secondTitle = " + secondTitle.getText());

        // get title AFTER SWITCHING WINDOW again
        Thread.sleep(2000);
        System.out.println("Title after new window: " + driver.getTitle());


    }

    @Test
    public void moreThan2Window() throws InterruptedException {

        driver.get("https://practice.cydeo.com/windows");

        Thread.sleep(2000);



        // Before title
        System.out.println("Before Switch: " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();

        Thread.sleep(2000);

        // recognizing how many window are there
        Set<String> windowHandles = driver.getWindowHandles();

        //loop through each window
        for (String handle : windowHandles) {
            //one by one change it
            driver.switchTo().window(handle);
            // whenever your title equals to your expected window title
            if(driver.getTitle().equals("New Window")){
                // stop on that window
                break;
            }
        }

        Thread.sleep(2000);

        // After title
        System.out.println("After Switch: " + driver.getTitle());

        System.out.println("Page Header is: " + driver.findElement(By.xpath("//div[@class='example']/h3[text()='New Window']")).getText());


    }





}
