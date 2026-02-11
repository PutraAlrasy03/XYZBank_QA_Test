import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Manager_Testcase/TC_M01'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Manager_Obj/Add_Customer_Obj/Page_XYZ Bank/button_Add Customer'))

WebUI.setText(findTestObject('Manager_Obj/Add_Customer_Obj/Page_XYZ Bank/input_First Name'), 'Putra')

WebUI.setText(findTestObject('Manager_Obj/Add_Customer_Obj/Page_XYZ Bank/input_Last Name'), 'Alrasy')

WebUI.setText(findTestObject('Manager_Obj/Add_Customer_Obj/Page_XYZ Bank/input_Post Code_1'), '81200')

WebUI.click(findTestObject('Manager_Obj/Add_Customer_Obj/Page_XYZ Bank/button_Add Customer_1'))

// --- NEW STEPS BELOW ---

// 1. Verify that the success alert pops up (Wait up to 5 seconds for it)
WebUI.verifyAlertPresent(5)

// (Optional) Grab the text from the alert to show in your console log
def alertText = WebUI.getAlertText()
println(">>> The browser alert says: " + alertText)

// 2. Click "OK" to close the alert
WebUI.acceptAlert()