package demoqa.utils;

import com.github.javafaker.Faker;

public class RandomData {
    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getCityForState(state),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            month = faker.options().option("January", "February", "March", "April", "May",
                    "June", "July", "August", "September", "October", "November", "December"),
            subject = faker.options().option("Math", "English", "Chemistry", "Civics",
                    "Computer Science", "Arts", "Physics", "Economics"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            filename = "Wojak.png",
            address = faker.address().fullAddress();
    public static int chooseDay = faker.number().numberBetween(1, 28),
            ChooseYear = faker.number().numberBetween(1980, 2005);

    public static String day = String.valueOf(chooseDay),
            year = String.valueOf(ChooseYear);

    public static String getCityForState(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");

            default:
                return null;
        }

    }

}
