package org.booker.utils;

import com.github.javafaker.Faker;
import org.booker.models.BookingDates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RandomUtils {
    private static final Faker faker = new Faker();
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }
    
    public static Boolean generateRandomDepositPaid(){
        return faker.bool().bool();
    }

    public static int generateNumberBetween100And1000() {
        return faker.number().numberBetween(100, 1000);
    }

    public static String generateAdditionalNeeds() {
        return faker.yoda().quote();
    }

    public static BookingDates generateBookingDates() {
        return BookingDates.builder()
                .checkin(LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                .checkout(LocalDate.now().plusDays(faker.number().numberBetween(1, 100)).format(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                .build();
    }
}
