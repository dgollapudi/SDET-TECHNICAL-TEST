package Bets;


import Utils.NavigateDriver;
import Utils.NavigateDriverActions;
import Utils.WebElements;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class MobileTestBrowserStack implements WebElements {

    public static final String USERNAME = "divyag2";
    public static final String AUTOMATE_KEY = "yYhmjSrzs1Ux2vpVz57z";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    protected WebElement element;

//Implementing mobile test using BrowserStack
        @Given("^I am navigated to mobile williamhill sportsbook page on(.*)$")
        public void iAmNavigatedToWilliamhillSportsbookPage (String platform) throws Throwable {
            NavigateDriverActions actions = new NavigateDriverActions();

            //setting device capabiliies
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "iPhone");
            caps.setCapability("device", "iPhone 7");
            caps.setCapability("realMobile", "true");
            caps.setCapability("os_version", "10.3");

            //Initiallizing remote webdriver on browser stack

            WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
            //Navigating to sportsbook site
            driver.get("https://sports.williamhill-pp1.com/betting/en-gb?action=GoAcct");

        }
    }


