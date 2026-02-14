import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_MGR_03_AddCustomer_Invalid
// Description: Verify HTML5 validation prevents adding a customer
//              when mandatory fields (Last Name) are blank.
// ===================================================================

// 1. PRECONDITION: Log in as Bank Manager
WebUI.callTestCase(findTestCase('Manager_Testcase/TC_MGR_01_Login'), [:], FailureHandling.STOP_ON_FAILURE)

// Navigate to Add Customer Tab
WebUI.waitForElementVisible(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/button_Add Customer'), 5)
WebUI.click(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/button_Add Customer'))

// 2. ACTION: Submit data with missing Last Name
WebUI.waitForElementVisible(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_First Name'), 5)

// Fill First Name but leave Last Name empty to trigger specific validation
WebUI.setText(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_First Name'), FirstName)
WebUI.setText(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_Last Name'), '')
WebUI.setText(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_Post Code_1'), '')

WebUI.click(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/button_Add Customer_1'))

// 3. VERIFICATION: HTML5 Validation Message
// Capture the tool-tip message from the browser
String validationMsg = WebUI.getAttribute(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_Last Name'), 'validationMessage')

println(">>> [DEBUG] Browser Validation Message: " + validationMsg)

// Step A: Verify the message contains the expected "Please fill out this field"
// We use regex .* to handle different browser languages or slight variations
WebUI.verifyMatch(validationMsg, '.*Please fill out this field.*', true, FailureHandling.STOP_ON_FAILURE)

// 4. VERIFICATION: Ensure No Success Alert Appeared
// If the validation worked, an alert should NOT exist.
boolean alertExists = WebUI.waitForAlert(2)

if (alertExists) {
	String alertText = WebUI.getAlertText()
	println(">>> [ERROR] Alert appeared: " + alertText)
	WebUI.acceptAlert()
	WebUI.verifyEqual(true, false, FailureHandling.STOP_ON_FAILURE) // Force fail the test
} else {
	println(">>> [SUCCESS] System blocked submission as expected.")
}

println(">>> TEST PASSED: Mandatory field validation verified.")