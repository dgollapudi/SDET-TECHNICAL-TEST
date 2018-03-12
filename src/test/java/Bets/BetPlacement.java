package Bets;

import Utils.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BetPlacement implements WebElements {

    String url = PropertyReader.getSystemProps().getProperty("sburl");
    //NavigateDriver navigate = new NavigateDriver();
    NavigateDriverActions actions = new NavigateDriverActions();
    //MobileEmulation mobileEmulation = new MobileEmulation();
    protected WebElements currentelemnts;
    protected String text;
    protected String[] odds;
    protected String actualOdds;
    protected String[] actualOdds0;
    protected String actualOdds1;
    protected String actualOdds2;
    //protected String actualOdds3;
    protected String retunsValue0;
    protected Float actualOdds3;
    protected Float actualOdds4;
    protected Float returnsWebValue;
    protected Float actualoddstotal;
    protected Float returnsTotal;
    protected Float betStake1;


    //navigating to williamhill pp1 sportsbookUrl
    @Given("^I am navigated to desktop williamhill sportsbook page on(.*)$")
    public void iAmNavigatedToWilliamhillSportsbookPage(String platform) throws Throwable {
        if (platform.contains("desktop")) {
            actions.setDriver();
            actions.navigateToPage(url);
        }
    }


    //Logging on sportsbook with the existing customer details
    @And("^I am logged in to my sportsbook account$")
    public void iAmLoggedInToMySportsbookAccount() throws Throwable {
        // Assert.assertTrue(actions.waitForVisibilityOfElementByXpath(loginButton));
        actions.navigateToElementByXpath(loginButton);
        actions.click();
        //navigating to username and password elements and entering the required details
        actions.navigateToElementById(loginUser);
        actions.click();
        actions.typeIn(PropertyReader.getSystemProps().getProperty("username"));
        actions.navigateToElementById(loginPassword);
        actions.click();
        actions.typeIn(PropertyReader.getSystemProps().getProperty("password"));
        //clicking on submit button after entering the details
        actions.navigateToElementById(loginSubmit);
        actions.click();
        //verifying login successful
        Assert.assertTrue(actions.waitForVisibilityOfElementById(depositButton));
        Logging.info(this.getClass(), "login is successful");


    }

    //navigating to premiership football event
    @And("^I am navigated to a Premiership football event page$")
    public void iAmNavigatedToAPremiershipFootballEventPage() throws Throwable {
        Assert.assertTrue(actions.waitForVisibilityOfElementByPartialLinkText(footballLink));
        Logging.info(this.getClass(), " Football tab is displayed");
        Assert.assertTrue(actions.waitForVisibilityOfElementByPartialLinkText(viewAllFootballMatches));
        actions.navigateToElementByPartialLinkText(viewAllFootballMatches);
        actions.click();
        Assert.assertTrue(actions.waitForVisibilityOfElementByXpath(englishPremierLeagueTab));
        Logging.info(this.getClass(), "English Premier League events are available to place a bet");

    }

    @When("^I selected football event and enter (.*) for the home team to 'Win'$")
    public void iSelectedFootballEventAndEnterBetStakeForTheHomeTeamToWin(String betStake) throws Throwable {
        actions.navigateToElementByXpath(bets);
        Logging.info(this.getClass(), "Odds details " + actions.getText());

        //taking the odds details from webelement returned text
        this.text = actions.getText();

        //using split to take only odds details from text
        this.odds = text.split(" ");
        this.actualOdds = odds[0];//example actualOdds = '3/1'

        //removing '/' using split again
        this.actualOdds0 = actualOdds.split("/");
        this.actualOdds1 = actualOdds0[0];//example stored value'3'
        this.actualOdds2 = actualOdds0[1];// example stored value '1'

        //Selecting the Home odds
        actions.click();

        //Checking betslip page is avilable or not
        Assert.assertTrue(actions.waitForVisibilityOfElementByXpath(betSlip));
        Logging.info(this.getClass(), "Bet slip is avilable");

        //navigating to bet stake webelement and entering bet stake 0.05 value
        Assert.assertTrue(actions.waitForVisibilityOfElementByXpath(betStakeElement));
        actions.navigateToElementByXpath(betStakeElement);
        actions.click();
        actions.typeIn(betStake);


    }


    @Then("^I asserted the odds and returns offered for above (.*)$")
    public void iAssertedTheOddsAndReturnsOfferedForAbove(String betStake) throws Throwable {
        // after entering bet stake value checking the returns value
        Assert.assertTrue(actions.waitForVisibilityOfElementByXpath(returnsValue));
        actions.navigateToElementByXpath(returnsValue);

        //getting the returns value text from webelemnt
        this.retunsValue0 = actions.getText();
        System.out.println("reutns value " + retunsValue0);

        //changing all string values to float to perform arthematic expressions
        this.actualOdds3 = Float.parseFloat(this.actualOdds1);
        this.actualOdds4 = Float.parseFloat(this.actualOdds2);
        this.returnsWebValue = Float.parseFloat(this.retunsValue0);
        this.betStake1 = Float.parseFloat(betStake);

        //Adding above two odds
        this.actualoddstotal = this.actualOdds3 + this.actualOdds4;
        this.returnsTotal = this.actualoddstotal * this.betStake1;

        //Asseting actual returns and Odds
        Assert.assertEquals(this.returnsWebValue, this.returnsTotal);
        Logging.info(this.getClass(), "Actual returns displayed on the screen are correct");
    }

    @And("^I placed a bet$")
    public void iPlacedABet() throws Throwable {

        //clicking on place bet button
        Assert.assertTrue(actions.waitForVisibilityOfElementByXpath(placeBetButton));
        actions.navigateToElementByXpath(placeBetButton);
        actions.click();

        //checking for Bet Placed confirmation
        Assert.assertTrue(actions.waitForVisibilityOfElementByXpath(betPlaced));
        actions.navigateToElementByXpath(betPlaced);
        String betPlacedText = actions.getText();
        String betText = "Bets placed";
        Assert.assertEquals(betPlacedText, betText);
        Logging.info(this.getClass(), "Bet is placed");
    }

    @Then("^I closed browser$")
    public void iClosedBrowser() throws Throwable {
        actions.close();
    }


}
