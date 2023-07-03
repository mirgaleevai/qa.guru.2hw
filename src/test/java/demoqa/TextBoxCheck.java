package demoqa;

import demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TextBoxCheck extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
    @Tag("TextBox")
    void TextBoxTest() {
        textBoxPage.openTextBoxPage()
                .closeAdds()
                .setFullname("Marina Ivanovna")
                .setEmail("Marina@mail.ru")
                .setCurrentAdress("Lenina 666")
                .setPermanentAddress("Lenina 777")
                .clickSubmitButton()
                .outputTableCheck("Marina Ivanovna", "Marina@mail.ru", "Lenina 666", "Lenina 777");

    }
}
