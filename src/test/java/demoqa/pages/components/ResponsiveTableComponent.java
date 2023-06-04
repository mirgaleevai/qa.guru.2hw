package demoqa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResponsiveTableComponent {

    public void checkResponciveTableValue(String field, String result) {
        $(".table-responsive").$(byText(field)).parent().shouldHave(text(result));

    }
}