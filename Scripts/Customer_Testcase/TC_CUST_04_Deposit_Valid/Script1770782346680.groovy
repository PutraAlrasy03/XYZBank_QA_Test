import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_CUST_04_Deposit_Valid
// Description: Verify that a customer can deposit money successfully.
//              (Uses a RANDOM 3-digit amount for verification)
// ===================================================================

// 1. PRECONDITION: LOGIN
// Call the modular login test case
WebUI.callTestCase(findTestCase('Customer_Testcase/TC_CUST_01_Login_Valid'),
    [('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)


// 2. GENERATE RANDOM DATA
// Generate a random number between 100 and 999
def rand = new Random()
// nextInt(900) gives 0-899. Adding 100 makes it 100-999.
String randomDepositAmount = String.valueOf(rand.nextInt(900) + 100)

println(">>> TEST DATA GENERATED: Will attempt to deposit \$" + randomDepositAmount)


// 3. NAVIGATE TO DEPOSIT TAB
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/button_Deposit'))

// Give the Angular app a moment to switch tabs
WebUI.delay(1)


// 4. ENTER RANDOM DEPOSIT AMOUNT
// Wait for the input field to be visible before typing
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/input_amount'), 5)
WebUI.setText(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/input_amount'), randomDepositAmount)


// 5. SUBMIT DEPOSIT
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/button_Deposit_1'))


// 6. VERIFY SUCCESS MESSAGE
// We verify the text explicitly to avoid false positives
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/span_Deposit Successful'), 5)
WebUI.verifyTextPresent('Deposit Successful', false)

println(">>> TEST PASSED: Deposit of \$" + randomDepositAmount + " was successful for " + customerName)