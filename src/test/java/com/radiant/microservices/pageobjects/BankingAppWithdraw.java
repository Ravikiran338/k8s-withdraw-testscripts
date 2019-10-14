 /**
 * @author Subbarao
 */

package com.radiant.microservices.pageobjects;

import org.openqa.selenium.WebElement;

import com.radiant.microservices.model.WebElementDetails;
import com.radiant.microservices.util.JWebElement;

public class BankingAppWithdraw {

	
	// This method creates object for user Menu in HTML page
	public WebElement userMenu(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
		
	// ==========================================================================
	// This method creates object for Account Number text box details in HTML page
	public WebElement accountNumberTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for Withdraw text box details in HTML page
	public WebElement withDrawTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}
		
	// ==========================================================================
	// This method creates object for Submit button in HTML page
	public WebElement submitBtn(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

}
