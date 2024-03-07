package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test(){

        String s1 = Singleton.getInstance();
        //100 lines of code
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

    }

    @Test
    public void test1(){

    //    WebDriver driver = WebDriverFactory.getDriver("chrome");

    //    driver.get("http://www.google.com");

    //    driver.quit();

        WebDriver driver = Driver.get();

        driver.get("http://www.google.com");

        driver.quit();

    }



    @Test
    public void test2(){

        WebDriver driver = Driver.get();    // we will use like this

        driver.get("http://www.amazon.com");    // all cases use point same driver-object.

        driver.quit();

    }

    @Test
    public void test3(){

        Driver.get().get("http://www.amazon.com");

        Driver.closeDriver();   // it closes the browser-driver
                                // if you don't use it,
                                // all test cases use same browser on the same java file.

    }



}
