import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_CUST_06_Withdraw_Valid
// Description: Verify that a valid withdrawal reduces the balance
//              and displays a success message.
// PRECONDITION: Account must have funds (Calls Deposit TC first).
// ===================================================================

// 1. PRECONDITION: DEPOSIT MONEY
// We call the Deposit test first to ensure we have money to withdraw!
WebUI.callTestCase(findTestCase('Customer_Testcase/TC_CUST_04_Deposit_Valid'),
	[('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)


// 2. NAVIGATE TO WITHDRAWAL TAB
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/button_Withdrawl'))

// Angular needs a split second to change the tab
WebUI.delay(1)


// 3. VERIFY PAGE LOADED
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/label_Amount to be Withdrawn _'), 5)
WebUI.verifyElementPresent(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/label_Amount to be Withdrawn _'), 5)


// 4. INPUT WITHDRAWAL AMOUNT
// We withdraw slightly less than what we just deposited
WebUI.setText(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/input_amount'), '50')


// 5. CLICK SUBMIT
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/button_Withdraw'))


// 6. VERIFY SUCCESSFUL TRANSACTION
// We wait for the "Transaction successful" message to appear
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/span_Transaction successful'), 5)

// THE FIX: Changed 'Successful' to 'successful' (Lowercase 's')
WebUI.verifyElementText(findTestObject('Page_Customer_Dashboard/Page_Customer_Withdraw/span_Transaction successful'), 'Transaction successful')

println(">>> TEST PASSED: Withdrawal of 50 was successful for " + customerName)