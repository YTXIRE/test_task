using System;
using System.Drawing;
using csharp_nunit.config;
using csharp_nunit.utils;
using NSelene;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Remote;
using WebDriverManager;
using WebDriverManager.DriverConfigs.Impl;

namespace csharp_nunit.tests {
    public class ConfigTest : Config {
        [SetUp]
        public void Setup()
        {
            Configuration.Timeout = Timeout;
            IWebDriver webDriver;
            if (Mode == "selenoid")
            {
                var options = new ChromeOptions()
                    .AddGlobal("enableVNC", SelenoidEnableVnc)
                    .AddGlobal("enableVideo", SelenoidEnableVideo);
                new DriverManager().SetUpDriver(new ChromeConfig(), version: SelenoidBrowserVersion);
                webDriver = new RemoteWebDriver(new Uri(BaseUrl), options);
            } else {
                new DriverManager().SetUpDriver(new ChromeConfig());
                webDriver = new ChromeDriver();
            }
            Configuration.WaitForNoOverlapFoundByJs = true;
            webDriver.Manage().Window.Size = new Size(BrowserWidth, BrowserHeight);
            Selene.SetWebDriver(webDriver);
        }

        [TearDown]
        public void TearDown() {
            Configuration.Driver.Quit();
        }
    }
}