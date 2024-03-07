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

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://practice.cydeo.com/hovers");
        Thread.sleep(1000);

        Actions actions = new Actions(driver);

        for (int i = 1; i < 4; i++) {

            actions.moveToElement(driver.findElement(By.xpath("(//div[@class='figure']/img)[" + i + "]"))).perform();
            Thread.sleep(2000);
            WebElement link = driver.findElement(By.linkText("View profile"));
            Assert.assertTrue(link.isDisplayed(),"verify View profile link is displayed");
            String userName = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[" + i + "]")).getText();
            String expectedUserName = "name: user" + i;
            Assert.assertEquals(userName,expectedUserName,"user names are same.");
            System.out.println("Actual UserName : " + userName + " <---> " + expectedUserName + " : Expected User Name ");
        }




    }



}
