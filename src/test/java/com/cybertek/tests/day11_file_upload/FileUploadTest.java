package com.cybertek.tests.day11_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadTest {

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
    public void test1(){
        driver.get("https://practice.cydeo.com/upload");

        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src\\test\\resources\\testfile.txt";
        String filePath = projectPath + "\\" + relativePath;
        System.out.println("filePath = " + filePath);

        // hold shift and right click on file ->> on pop-up ->> select copy as path
        chooseFile.sendKeys(filePath);
        //chooseFile.sendKeys("C:\\Users\\Zafer\\OneDrive\\Desktop\\file.txt");

        // click submit to upload chosen file
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        // wait until "File Uploaded" message can be seen on the screen
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[.='File Uploaded!']"))));

        // get the uploaded file name from next screen
        String resultPath = driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText();

        // compare chosen file name and uploaded file name
        Assert.assertEquals(resultPath,"testfile.txt");



    }

}
