package demoqa;

import demoqa.utils.RandomData;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class StudentRegistrationForm extends TestBase {

    RandomData randomData = new RandomData();

    @Test
    @DisplayName("Success registration")
    @Tag("RegistrationForm")
    void registrationFormCheck() {

        step("Open registration form", () -> {
            registrationPage.openPage()
                    .closeAdds();
        });
        step("Fill form", () -> {
            registrationPage.setFirstName(randomData.firstName)
                    .setLastName(randomData.lastName)
                    .setUserEmail(randomData.email)
                    .setGender(randomData.gender)
                    .setUserNumber(randomData.phoneNumber)
                    .setBirthDay(randomData.day, randomData.month, randomData.year)
                    .setSubjectInput(randomData.subject)
                    .setHobby(randomData.hobby)
                    .uploadPicture(randomData.filename)
                    .setCurrentAddress(randomData.address)
                    .setStateAndCity(randomData.state, randomData.city)
                    .clickSubmitButton()
                    .checkHeaderValue("Thanks for submitting the form");
        });

        step("Checking result table", () -> {
            registrationPage.resultTableCheck("Student Name", randomData.firstName + " " + randomData.lastName)
                    .resultTableCheck("Student Email", randomData.email)
                    .resultTableCheck("Gender", randomData.gender)
                    .resultTableCheck("Mobile", randomData.phoneNumber)
                    .resultTableCheck("Date of Birth", randomData.day + " " + randomData.month + "," + randomData.year)
                    .resultTableCheck("Subjects", randomData.subject)
                    .resultTableCheck("Hobbies", randomData.hobby)
                    .resultTableCheck("Picture", randomData.filename)
                    .resultTableCheck("Address", randomData.address)
                    .resultTableCheck("State and City", randomData.state + " " + randomData.city)
                    .closeModalWindowButton();
        });

    }

}


