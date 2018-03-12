package Bets;

import Utils.Logging;
import Utils.PropertyReader;
import Utils.WebElements;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.DriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

// device emulation on chrome browser
public class MobileChromeBrowserEmulation implements WebElements {
    public String deviceName;
    protected WebDriver driver;
    static DesiredCapabilities capabilities;
    protected WebElement element;
    private int WAIT_TIME = 20;



    @Given("^I am navigated to mobile williamhill sportsbook page on (.*)$")
    public void iAmNavigatedToMobileWilliamhillSportsbookPageOnPlatform(String platform) throws Throwable {
        System.setProperty(PropertyReader.getSystemProps().getProperty("chromeDriver"), PropertyReader.getSystemProps().getProperty("chromeDriverPath"));
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "iPhone 7");

        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);

        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
         driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.get(PropertyReader.getSystemProps().getProperty("sburl"));
    }

    @And("^I am logged in to my mobile sportsbook account$")
    public void iAmLoggedInToMyMobileSportsbookAccount() throws Throwable {
     driver.findElement(By.xpath(loginButton)).click();
     //this.element.click();
      driver.findElement(By.id(loginUser)).sendKeys(PropertyReader.getSystemProps().getProperty("username"));
      driver.findElement(By.id(loginPassword)).sendKeys(PropertyReader.getSystemProps().getProperty("password"));
      driver.findElement(By.id(loginSubmit)).click();
    }

    @And("^I am navigated to a mobile Premiership football event page$")
    public void iAmNavigatedToAMobilePremiershipFootballEventPage() throws Throwable {

        driver.findElement(By.partialLinkText(viewAllFootballMatches)).click();
    }
}



