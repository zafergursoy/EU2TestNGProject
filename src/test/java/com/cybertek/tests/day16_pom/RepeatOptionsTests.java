package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalenderEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    /** VERIFY RADIO BUTTONS
     * Open Browser
     * Login as driver
     * Go to Activities -> Calendar Events
     * Click on create calendar events
     * Click on repeat
     * Verify that repeat every day is checked
     * Verify that repeat weekdays is not checked
     */

    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();
        //same thing with thread.sleep(3000)
        BrowserUtils.waitFor(3);        /////////////////////////////////////

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();   //////////////////////////////
        calendarEventsPage.createCalendarEvent.click();

        CreateCalenderEventsPage createCalenderEventsPage = new CreateCalenderEventsPage();
        createCalenderEventsPage.waitUntilLoaderScreenDisappear(); ////////////////////////////
        createCalenderEventsPage.repeat.click();

        Assert.assertTrue(createCalenderEventsPage.days.isSelected(),"Verify days radio button is checked");
        Assert.assertFalse(createCalenderEventsPage.weekday.isSelected(),"verify weekday is NOT checked");


    }

    /** VERIFY REPEAT OPTIONS
     * Open Browser
     * Login as driver
     * Go to Activities -> Calendar Events
     * Click on create calendar events
     * Click on repeat
     * Verify that repeat options are Daily, Weekly, Monthly, Yearly(in this order)
     */

    @Test
    public void test2(){

        new LoginPage().loginAsDriver();

        //same thing with thread.sleep(3000)
        BrowserUtils.waitFor(3);        /////////////////////////////////////

        new DashboardPage().navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();   //////////////////////////////
        calendarEventsPage.createCalendarEvent.click();

        CreateCalenderEventsPage createCalenderEventsPage = new CreateCalenderEventsPage();
        createCalenderEventsPage.waitUntilLoaderScreenDisappear(); ////////////////////////////
        createCalenderEventsPage.repeat.click();

        Select repeatDropdown = createCalenderEventsPage.repeatOptionsList();

        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

        List<WebElement> actualOptions = repeatDropdown.getOptions();

        List<String> actualList = new ArrayList<>();

        for (WebElement option : actualOptions) {
            //get the text of each web element and add to list of string
            actualList.add(option.getText());
        }

        //getting list with ready method
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);

        Assert.assertEquals(actualList,expectedList,"verify dropdown options");

        Assert.assertEquals(actualList2,expectedList,"verify dropdown options");    /// 2nd way


        BrowserUtils.waitFor(3);        /////////////////////////////////////


    }





}
