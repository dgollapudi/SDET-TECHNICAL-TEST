package Utils;

import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import java.util.logging.Logger;

/**
 * Created by dgollapudi on 06/03/2018.
 */
public abstract class NavigateDriver {

    protected WebDriver driver;
    protected WebElement currentElement;
    private int WAIT_TIME = 20;
    public static org.apache.log4j.Logger logger = LogManager.getLogger(NavigateDriver.class);

    public abstract void setDriver();

    public abstract void navigateToPage(String url);

    public abstract void navigateToElementById(String element) throws InterruptedException;

    public abstract void navigateToElementByClassName(String name);
    public abstract void navigateToElementByPartialLinkText(String linkText);
    public abstract void navigateToElementByXpath(String xpath);
    public abstract void navigateToElementBycssSelector(String cssSelector);

    public boolean navigateToRootElement() {
        try {
            currentElement = driver.findElement(By.xpath("/html/body"));
        } catch (NoSuchElementException nsee) {
            logger.info("Unable to return to Root Element - Body");
        }
        return true;
    }

    public boolean waitForVisibilityOfElementById(String id) {
        try {
            (new WebDriverWait(driver, WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public boolean waitForVisibilityOfElementByPartialLinkText(String linkText ) {
        try {
            (new WebDriverWait(driver, WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(linkText)));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public boolean waitForVisibilityOfElementByXpath(String xpath ) {
        try {
            (new WebDriverWait(driver, WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception ex) {
            return false;
        }

    }


}

