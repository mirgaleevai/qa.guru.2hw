package demoqa;

import demoqa.utils.RandomData;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class StudentRegistrationForm extends TestBase {

    RandomData randomData = new RandomData();

    @Test
    @Tag("RegistrationForm")
    void registrationFormCheck() {

        registrationPage.openPage()
                .closeAdds()
                .setFirstName(randomData.firstName)
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
                .checkHeaderValue("Thanks for submitting the form")

                .resultTableCheck("Student Name", randomData.firstName + " " + randomData.lastName)
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

    }

}


