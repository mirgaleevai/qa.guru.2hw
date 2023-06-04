package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.OutputTableComponent;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    OutputTableComponent outputTableComponent = new OutputTableComponent();

    SelenideElement
            fullNameInput = $("#userName"),
            emaiInput = $("#userEmail"),
            currentAddressTextArea = $("#currentAddress"),
            permanentAddressTextArea = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),

    outputcurrentAddress = $("#output #currentAddress"),
            outputpermanentAddress = $("#output #permanentAddress");


    public TextBoxPage openTextBoxPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage closeAdds() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullname(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        emaiInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAdress(String value) {
        currentAddressTextArea.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressTextArea.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public TextBoxPage outputTableCheck(String name, String email, String currentAddress, String permanentAddress) {
    outputTableComponent.outputTableResult(name, email, currentAddress, permanentAddress);
        return this;
    }


}



