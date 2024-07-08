package org.booker.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookingId {
    @JsonProperty(value = "bookingid")
    private Integer bookingId;
}
