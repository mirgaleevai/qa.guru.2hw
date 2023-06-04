package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class OutputTableComponent {

    SelenideElement
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputcurrentAddress = $("#output #currentAddress"),
            outputpermanentAddress = $("#output #permanentAddress");


    public void outputTableResult(String name, String email, String currentAddress, String permanentAddress) {
        outputName.shouldHave(text(name));
        outputEmail.shouldHave(text(email));
        outputcurrentAddress.shouldHave(text(currentAddress));
        outputpermanentAddress.shouldHave(text(permanentAddress));

    }

}
