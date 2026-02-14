import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_CUST_09_DataPersistence_Logout
// Description: Verify balance persists after logout and re-login.
// ===================================================================

// 1. PRECONDITION: DEPOSIT MONEY
// This logs us in and puts money in the account
WebUI.callTestCase(findTestCase('Customer_Testcase/TC_CUST_04_Deposit_Valid'),
	[('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)

// 2. CAPTURE DATA: GET BALANCE BEFORE LOGOUT
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'), 5)
String balanceBeforeLogout = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))
println(">>> DATA SAVED | Balance before logout: \$" + balanceBeforeLogout)


// 3. ACTION: LOGOUT
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_List/button_Logout'))

// Give the app 1 second to reset the dropdown
WebUI.delay(1)


// 4. ACTION: LOG BACK IN (Manual Steps)
// Since we are already at the dropdown screen, we just select the name directly.
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), 5)

WebUI.selectOptionByLabel(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), customerName, false)

WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_List/button_Login'))


// 5. VERIFICATION: PROVE THE MONEY IS STILL THERE
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'), 5)
String balanceAfterLogin = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))
println(">>> DATA FETCHED | Balance after re-login: \$" + balanceAfterLogin)

// The Ultimate Proof: Ensure the bank didn't lose the data!
WebUI.verifyMatch(balanceAfterLogin, balanceBeforeLogout, false, FailureHandling.STOP_ON_FAILURE)

println(">>> TEST PASSED: Data persistence verified! The balance securely remained at \$" + balanceAfterLogin + " across sessions.")