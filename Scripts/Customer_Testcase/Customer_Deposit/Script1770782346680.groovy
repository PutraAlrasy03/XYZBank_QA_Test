import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Call Login Test Case dynamically using the 'customerName' variable
WebUI.callTestCase(findTestCase('Customer_Testcase/Customer_Page'), [('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)

// 2. Click the 'Deposit' tab
WebUI.click(findTestObject('Page_Customer/Customer_Obj/button_Deposit'))

// 3. Enter a hardcoded deposit amount (since the data file only has names)
WebUI.setText(findTestObject('Page_Customer/Customer_Obj/input_amount'), '100')

// 4. Click the 'Deposit' submit button
WebUI.click(findTestObject('Page_Customer/Customer_Obj/button_Deposit_1'))

// 5. Verify the success message appears
WebUI.verifyElementPresent(findTestObject('Page_Customer/Customer_Obj/span_Deposit Successful'), 5)