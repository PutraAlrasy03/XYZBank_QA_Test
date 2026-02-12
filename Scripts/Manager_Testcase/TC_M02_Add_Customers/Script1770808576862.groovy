import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// ------------------------------------------------------------------------------------
// TEST CASE: TC_M02
// DESCRIPTION: Verify Bank Manager can add a new customer with valid details (Data-Driven).
// ------------------------------------------------------------------------------------

// 1. PRECONDITION: Log in as Bank Manager
WebUI.callTestCase(findTestCase('Manager_Testcase/TC_M01'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. NAVIGATE: Click the 'Add Customer' tab
WebUI.click(findTestObject('Manager_Obj/Add_Customer_Obj/button_Add Customer'))

// 3. INPUT: Enter customer details using VARIABLES
// Note: We use the variables here instead of "Putra" or "Alrasy"
WebUI.setText(findTestObject('Manager_Obj/Add_Customer_Obj/input_First Name'), FirstName)
WebUI.setText(findTestObject('Manager_Obj/Add_Customer_Obj/input_Last Name'), LastName)
WebUI.setText(findTestObject('Manager_Obj/Add_Customer_Obj/input_Post Code_1'), PostCode)

// 4. ACTION: Click the 'Add Customer' submit button
WebUI.click(findTestObject('Manager_Obj/Add_Customer_Obj/button_Add Customer_1'))

// 5. VERIFICATION
// Step A: Verify the alert popup actually appears
WebUI.verifyAlertPresent(5)

// Step B: Capture and Print the text
def actualAlertText = WebUI.getAlertText()
println(">>> ADDING CUSTOMER: " + FirstName + " " + LastName)
println(">>> ALERT RESULT: " + actualAlertText)

// Step C: Verify the text matches the Expected Result using Regex
WebUI.verifyMatch(actualAlertText, 'Customer added successfully with customer id.*', true)

// 6. TEARDOWN: Close the alert
WebUI.acceptAlert()