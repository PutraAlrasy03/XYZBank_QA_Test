import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Call the Base Test Case to open the browser
WebUI.callTestCase(findTestCase('Home_Page'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. SELECT 'Hermoine Granger' from the dropdown
// We use 'selectOptionByLabel' instead of 'click' for dropdown lists.
// The 'false' at the end means we are not using Regular Expressions (Regex).
WebUI.selectOptionByLabel(findTestObject('Page_Customer/Page_XYZ Bank/select_---Your Name---       Hermoine GrangerHarry PotterRon WeaslyAlbus DumbledoreNeville Longbottom'), 'Hermoine Granger', false)

// 3. Click the Login Button
// Note: I removed "Object Repository/" from the start of the path because findTestObject automatically looks there.
WebUI.click(findTestObject('Page_Customer/Page_XYZ Bank/button_Login'))

// Optional: Verify that the login worked by checking if the "Welcome" text appears
WebUI.verifyTextPresent('Welcome Hermoine Granger', false)