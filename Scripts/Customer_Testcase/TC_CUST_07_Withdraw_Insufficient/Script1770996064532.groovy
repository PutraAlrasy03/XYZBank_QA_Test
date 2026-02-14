import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_CUST_07_Withdraw_Insufficient
// Description: Verify system rejects withdrawals greater than the
//              current balance (Dynamic Calculation).
// ===================================================================

// 1. PRECONDITION: LOGIN
WebUI.callTestCase(findTestCase('Customer_Testcase/TC_CUST_01_Login_Valid'),
	[('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)


// 2. CAPTURE INITIAL BALANCE
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'), 5)
String initialBalance = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))
println(">>> INITIAL BALANCE: \$" + initialBalance)


// 3. CALCULATE EXCESSIVE AMOUNT (Balance + 100)
// Convert string "500" to integer 500
int balanceValue = Integer.parseInt(initialBalance)

// Add 100 to make it definitely insufficient
int excessiveAmount = balanceValue + 100
String withdrawalInput = String.valueOf(excessiveAmount)

println(">>> TEST DATA GENERATED: Current Balance is " + initialBalance + ". Attempting to withdraw: " + withdrawalInput)


// 4. NAVIGATE TO WITHDRAWAL TAB
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/button_Withdrawl'))

// Angular needs a split second to change the tab
WebUI.delay(1)


// 5. ATTEMPT THE HACK
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/input_amount'), 5)
WebUI.setText(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/input_amount'), withdrawalInput)

WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/button_Withdraw'))


// 6. VERIFY ERROR MESSAGE
// We verify that the specific error object appears
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/span_Transaction Failed'), 5)
WebUI.verifyElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/span_Transaction Failed'), FailureHandling.STOP_ON_FAILURE)

println(">>> VERIFIED: System displayed the correct 'Transaction Failed' message.")


// 7. VERIFY SECURITY (Balance Check)
// Give the app a second to settle
WebUI.delay(1)
String finalBalance = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))

// The balance should still EXACTLY match the initial balance
WebUI.verifyMatch(finalBalance, initialBalance, false, FailureHandling.STOP_ON_FAILURE)

println(">>> TEST PASSED: Insufficient withdrawal blocked securely. Balance remains at \$" + finalBalance)