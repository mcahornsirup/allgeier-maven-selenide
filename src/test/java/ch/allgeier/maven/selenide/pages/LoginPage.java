package ch.allgeier.maven.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement usernameField = $("#username");

    private final SelenideElement passwordField = $("#password");

    private final SelenideElement loginButton = $("button[type='submit']");

    private final SelenideElement flashMessage = $("#flash-container");

    public void open(String baseUrl) {
        Selenide.open(baseUrl + "/login");
    }

    public void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }

    public String getFlashMessageText() {
        return flashMessage.getText();
    }
}
