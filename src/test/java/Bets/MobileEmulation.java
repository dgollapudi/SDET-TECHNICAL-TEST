package Bets;

import Utils.Logging;
import Utils.NavigateDriverActions;
import Utils.PropertyReader;
import Utils.WebElements;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by dgollapudi on 10/03/2018.
 */
public class MobileEmulation {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.BROWSER_NAME,"BROWSER");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"AD1");
        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        driver.get("https://sports.williamhill-pp1.com/betting/en-gb?action=GoAcct");



    }
}
