/**
 * @author Subbarao 
 */
package com.radiant.microservices.testscripts;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.radiant.microservices.db.TAFDBManagerHelper;
import com.radiant.microservices.db.TestCaseDetails;
import com.radiant.microservices.db.TestSuiteDetails;
import com.radiant.microservices.exceptions.TAFException;
import com.radiant.microservices.model.WebElementDataDetails;
import com.radiant.microservices.model.WebElementDetails;

import com.radiant.microservices.pageobjects.BankingAppWithdraw;
import com.radiant.microservices.util.AppUtil;
import com.radiant.microservices.util.JExcelParser;
import com.radiant.microservices.util.JWebDriver;
import com.radiant.microservices.util.JXMLParser;

@SuppressWarnings("deprecation")
public class BankingAppWithdrawAmntTestScript {

	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> bankingAppWithdrawAmountWebElementList = null;
	private List<WebElementDataDetails> webElementsData = null;
	private TestCaseDetails testCaseDetails = null;
	BankingAppWithdraw bankingAppWithdrawAmount;
	AppUtil apt = new AppUtil();
	TestSuiteDetails suiteDetails;

	// ==========================================================================

	public BankingAppWithdrawAmntTestScript(TestSuiteDetails testSuiteDetails) {

		this.suiteDetails = testSuiteDetails;
		testCaseDetails = new TestCaseDetails();
		testCaseDetails.setTestSuiteDetailsId(testSuiteDetails.getTestSuiteDetailsId());
	}


	// ==========================================================================

	@BeforeTest
	public void beforeTest() {
		log.info("START of the method beforeTest");
		log.info("END of the method beforeTest");
	}

	// ==========================================================================

	private void setPrerCSuisites() throws InterruptedException {
		testCaseDetails.setTestCaseName(BankingAppWithdrawAmntTestScript.class.getSimpleName());
		if (bankingAppWithdrawAmountWebElementList == null) {
			bankingAppWithdrawAmountWebElementList = JXMLParser.getInstance().getWebElements(BankingAppWithdraw.class.getSimpleName());
		}

		if (webElementsData == null) {
		      webElementsData = JExcelParser.getInstance().getDataSet(BankingAppWithdraw.class.getSimpleName(), BankingAppWithdrawAmntTestScript.class.getSimpleName());
		   }
		
	}

	// ==========================================================================

	@Test(description = "Adding new Group time cycle record")
	public void GetStatementBankingAccount() {
		log.info("START of the method addNewbankingAppWithdrawAmountRecord");
		bankingAppWithdrawAmount = new BankingAppWithdraw();
		String customMessage = null;
		WebDriver driver = null;
		
		try {
			testCaseDetails.setMethodName(AppUtil.getMethodName());
			setPrerCSuisites();
			driver = JWebDriver.getInstance().getWebDriver();
			ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
			driver.get(resourceBundle.getString("application.url"));
			Thread.sleep(6000);
			customMessage = "Click on Add button";
			WebElementDetails userMenuobj = bankingAppWithdrawAmountWebElementList.get(0);
			bankingAppWithdrawAmount.userMenu(userMenuobj).click();
			Thread.sleep(6000);

			if (bankingAppWithdrawAmountWebElementList != null && bankingAppWithdrawAmountWebElementList.size() > 0) {
				if (webElementsData!=null) {
					for (WebElementDataDetails webElementDataDetails : webElementsData) {
						if (webElementDataDetails.isExecute()) {
							List<String> dataSet = webElementDataDetails.getDataSet();
							if (dataSet != null && dataSet.size() > 0) {
									Actions act = new Actions(driver);
									Thread.sleep(10000);
									JavascriptExecutor js = (JavascriptExecutor) driver;
									js.executeScript("window.scrollBy(0,3000)");
									
									customMessage = "Dialog box GetStatement";
									WebElementDetails accountNumObj = bankingAppWithdrawAmountWebElementList.get(1);
									bankingAppWithdrawAmount.accountNumberTxtbox(accountNumObj).click();
									bankingAppWithdrawAmount.accountNumberTxtbox(accountNumObj).clear();
									bankingAppWithdrawAmount.accountNumberTxtbox(accountNumObj).sendKeys(webElementDataDetails.getDataSet().get(0));
									Thread.sleep(1000);
									
									customMessage = "Dialog box GetStatement";
									WebElementDetails WithdrawAmtobj = bankingAppWithdrawAmountWebElementList.get(2);
									bankingAppWithdrawAmount.withDrawTxtbox(WithdrawAmtobj).click();
									bankingAppWithdrawAmount.withDrawTxtbox(WithdrawAmtobj).clear();
									bankingAppWithdrawAmount.withDrawTxtbox(WithdrawAmtobj).sendKeys(webElementDataDetails.getDataSet().get(1));
									Thread.sleep(1000);
									
						 		    customMessage = "Dialog box GetStatement";
									WebElementDetails searchBtnObj = bankingAppWithdrawAmountWebElementList.get(3);
									bankingAppWithdrawAmount.submitBtn(searchBtnObj).click();
									Thread.sleep(4000);
																		
									}
						   }	
						}

					} else {
						log.info(" Unable to execute the script Test data is empty");
					}
					
				} else {
					log.info(" Unable to execute the script as some or all the mandatory objects or values are null");
				}
			} catch (java.lang.AssertionError e) {
				suiteDetails.setTestStatusSuccess(false);
				testCaseDetails = new TAFException().handleException(e, testCaseDetails, customMessage);
			} catch (Exception e) {
				suiteDetails.setTestStatusSuccess(false);
				testCaseDetails = new TAFException().handleException(e, testCaseDetails, customMessage);
			} finally {
				TAFDBManagerHelper.getInstance().saveTestCaseDetails(testCaseDetails);
			}
			log.info("END of the method login");
		}

	// ==========================================================================

	@AfterTest
	public void afterTest() {
		log.info("START of the method afterTest");
		log.info("END of the method afterTest");
	}

	
	// ==========================================================================

	public String handleNavigationPageState() {
		
		String customMessage = "PASS";
				
		return customMessage;
		
	}

	// ==========================================================================

}
