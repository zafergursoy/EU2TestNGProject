package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("User1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");


    }


    @Test
    public void wrongUsernameTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");




    }





}
