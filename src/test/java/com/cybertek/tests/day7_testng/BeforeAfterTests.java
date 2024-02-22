package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterTests {


    @Test
    public void test1(){
        //WebDriver part .... went to beforemethod

        System.out.println("This is my test 1");
        System.out.println();

        //close browser, quit  .... went to aftermethod
    }


    @Test
    public void test2(){
        System.out.println("This is my test 2");
        System.out.println();

    }

    @Ignore
    @Test
    public void test3(){
        System.out.println("This is my test 3");
        System.out.println();

    }



    @BeforeMethod
    public void setUp(){
        //WebDriver part
        System.out.println("BEFORE METHOD HERE");
        System.out.println("WebDriver Part");
        System.out.println();

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("AFTER METHOD HERE");
        System.out.println("Driver quit");
        System.out.println();

    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("---BEFORE CLASS---");
        System.out.println("---RUNS ONLY ONE IN THE CLASS---");
        System.out.println();
    }

    @AfterClass
    public void afterClass(){
        System.out.println("---AFTER CLASS---");
        System.out.println("---RUNS ONLY ONE IN THE CLASS---");
        System.out.println("---GENERATE REPORT---");
        System.out.println();
    }



}
