package ch.allgeier.maven.selenide.tests;

import ch.allgeier.maven.selenide.pages.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest {

    private LoginPage loginPage;

    private String baseUrl;

    private String username;

    private String password;

    @BeforeEach
    void setUp() throws IOException {
        Properties props = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            props.load(is);
        }
        baseUrl = props.getProperty("base.url");
        username = props.getProperty("username");
        password = props.getProperty("password");

        Configuration.browserSize = "1280x800";

        loginPage = new LoginPage();
        loginPage.open(baseUrl);
    }

    @Test
    void testSuccessfulLogin() {
        loginPage.login(username, password);

        String flash = loginPage.getFlashMessageText();
        assertTrue(flash.contains("You logged into a secure area!"),
                "Flash-Nachricht soll Erfolgsmeldung enthalten, war: " + flash);
    }

    @Test
    void testInvalidLogin() {
        loginPage.login("wronguser", "wrongpass");

        String flash = loginPage.getFlashMessageText();
        assertTrue(flash.contains("Invalid credentials"),
                "Flash-Nachricht soll Fehlermeldung enthalten, war: " + flash);
    }
}
