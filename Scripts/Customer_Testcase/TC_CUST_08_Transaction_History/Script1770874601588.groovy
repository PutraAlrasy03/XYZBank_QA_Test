import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Login
WebUI.callTestCase(findTestCase('Customer_Testcase/TC_CUST_01_Login_Valid'), [('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)

// 2. Open Transactions
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Transcations/button_Transactions'))

// 3. Wait for the Date Inputs to be ready
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_Transcations/input_yyyy-MM-ddTHH_mm_ss'), 5)

// 4. Filter by Dates
// Setting a broad range to ensure we see the history
WebUI.setText(findTestObject('Page_Customer_Dashboard/Page_Customer_Transcations/input_yyyy-MM-ddTHH_mm_ss'), '2015-01-01T00:00')
WebUI.setText(findTestObject('Page_Customer_Dashboard/Page_Customer_Transcations/input_yyyy-MM-ddTHH_mm_ss_1'), '2015-12-31T23:59')

// 5. Verify the table is visible
WebUI.verifyElementPresent(findTestObject('Page_Customer_Dashboard/Page_Customer_Transcations/div__'), 3)

// 6. Return to Dashboard
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Transcations/div_Back'))

// No Logout button here - the Listener will close the browser automatically!