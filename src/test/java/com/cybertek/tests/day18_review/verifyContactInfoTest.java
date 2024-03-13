package com.cybertek.tests.day18_review;

import com.cybertek.pages.ContactsInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    @Test
    public void contactDetailsTest() throws InterruptedException {

        extentLogger = report.createTest("Contact Info Verification");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        extentLogger.info("Login as a Sales Manager");

        loginPage.login(username,password);
        Thread.sleep(8000);

        extentLogger.info("Navigate to Customers -- Contacts");
        new DashboardPage().navigateToModule("Customers","Contacts");
        Thread.sleep(3000);

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        Thread.sleep(3000);

        extentLogger.info("Click on -mbrackstone9@example.com- email");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();
        Thread.sleep(3000);

        ContactsInfoPage contactsInfoPage = new ContactsInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactsInfoPage.fullName.getText();
        extentLogger.info("Verify full name is " + expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"Verify Full Name");

        extentLogger.info("Verify email is " + "mbrackstone9@example.com");
        Assert.assertEquals(contactsInfoPage.email.getText(),"mbrackstone9@example.com","Verify Email");

        extentLogger.info("Verify phone is " + "+18982323434");
        Assert.assertEquals(contactsInfoPage.phone.getText(),"+18982323434","Verify Phone");

        extentLogger.pass("PASS: Contact Info Test");

        Thread.sleep(3000);

    }


}
