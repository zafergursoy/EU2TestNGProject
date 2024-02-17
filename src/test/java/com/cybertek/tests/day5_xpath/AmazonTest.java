package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr/");

        Thread.sleep(2000);

        WebElement acceptButton = driver.findElement(By.xpath("//input[@name='accept']"));
        acceptButton.click();


        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java");

        Thread.sleep(2000);



        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Git']"));
        searchButton.click();

        Thread.sleep(2000);

        // WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]"));

        WebElement resultText = driver.findElement(By.xpath("//span[contains(text(),'Aranan ürün:')]"));


        System.out.println(resultText.getText());

        Thread.sleep(2000);

        driver.quit();



    }

}
