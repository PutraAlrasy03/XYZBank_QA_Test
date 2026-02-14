import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_CUST_10_DataPersistence_Refresh
// Description: Verify that the account balance persists even after
//              the browser page is refreshed (F5).
// ===================================================================

// 1. PRECONDITION: PERFORM A DEPOSIT
// This logs us in and puts money in the account so we have a balance to check
WebUI.callTestCase(findTestCase('Customer_Testcase/TC_CUST_04_Deposit_Valid'),
	[('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)

// 2. CAPTURE DATA: GET BALANCE BEFORE REFRESH
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'), 5)
String balanceBeforeRefresh = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))
println(">>> DATA SAVED | Balance before refresh: \$" + balanceBeforeRefresh)


// 3. ACTION: REFRESH THE BROWSER
WebUI.refresh()

// Give the browser 2 seconds to reload the Angular app
WebUI.delay(2)


// 4. RE-LOGIN (Because refreshing often logs you out in this specific app!)
// The Globalsqa app resets to the login screen on refresh.
// If your app stays logged in, you can skip this block.
if (WebUI.verifyElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), FailureHandling.OPTIONAL)) {
	println(">>> NOTICE: Page refresh logged the user out. Logging back in...")
	WebUI.selectOptionByLabel(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), customerName, false)
	WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_List/button_Login'))
}


// 5. VERIFICATION: PROVE THE MONEY IS STILL THERE
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'), 5)
String balanceAfterRefresh = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))
println(">>> DATA FETCHED | Balance after refresh: \$" + balanceAfterRefresh)

// The Ultimate Proof
WebUI.verifyMatch(balanceAfterRefresh, balanceBeforeRefresh, false, FailureHandling.STOP_ON_FAILURE)

println(">>> TEST PASSED: Data persistence verified! Refreshing the page did not wipe the balance.")