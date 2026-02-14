import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID : TC_CUST_08_Transaction_History
// Description  : Only modify Start Date to 2020. Leave End Date as Today.
// ============================= SETUP ===============================

// 1. PRECONDITION: LOGIN
WebUI.callTestCase(findTestCase('Customer_Testcase/TC_CUST_01_Login_Valid'),
	[('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)

// 2. ACTION: DEPOSIT FRESH MONEY
def rand = new Random()
String transactionAmount = String.valueOf(rand.nextInt(900) + 100)
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/button_Deposit'))
WebUI.setText(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/input_amount'), transactionAmount)
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Deposit/button_Deposit_1'))

// 3. NAVIGATE TO TRANSACTIONS
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_Transcations/button_Transactions'))
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_Transcations/input_yyyy-MM-ddTHH_mm_ss'), 10)

// 4. SET START DATE ONLY (JS Injection)
// End date is ignored because it defaults to Today
String startDateISO = '2020-01-01T00:00'

WebUI.executeJavaScript("""
    var startInput = document.querySelector('input[type="datetime-local"]');
    if(startInput) {
        startInput.value = '${startDateISO}';
        // Fire events so the app sees the date changed
        startInput.dispatchEvent(new Event('input', { bubbles: true }));
        startInput.dispatchEvent(new Event('change', { bubbles: true }));
        startInput.dispatchEvent(new Event('blur', { bubbles: true }));
    }
""", null)

// 5. THE "KICK": REFRESH THE TABLE
// Clicking the header forces a re-sort and shows the new data
WebUI.click(findTestObject('Object Repository/Page_Customer_Dashboard/Page_Customer_Transcations/a_Date-Time'))

// 6. FINAL VERIFICATION
WebUI.delay(3)

// Check for the unique deposit amount
WebUI.verifyTextPresent(transactionAmount, false)
WebUI.verifyTextPresent('Credit', false)

println(">>> SUCCESS: Filtered from 2020 to Today. Found: " + transactionAmount)