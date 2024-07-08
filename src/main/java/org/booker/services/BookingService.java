package org.booker.services;

import org.booker.StatusCode;
import org.booker.api.BaseApi;
import org.booker.models.Booking;
import org.booker.models.BookingId;
import org.booker.models.BookingResponse;

import java.util.List;
import java.util.Map;

public class BookingService extends BaseApi {

    private static final String BOOKING_ENDPOINT = "booking";

    public BookingResponse createBooking(Booking bookingToCreate) {
        var response = post(BOOKING_ENDPOINT, bookingToCreate);
        assertStatusCode(response, StatusCode.Status200OK);
        return response.as(BookingResponse.class);
    }

    public Booking getBookingDetails(Integer bookingId) {
        var response = get(BOOKING_ENDPOINT, bookingId.toString());
        assertStatusCode(response, StatusCode.Status200OK);
        return response.as(Booking.class);
    }

    public List<BookingId> getBookingIds(Map<String, String> params) {
        var response = get(BOOKING_ENDPOINT, params);
        assertStatusCode(response, StatusCode.Status200OK);
        return response.jsonPath().getList("", BookingId.class);
    }
}
