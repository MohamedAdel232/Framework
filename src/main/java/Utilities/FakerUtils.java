package Utilities;

import com.github.javafaker.Faker;

public class FakerUtils {
    private FakerUtils() {
    }

    public static String generateFakeName() {
        return new Faker().name().firstName().replace("'", "''");
    }

    public static String generateFakeCompany() {
        return new Faker().company().name().replace("'", "''");
    }

    public static String generateFakeAddress() {
        return new Faker().address().fullAddress().replace("'", "''");
    }

    public static String generateFakeCity() {
        return new Faker().address().city().replace("'", "''");
    }

    public static String generateFakeZipCode() {
        return new Faker().address().zipCode();
    }

    public static String generateFakePhoneNumber() {
        return new Faker().phoneNumber().phoneNumber();
    }

    public static String generateFakeEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String generateFakePassword() {
        return new Faker().internet().password();
    }

    public static String generateFakeText() {
        return new Faker().lorem().sentence();
    }
}
