package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);

        Thread.sleep(10000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/");

    }


    @Test
    public void loginAsStoreManager() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        loginPage.login(username,password);

        Thread.sleep(10000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/");



    }



}
