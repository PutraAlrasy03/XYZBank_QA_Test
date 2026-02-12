import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Click the 'Bank Manager Login' button
WebUI.click(findTestObject('Manager_Obj/button_Bank Manager Login'))

// 2. Verify that the user is successfully routed to the Bank Manager dashboard
WebUI.verifyElementVisible(findTestObject('Manager_Obj/button_Open Account'))