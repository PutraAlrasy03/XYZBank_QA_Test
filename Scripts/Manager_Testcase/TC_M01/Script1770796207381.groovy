import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. The Global Listener automatically opens the browser and navigates to the URL before this runs!

// 2. Click the 'Bank Manager Login' button
WebUI.click(findTestObject('Manager_Obj/Page_XYZ Bank/button_Bank Manager Login'))

// 3. Verify that the user is successfully routed to the Bank Manager dashboard
// We do this by verifying that the 'Open Account' button is visible on the screen.
// The '5' tells Katalon to wait up to 5 seconds for the button to appear.
WebUI.verifyElementVisible(findTestObject('Manager_Obj/Page_XYZ Bank/button_Open Account'), 5)

