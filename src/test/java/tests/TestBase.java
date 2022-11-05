package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String browserName = System.getProperty("browser_name", "chrome");
        String browserVersion = System.getProperty("browser_version", "100");
        String browserSize = System.getProperty("browser_size", "1920x1080");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserCapabilities = capabilities;
        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);




        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";


        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Result screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


}
