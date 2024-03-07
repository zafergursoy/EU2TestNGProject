package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/tables");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    // locate tr  -->  (//tr)[td[.='Doe']][td[.='Jason']]
    // locate td  -->  //td[.='Jason']

    @Test
    public void printTable(){

        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));

        System.out.println(table1.getText());


    }


    @Test
    public void getAllHeaders(){

        // How many columns we have??
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println("headers.size() = " + headers.size());

        // print each column name one by one

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }



    }


    @Test
    public void printTableSize(){

        // How many columns we have??
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println("headers.size() = " + headers.size());

        // How many rows we have?? with header row
        List<WebElement> rowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));

        System.out.println("rowsWithHeader.size() = " + rowsWithHeader.size());

        // How many rows we have?? without header row --> we prefer

        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("(//table[@id='table1']//tr)[td]"));   //table[@id='table1']/tbody/tr

        System.out.println("rowsWithoutHeader.size() = " + rowsWithoutHeader.size());



    }


    @Test
    public void getRow(){

        // print the first row information

        List<WebElement> row1 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]"));

        System.out.println("row1.size() = " + row1.size());

        // print each column name one by one

        for (WebElement header : row1) {
            System.out.println(header.getText());
        }

        System.out.println();
        /////////////////////////// OR   //////////////////////////////////////////////////////////////////////

        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));

        System.out.println(row2.getText());

        System.out.println();
        ///////// ALL ROWS //////////////////////////////////////////////////////////////////

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <= rows.size(); i++) {
            System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]")).getText());
        }



    }


    @Test
    public void getAllCellsInOneRow(){

        List<WebElement> allCells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));

        System.out.println("allCells.size() = " + allCells.size());

        for (WebElement allCell : allCells) {
            System.out.println(allCell.getText());
        }


    }


    @Test
    public void getOneCell(){

        WebElement oneCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]"));

        System.out.println(oneCell.getText());

    }


    @Test
    public void allCells() throws InterruptedException {

        // How many columns we have??
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        // How many rows we have?? without header row --> we prefer
        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("(//table[@id='table1']//tr)[td]"));   //table[@id='table1']/tbody/tr
        System.out.println("rowsWithoutHeader.size() = " + rowsWithoutHeader.size());


        for (int i = 1; i <= rowsWithoutHeader.size(); i++) {
            for (int j = 1; j <= headers.size(); j++) {
                String cellXpath = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
                System.out.println(cellXpath);
                String cellText = driver.findElement(By.xpath(cellXpath)).getText();
                System.out.println(cellText);
            }

        }




    }


    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

        String firstName = "John";
        String xpath = "//table[@id='table1']//td[.='" + firstName + "']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());

    }







}
