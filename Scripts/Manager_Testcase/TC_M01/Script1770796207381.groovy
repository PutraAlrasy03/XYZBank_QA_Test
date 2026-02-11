import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Click the 'Bank Manager Login' button
WebUI.click(findTestObject('Manager_Obj/Page_XYZ Bank/button_Bank Manager Login'))

// 2. Verify that the user is successfully routed to the Bank Manager dashboard
// Notice there is NO comma or number 5 at the end of this line now!
WebUI.verifyElementVisible(findTestObject('Manager_Obj/Page_XYZ Bank/button_Open Account'))