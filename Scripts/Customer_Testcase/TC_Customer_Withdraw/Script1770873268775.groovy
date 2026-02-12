import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Call Login Test Case
WebUI.callTestCase(findTestCase('Customer_Testcase/Customer_Page'), [('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)

// 2. Click Withdrawal Tab
WebUI.click(findTestObject('Page_Customer/Customer_Withdraw_Obj/button_Withdrawl'))

// --- VERIFY WITHDRAWAL PAGE IS OPEN ---
// We check if the "Amount to be Withdrawn" label appears before continuing
WebUI.waitForElementVisible(findTestObject('Page_Customer/Customer_Withdraw_Obj/label_Amount to be Withdrawn _'), 5)
WebUI.verifyElementPresent(findTestObject('Page_Customer/Customer_Withdraw_Obj/label_Amount to be Withdrawn _'), 5)

// 3. Input Amount
WebUI.setText(findTestObject('Page_Customer/Customer_Withdraw_Obj/input_amount'), '400')

// 4. Click the Submit button (Check your Object name, it might be button_Withdraw instead of Login)
WebUI.click(findTestObject('Page_Customer/Customer_Withdraw_Obj/button_Login'))

// --- VERIFY SUCCESSFUL TRANSACTION ---
// We wait for the "Transaction successful" message to appear
WebUI.waitForElementVisible(findTestObject('Page_Customer/Customer_Withdraw_Obj/span_Transaction successful'), 5)
WebUI.verifyElementText(findTestObject('Page_Customer/Customer_Withdraw_Obj/span_Transaction successful'), 'Transaction successful')

println(">>> Withdrawal of 400 was successful!")