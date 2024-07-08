package org.booker.test;

import org.assertj.core.api.Assertions;
import org.booker.models.BookingResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class FilteringBookingTest extends BaseTest {

    private BookingResponse expectedBooking;

    @BeforeTest
    public void beforeTest() {
        this.expectedBooking = bookingService.createBooking(bookingData.generateDefaultBookingRequest());
    }

    @Test(description = "Фильтрация списка ID с созданными бронированиями (запрос GetBookingIds) на основе созданного бронирования. Проверить фильтрацию по имени")
    public void filterBookingTestByName() {

        var params = new HashMap<String, String>() {
            {
                put("firstname", expectedBooking.getBooking().getFirstName());
                put("lastname", expectedBooking.getBooking().getLastName());
            }
        };
        var actualIds = bookingService.getBookingIds(params);
        Assertions.assertThat(actualIds)
                .withFailMessage("actual booking id list is not contains %s", expectedBooking.getBookingId())
                .anyMatch(x -> x.getBookingId().equals(expectedBooking.getBookingId()));
    }

    @Test(description = "Фильтрация списка ID с созданными бронированиями (запрос GetBookingIds) на основе созданного бронирования. Проверить фильтрацию по дате заезда, выезда")
    public void filterBookingTestByDate() {

        var params = new HashMap<String, String>() {
            {
                put("checkin", expectedBooking.getBooking().getBookingDates().getCheckin());
                put("checkout", expectedBooking.getBooking().getBookingDates().getCheckout());
            }
        };
        var actualIds = bookingService.getBookingIds(params);
        Assertions.assertThat(actualIds)
                .withFailMessage("actual booking id list is not contains %s", expectedBooking.getBookingId())
                .anyMatch(x -> x.getBookingId().equals(expectedBooking.getBookingId()));
    }
}
