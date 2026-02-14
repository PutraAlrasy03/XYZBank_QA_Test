import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_CUST_02_Account_Display
// Description: Verify that the account balance and currency type
//              are clearly visible on the dashboard after login.
// ===================================================================

// 1. PRECONDITION: LOGIN
// Use the modular test case to handle the login process
WebUI.callTestCase(findTestCase('Customer_Testcase/TC_CUST_01_Login_Valid'),
	[('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)


// 2. VERIFY BALANCE VISIBILITY
// Check that the balance number is actually shown on the screen
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'), 5)
WebUI.verifyElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))


// 3. VERIFY CURRENCY VISIBILITY (New Step!)
// Check that the currency type (Dollar/Pound/Rupee) is shown
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/Currency_type'), 5)
WebUI.verifyElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/Currency_type'))


// 4. CAPTURE & LOG DATA
// Get the actual text from both objects
String currentBalance = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))
String currentCurrency = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/Currency_type'))

// Print the complete account details to the console
println(">>> ACCOUNT VERIFIED: " + customerName + " | BALANCE: " + currentBalance + " " + currentCurrency)

// TEST PASSED