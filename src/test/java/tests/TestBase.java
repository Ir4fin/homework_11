package tests;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
    @Step("Делаем скриншот результата")
    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Result screenshot");
    }
}
