package org.booker.test;

import lombok.extern.slf4j.Slf4j;
import org.booker.data.BookingData;
import org.booker.services.BookingService;
import org.testng.annotations.BeforeSuite;

@Slf4j
public class BaseTest {
    protected BookingService bookingService;
    protected BookingData bookingData;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        log.info("Running test before suite");
        bookingService = new BookingService();
        bookingData = new BookingData();
    }
}
