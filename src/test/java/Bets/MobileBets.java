package Bets;

import Utils.PropertyReader;
import Utils.WebElements;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.DriverFactory;

import java.util.HashMap;
import java.util.Map;


public class MobileBets implements WebElements {
    public String deviceName;
    protected WebDriver driver = null;
    static DesiredCapabilities capabilities;
    protected WebElement element;

    public synchronized WebDriver getWebDriver() {
        if (driver == null)
        {

        }
        return driver;
    }

    @Given("^I am navigated to mobile williamhill sportsbook page on (.*)$")
    public void iAmNavigatedToMobileWilliamhillSportsbookPageOnPlatform(String platform) throws Throwable {
        System.setProperty(PropertyReader.getSystemProps().getProperty("chromeDriver"), PropertyReader.getSystemProps().getProperty("chromeDriverPath"));
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "iPhone 7");

        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);

        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        WebDriver driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.get(PropertyReader.getSystemProps().getProperty("sburl"));
    }

    @And("^I am logged in to my mobile sportsbook account$")
    public void iAmLoggedInToMyMobileSportsbookAccount() throws Throwable {
     driver.findElement(By.xpath(loginButton)).click();
     this.element.click();
     this.element = driver.findElement(By.id(loginUser));
     this.element.click();
     this.element.sendKeys("username");

    }
}



