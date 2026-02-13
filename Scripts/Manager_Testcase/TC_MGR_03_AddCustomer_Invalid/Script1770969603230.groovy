import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_MGR_03_AddCustomer_Invalid
// Description: Verify that the system prevents adding a customer
//              when mandatory fields are left blank, and shows a validation popup.
// ===================================================================

// 1. PRECONDITION: Log in as Bank Manager
WebUI.callTestCase(findTestCase('Manager_Testcase/TC_MGR_01_Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/button_Add Customer'), 5)
WebUI.click(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/button_Add Customer'))

WebUI.waitForElementVisible(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_First Name'), 5)

// 2. ACTION: Submit empty data
// (According to your picture, we are checking the Last Name field's validation)
WebUI.setText(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_First Name'), FirstName) // Let's fill First Name so the error jumps to Last Name
WebUI.setText(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_Last Name'), '')
WebUI.setText(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_Post Code'), '')

WebUI.click(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/button_Add Customer_1'))

// 3. VERIFICATION: HTML5 Validation Message
// We pull the hidden 'validationMessage' attribute directly from the Last Name input field
String validationMsg = WebUI.getAttribute(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/input_Last Name'), 'validationMessage')

println(">>> BROWSER POPUP SAYS: " + validationMsg)

// Verify the text matches what we see in the picture
WebUI.verifyMatch(validationMsg, '.*Please fill out this field.*', true)

// 4. VERIFICATION: Ensure no Alert was triggered
boolean isAlertPresent = WebUI.waitForAlert(2)

if (isAlertPresent) {
	println(">>> TEST FAILED: The system allowed a blank customer to be created.")
	WebUI.verifyAlertNotPresent(1)
} else {
	println(">>> TEST PASSED: System blocked submission and showed the HTML5 popup.")
}