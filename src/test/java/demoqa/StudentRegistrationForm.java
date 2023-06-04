package demoqa;

import demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class StudentRegistrationForm extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void registrationFormCheck() {
        registrationPage.openPage()
                .closeAdds()
                .setFirstName("Oleg")
                .setLastName("Olegov")
                .setUserEmail("Olegov@mail.ru")
                .setGender("Male")
                .setUserNumber("8888888888")
                .setBirthDay("25", "June", "1991")
                .setSubjectInput("English")
                .setHobby("Sports")
                .uploadPicture("Wojak.png")
                .setCurrentAddress("Pushkina 123")
                .setStateAndCity("NCR", "Delhi")
                .clickSubmitButton()
                .checkHeaderValue("Thanks for submitting the form")

                .resultTableCheck("Student Name","Oleg Olegov")
                .resultTableCheck("Student Email", "Olegov@mail.ru")
                .resultTableCheck("Gender", "Male")
                .resultTableCheck("Mobile", "8888888888")
                .resultTableCheck("Date of Birth", "25 June,1991")
                .resultTableCheck("Subjects", "English")
                .resultTableCheck("Hobbies", "Sports")
                .resultTableCheck("Picture", "Wojak.png")
                .resultTableCheck("Address", "Pushkina 123")
                .resultTableCheck("State and City", "NCR Delhi")

                .closeModalWindowButton();

    }

}


