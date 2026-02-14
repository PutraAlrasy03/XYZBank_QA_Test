import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// ===================================================================
// Test Case ID : TC_MGR_04_OpenAccount
// Description  : Open a new account for a specific customer.
// ===================================================================

// 1. PRECONDITION: Login as Bank Manager
WebUI.callTestCase(findTestCase('Manager_Testcase/TC_MGR_01_Login'), [:], FailureHandling.STOP_ON_FAILURE)


// 2. NAVIGATE: Click the 'Open Account' tab
WebUI.click(findTestObject('Page_Manager_Dashboard/Page_OpenAccount/button_Open Account'))


// 3. SELECTION: Choose Customer and Currency
// Note: If 'Object is null' persists, rename this object in the Repository to something shorter.
WebUI.selectOptionByLabel(findTestObject('Page_Manager_Dashboard/Page_OpenAccount/select_---Customer Name---       Hermoine GrangerHarry PotterRon WeaslyAlbus DumbledoreNeville Longbottom'),
	FirstName, false)

WebUI.selectOptionByValue(findTestObject('Page_Manager_Dashboard/Page_OpenAccount/select_currency'), 'Dollar', false)


// 4. ACTION: Click Process
WebUI.click(findTestObject('Page_Manager_Dashboard/Page_OpenAccount/button_Process'))


// 5. VERIFICATION: Handle the Alert
WebUI.verifyAlertPresent(5)

def actualAlertText = WebUI.getAlertText()
println(">>> ACTUAL ALERT: " + actualAlertText)

// Verify message using Regex (.*) to handle dynamic account numbers
WebUI.verifyMatch(actualAlertText, 'Account created successfully with account Number.*', true)


// 6. TEARDOWN: Close Alert
WebUI.acceptAlert()

println(">>> SUCCESS: Account created for " + FirstName)