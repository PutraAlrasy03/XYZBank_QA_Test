import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_CUST_07_Withdraw_Insufficient
// Description: Verify system rejects withdrawals greater than the
//              current balance and shows the correct error message.
// ===================================================================

// 1. PRECONDITION: Log in dynamically
WebUI.callTestCase(findTestCase('Customer_Testcase/TC_CUST_01_Login_Valid'),
	[('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)

// Capture the INITIAL balance before attempting the hack
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'), 5)
String initialBalance = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))
println(">>> INITIAL BALANCE: \$" + initialBalance)

// 2. NAVIGATE TO WITHDRAWAL TAB
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/button_Withdrawl'))

// Angular needs a split second to change the tab from Deposit to Withdraw
WebUI.delay(1)

// 3. ACTION: Attempt to withdraw $999,999
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/input_amount'), 5)
WebUI.setText(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/input_amount'), '999999')

WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/button_Withdraw'))

// 4. VERIFICATION 1: Check for the exact failure object
// We use your captured object to prove the exact error element is visible!
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Customer_Dashboard/Page_Customer_Withdraw/span_Transaction Failed'), 5)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Customer_Dashboard/Page_Customer_Withdraw/span_Transaction Failed'), FailureHandling.STOP_ON_FAILURE)

println(">>> VERIFIED: System displayed the correct 'Transaction Failed' message.")

// 5. VERIFICATION 2: Ensure the money was NOT stolen!
// Give the app a second to settle
WebUI.delay(1)
String finalBalance = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))

// The balance should still EXACTLY match the initial balance
WebUI.verifyMatch(finalBalance, initialBalance, false, FailureHandling.STOP_ON_FAILURE)

println(">>> TEST PASSED: Insufficient withdrawal blocked securely. Balance remains at \$" + finalBalance)