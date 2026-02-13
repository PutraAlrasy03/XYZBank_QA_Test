import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. PRECONDITION: Login (Ensure TC_M01 doesn't open browser if Listener is used)
WebUI.callTestCase(findTestCase('Manager_Testcase/TC_MGR_01_Login'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Navigate to Open Account Tab (Don't forget this step!)
WebUI.click(findTestObject('Page_Manager_Dashboard/Page_OpenAccount/button_Open Account'))

// 3. Select Customer and Currency
// Cleaned up the dot, corrected variable name to 'FirstName', and set Regex to 'true'
WebUI.selectOptionByLabel(findTestObject('Page_Manager_Dashboard/Page_OpenAccount/select_---Customer Name---       Hermoine GrangerHarry PotterRon WeaslyAlbus DumbledoreNeville Longbottom'), FirstName, false)

WebUI.selectOptionByValue(findTestObject('Page_Manager_Dashboard/Page_OpenAccount/select_currency'), 'Dollar', false)

// 4. Click Process
WebUI.click(findTestObject('Page_Manager_Dashboard/Page_OpenAccount//button_Process'))

// 5. Verify the Alert Appears
WebUI.verifyAlertPresent(5)

// 6. Capture and Verify the text
def actualAlertText = WebUI.getAlertText()
println(">>> ACTUAL ALERT: " + actualAlertText)

WebUI.verifyMatch(actualAlertText, 'Account created successfully with account Number.*', true)

// 7. Close the Alert
WebUI.acceptAlert()