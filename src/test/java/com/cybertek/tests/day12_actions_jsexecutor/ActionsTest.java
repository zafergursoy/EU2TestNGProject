package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {

        driver.get("https://practice.cydeo.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("(//div[@class='figure']/img)[1]"));

        // Actions(Selenium) --> class that contains all the user interactions
        // how to create actions object / passing driver as a constructor

        Thread.sleep(2000);

        Actions actions = new Actions(driver);

        //perform() --> perform the action, complete the action
        //moveToElement --> move your mouse to web element (hover over)
        actions.moveToElement(img1).perform();

        WebElement link = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(link.isDisplayed(),"verify View profile link is displayed");

        link.click();


    }



    @Test
    public void DragAndDrop() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Thread.sleep(4000);

        // Accept Cookies --> click
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();

        Thread.sleep(6000);

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        actions.dragAndDrop(source,target).perform();

        Thread.sleep(2000);



    }



    @Test
    public void DragAndDropChaining() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        // Accept Cookies --> click
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();

        Thread.sleep(9000);

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        // drag and drop without dragAndDrop method
        // if you are chaining actions, we add build() method before perform()
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();


        Thread.sleep(3000);


    }








}
