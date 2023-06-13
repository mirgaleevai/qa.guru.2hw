package demoqa;

import org.junit.jupiter.api.Test;

import static demoqa.utils.RandomData.*;

public class StudentRegistrationForm extends TestBase {
    public String firstName = faker.name().firstName(),
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

    public int chooseDay = faker.number().numberBetween(1, 28),
            ChooseYear = faker.number().numberBetween(1980, 2005);
    public String day = String.valueOf(chooseDay),
            year = String.valueOf(ChooseYear);

    @Test
    void registrationFormCheck() {

        registrationPage.openPage()
                .closeAdds()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setBirthDay(day, month, year)
                .setSubjectInput(subject)
                .setHobby(hobby)
                .uploadPicture(filename)
                .setCurrentAddress(address)
                .setStateAndCity(state, city)
                .clickSubmitButton()
                .checkHeaderValue("Thanks for submitting the form")

                .resultTableCheck("Student Name", firstName + " " + lastName)
                .resultTableCheck("Student Email", email)
                .resultTableCheck("Gender", gender)
                .resultTableCheck("Mobile", phoneNumber)
                .resultTableCheck("Date of Birth", day + " " + month + "," + year)
                .resultTableCheck("Subjects", subject)
                .resultTableCheck("Hobbies", hobby)
                .resultTableCheck("Picture", filename)
                .resultTableCheck("Address", address)
                .resultTableCheck("State and City", state + " " + city)

                .closeModalWindowButton();

    }

}


