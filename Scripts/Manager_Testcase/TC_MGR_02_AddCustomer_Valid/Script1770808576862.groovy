import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.apache.commons.lang.RandomStringUtils // For randomizing PostCode if needed

// ===================================================================
// Test Case ID : TC_MGR_02_Add_Customer
// Description  : Verify Bank Manager can add a new customer (Data-Driven).
// ===================================================================

// 1. PRECONDITION: Log in as Bank Manager
WebUI.callTestCase(findTestCase('Manager_Testcase/TC_MGR_01_Login'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. NAVIGATE: Click the 'Add Customer' tab/button
WebUI.click(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/button_Add Customer'))

// 3. DATA PREPARATION (Optional: Randomize PostCode if not using Data File)
// If the variable 'PostCode' is empty, we generate a random 5-digit one
def finalPostCode = (PostCode == null || PostCode == "") ? RandomStringUtils.randomNumeric(5) : PostCode

// 4. INPUT: Enter customer details using Variables
WebUI.waitForElementVisible(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_First Name'), 5)

WebUI.setText(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_First Name'), FirstName)
WebUI.setText(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_Last Name'), LastName)
WebUI.setText(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_Post Code_1'), finalPostCode)

// 5. ACTION: Submit the form
WebUI.click(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/button_Add Customer_1'))

// 6. VERIFICATION
// Step A: Handle the browser alert
WebUI.verifyAlertPresent(5)
def actualAlertText = WebUI.getAlertText()

println(">>> [EXECUTION] Adding Customer: ${FirstName} ${LastName} (${finalPostCode})")
println(">>> [RESULT] Alert Text: ${actualAlertText}")

// Step B: Match using Regex to ignore the dynamic Customer ID number
WebUI.verifyMatch(actualAlertText, 'Customer added successfully with customer id :\\d+', true, FailureHandling.STOP_ON_FAILURE)

// 7. TEARDOWN: Accept the alert to return to the dashboard
WebUI.acceptAlert()

println(">>> SUCCESS: New customer added and verified.")