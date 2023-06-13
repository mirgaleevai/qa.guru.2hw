package demoqa;

import org.junit.jupiter.api.Test;

import static demoqa.utils.RandomData.*;

public class StudentRegistrationForm extends TestBase {

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


