import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// The Listener automatically opens the browser and navigates to the URL before this runs!

WebUI.click(findTestObject('Page_Home/Page_XYZ Bank/button_Customer Login'))

// 1. SELECT the name from the dropdown using the VARIABLE
// Notice we use the variable customerName instead of 'Hermoine Granger'
WebUI.selectOptionByLabel(findTestObject('Page_Customer/Page_XYZ Bank/select_---Your Name---       Hermoine GrangerHarry PotterRon WeaslyAlbus DumbledoreNeville Longbottom'), customerName, false)

// 2. Click the Login Button
WebUI.click(findTestObject('Page_Customer/Page_XYZ Bank/button_Login'))

// 3. Verify that the login worked dynamically
// We use string interpolation to check for "Welcome [Variable]"
WebUI.verifyTextPresent('Welcome ' + customerName, false)

// The Listener will automatically close the browser after this script finishes!