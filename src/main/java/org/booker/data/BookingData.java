package org.booker.data;

import org.booker.models.Booking;
import org.booker.utils.RandomUtils;

public class BookingData {

    public Booking generateDefaultBookingRequest() {
        return Booking.builder()
                .firstName(RandomUtils.generateFirstName())
                .lastName(RandomUtils.generateLastName())
                .depositPaid(RandomUtils.generateRandomDepositPaid())
                .totalPrice(RandomUtils.generateNumberBetween100And1000())
                .bookingDates(RandomUtils.generateBookingDates())
                .additionalNeeds(RandomUtils.generateAdditionalNeeds())
                .build();
    }
}
