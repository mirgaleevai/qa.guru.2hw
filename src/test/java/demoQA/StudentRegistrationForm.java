package demoQA;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void  RegistrationFormCheck () {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(By.xpath("//input[@id='firstName']")).setValue("Oleg");
        $(By.xpath("//input[@id='lastName']")).setValue("Olegov");
        $(By.xpath("//div[@id='userEmail-wrapper']//input")).setValue("Olegov@mail.ru");
        $(By.xpath("//div[@id='genterWrapper']//label[contains(text(), 'Male')]")).click();
        $(By.xpath("//div[@id='userNumber-wrapper']//input")).setValue("8888888888");

        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").click();
        $(byText("June")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1991")).click();
        $(byText("25")).click();

        $(byXpath("//div[@id='subjectsWrapper']//input[@id='subjectsInput']")).setValue("E").pressEnter();

        $(By.xpath("//div[@id='hobbiesWrapper']//label[contains(text(), 'Music')]")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/Wojak.png"));
        $("#currentAddress").setValue("Pushkina 123");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Oleg Olegov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Olegov@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8888888888"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("25 June,1991"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Wojak.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Pushkina 123"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();


















    }

}


