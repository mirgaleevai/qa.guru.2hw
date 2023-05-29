package demoQA;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";
    }

    @Test
    void  RegistrationFormCheck () {
        open("automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(By.xpath("//input[@id='firstName']")).setValue("Oleg");
        $(By.xpath("//input[@id='lastName']")).setValue("Olegov");
        $(By.xpath("//div[@id='userEmail-wrapper']//input")).setValue("Olegov@mail.ru");
        $(By.xpath("//div[@id='genterWrapper']//label[contains(text(), 'Male')]")).click();
        $(By.xpath("//div[@id='userNumber-wrapper']//input")).setValue("8888888888");






    }

}


