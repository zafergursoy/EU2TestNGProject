package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * Test Case
     * Open Browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();
        //same thing with thread.sleep(3000)
        BrowserUtils.waitFor(3);

        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(expectedSubtitle,actualSubtitle,"Verify Subtitles");

        //System.out.println("actualSubtitle = " + actualSubtitle);

        dashboardPage.navigateToModule("Activities","Calendar Events");

        //BrowserUtils.waitFor(5);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify Subtitles");


    }



}
