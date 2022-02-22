package org.tcs;

import org.openqa.selenium.WebDriver;
import org.tcs.DataLoads.DataReader;
import org.tcs.PageObjects.TravelHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends  BaseTest{


    WebDriver driver;
    TravelHomePage travelHomePage;
   // By sectionElement= By.id("flightSearchContainer");

    @BeforeTest
    public void setUp(){
        driver=initializeDriver();
        travelHomePage=new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String> reservationDetails){

        travelHomePage.goTo();
       // travelHomePage.getFooterNav().selectFlight();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinksCount());
        System.out.println(travelHomePage.getNavBar().getLinksCount());

      //  travelHomePage.setBookingStrategy(new MultiTrip(driver,sectionElement));
        travelHomePage.setBookingStrategy("multitrip");

        travelHomePage.checkAvail(reservationDetails);
        //one way , round trip, multi trip - checkAvailibility(origin,destination
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        /*HashMap<String,String> reservationDetails=new HashMap<String,String>();
        reservationDetails.put("origin","MAA");
        reservationDetails.put("destination","HYD");
        reservationDetails.put("destination2","DEL");
        HashMap<String,String> reservationDetails1=new HashMap<String,String>();
        reservationDetails1.put("origin","DEL");
        reservationDetails1.put("destination","HYD");
        reservationDetails1.put("destination2","MAA");
        List<HashMap<String,String>> l=new ArrayList<HashMap<String,String>>();
        l.add(reservationDetails);
        l.add(reservationDetails1);*/
        DataReader data=new DataReader();
        List<HashMap<String,String>> l=data.getJsonData(System.getProperty("user.dir")+"//Dataset//reservationDetails.json");
        return new Object[][]
                {
                        {l.get(0)},{l.get(1)}
        };

    }
}
