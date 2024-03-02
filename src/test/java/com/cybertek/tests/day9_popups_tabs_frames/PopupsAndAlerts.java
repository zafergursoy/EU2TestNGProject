package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

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
    public void test() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        Thread.sleep(2000);

        //locate and click "destroy theworld
        driver.findElement(By.xpath("//button[.='Confirm']")).click();

        Thread.sleep(2000);

        //Locate and click NO Button
        driver.findElement(By.xpath("//button[.='No']")).click();
    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("https://practice.cydeo.com/javascript_alerts");

        // locate click the Click for JS alert button
        driver.findElement(By.xpath("//button[1]")).click();

        //switch to JS alert windows
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        //click OK button on the alert
        alert.accept();

        Thread.sleep(2000);


        //Click on Click For JS Confirm
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        //click OK button on the alert
        alert.dismiss();


        //click for JS Prompt
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);
        //send keys to alert and click OK
        alert.sendKeys("Mike Smith");
        alert.accept();



    }


}
