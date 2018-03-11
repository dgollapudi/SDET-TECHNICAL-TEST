package Utils;

import org.openqa.selenium.By;

/**
 * Created by dgollapudi on 06/03/2018.
 */
public interface WebElements {
    //Login WebElements
    String loginButton = "//span[@class='account-tab__text -login']/span[@class='sb-translate']";
           // "//span[@class='account-tab__text -login']/span[@class='sb-translate']";
            //"accountTabButton";
    String loginUser = "loginUsernameInput";
    String loginPassword = "loginPasswordInput";
    String loginSubmit = "loginButton";
    String depositButton = "depositHeaderButtonLink";

    //Football webElements
    String footballLink = "Football";
    String viewAllFootballMatches = "View All Football";
    String englishPremierLeagueTab= "//header[@class='header-dropdown header-dropdown--large -expanded']/h2";
    String bets = "//div[@class='btmarket__selection']/button[@class='btn betbutton oddsbutton']/span[@class='betbutton__odds']";
    String betSlip = "//span[@class='betslip-navigation__menu-text']";
    String betStakeElement = "//div[@class='betslip-selection__stake-container betslip-selection__stake-container--single']/span/input[@type='text']";
    String returnsValue = "//span[@id='total-to-return-price']";
    String placeBetButton = " //li[@class='betslip-bet-actions__list-item betslip-bet-actions__list-item--full-width']/input[@type='button']";
    String betPlaced = " //em[@class='betslip-receipt__header-text']";


}
