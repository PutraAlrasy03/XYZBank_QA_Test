import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_CUST_05_Deposit_Invalid
// Description: Verify system rejects empty (triggers HTML5 validation)
//              and negative deposit amounts.
// ===================================================================

// 1. PRECONDITION: Log in
WebUI.callTestCase(findTestCase('Customer_Testcase/TC_CUST_01_Login_Valid'),
	[('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)

// Capture the INITIAL balance
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'), 5)
String initialBalance = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))
println(">>> INITIAL BALANCE: \$" + initialBalance)

// 2. NAVIGATE TO DEPOSIT TAB
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/button_Deposit'))
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/input_amount'), 5)


// --- SCENARIO A: EMPTY DEPOSIT (HTML5 Validation) ---
println(">>> TESTING SCENARIO A: Empty Deposit")
WebUI.setText(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/input_amount'), '')
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/button_Deposit_1'))

// 🚀 Capture the HTML5 popup just like we did in the Manager test!
String validationMsg = WebUI.getAttribute(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/input_amount'), 'validationMessage')
println(">>> BROWSER POPUP SAYS: " + validationMsg)

// Verify the popup text matches what we expect
WebUI.verifyMatch(validationMsg, '.*Please fill out this field.*', true, FailureHandling.OPTIONAL)

// Verify the success text did NOT appear
WebUI.verifyTextNotPresent('Deposit Successful', false, FailureHandling.STOP_ON_FAILURE)


// --- SCENARIO B: NEGATIVE DEPOSIT ---
println(">>> TESTING SCENARIO B: Negative Deposit (-500)")
WebUI.setText(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/input_amount'), '-500')
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/button_Deposit_1'))

// Verify success text did NOT appear (Negative numbers usually bypass HTML5 but fail in the backend)
WebUI.verifyTextNotPresent('Deposit Successful', false, FailureHandling.STOP_ON_FAILURE)


// 3. FINAL VERIFICATION: Ensure no money was actually added!
WebUI.delay(1)
String finalBalance = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))

// The balance should still EXACTLY match the initial balance
WebUI.verifyMatch(finalBalance, initialBalance, false, FailureHandling.STOP_ON_FAILURE)

println(">>> TEST PASSED: Invalid deposits were blocked and balance remained at \$" + finalBalance)