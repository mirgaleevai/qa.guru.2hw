package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.ResponsiveTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResponsiveTableComponent responsiveTableComponent = new ResponsiveTableComponent();
    SelenideElement
            firstnameInput = $("#firstName"),
            lastnameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            birthdayInput = $(".react-datepicker__input-container"),
            subjectInput = $("#subjectsWrapper #subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            chooseStateOrCity = $("#stateCity-wrapper"),
            stateChoose = $("#state"),
            cityChoose = $("#city"),
            submitButton = $("#submit"),
            headerValue = $(".modal-header"),
            closeModalButton = $("#closeLargeModal");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage closeAdds() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstnameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastnameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genterWrapper.$(byText(value)).click();
        return this;

    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;

    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthdayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectInput(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String states, String city) {
        stateChoose.click();
        chooseStateOrCity.$(byText(states)).click();
        cityChoose.click();
        chooseStateOrCity.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkHeaderValue(String value) {
        headerValue.shouldHave(text(value));
        return this;
    }

    public RegistrationPage resultTableCheck(String field, String result) {
        responsiveTableComponent.checkResponciveTableValue(field, result);
        return this;
    }

    public RegistrationPage closeModalWindowButton() {
        closeModalButton.click();
        return this;

    }
}