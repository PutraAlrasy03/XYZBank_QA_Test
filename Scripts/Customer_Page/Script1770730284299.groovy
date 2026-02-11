import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// The Listener automatically opens the browser and navigates to the URL!

// 1. Click the Initial "Customer Login" Button
WebUI.click(findTestObject('Page_Home/Page_XYZ Bank/button_Customer Login'))

// 2. Select the name from the dropdown using the VARIABLE (linked to your Excel file)
WebUI.selectOptionByLabel(findTestObject('Page_Customer/Page_XYZ Bank/select_---Your Name---       Hermoine GrangerHarry PotterRon WeaslyAlbus DumbledoreNeville Longbottom'), customerName, false)

// 3. Click the Login Button
WebUI.click(findTestObject('Page_Customer/Page_XYZ Bank/button_Login'))

// 4. Verify that the login worked dynamically
WebUI.verifyTextPresent('Welcome ' + customerName, false)

// The Listener will automatically close the browser after this finishes!