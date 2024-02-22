package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals("title", "title");

        System.out.println("Second Assertion");
        Assert.assertEquals(1, 1);

    }

    @Test
    public void test2() {
        String expectedTitle = "Cyb";
        String actualTitle = "CyberTek";
        //verify that your title is starting with Cyb

        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "verify actualTitle starts with Cyb");
        Assert.assertTrue(2 > 1, "i am checking 2 greater than 1");

    }

    @Test
    public void test3(){
        //verify that email contains @
        String email = "mike@smith.com";

        Assert.assertTrue(email.contains("@"),"Verify email contains @ sign");

    }

    @Test
    public void test4() {

        Assert.assertFalse(1 > 2, "i am checking 1 NOT greater than 2");

    }

    @Test
    public void test5(){

        Assert.assertNotEquals("one","two","Verify one NOT equals two");

    }


}
