package org.booker.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @JsonProperty(value = "firstname")
    private String firstName;
    @JsonProperty(value = "lastname")
    private String lastName;
    @JsonProperty(value = "totalprice")
    private Integer totalPrice;
    @JsonProperty(value = "depositpaid")
    private Boolean depositPaid;
    @JsonProperty(value = "bookingdates")
    private BookingDates bookingDates;
    @JsonProperty(value = "additionalneeds")
    private String additionalNeeds;
}
