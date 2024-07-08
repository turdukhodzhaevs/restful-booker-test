package org.booker.test;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Slf4j
public class CreateBookingTest extends BaseTest {

    @Test(description = "Создание бронирования (запрос CreateBooking) и проверка того, что бронирование сохранено с верно указанными данными (запрос GetBooking)")
    public void createBooking() {
        var requestData = bookingData.generateDefaultBookingRequest();
        var expectedBooking = bookingService.createBooking(requestData);
        var actualBooking = bookingService.getBookingDetails(expectedBooking.getBookingId());
        Assertions.assertThat(actualBooking)
                .as("Check Booking")
                .isEqualTo(expectedBooking.getBooking());
    }
}
