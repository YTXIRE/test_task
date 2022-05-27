package com.example.java_junit5.tests;

import com.example.java_junit5.config.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ConfigTest extends Config {
    @BeforeEach
    public void setUp() {
        if (mode.equals("selenoid")) {
            Configuration.driverManagerEnabled = false;
            Configuration.remote = selenoidUrl;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setVersion(selenoidBrowserVersion);
            capabilities.setCapability("enableVNC", selenoidEnableVNC);
            capabilities.setCapability("enableVideo", selenoidEnableVideo);
            capabilities.setCapability("enableLog", selenoidEnableLog);
            Configuration.browserCapabilities = capabilities;
        }
        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = browserSize;
        Configuration.browser = browser;
        Configuration.timeout = timeout;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
