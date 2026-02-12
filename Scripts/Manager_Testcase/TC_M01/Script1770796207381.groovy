import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// NOTE: Do NOT use WebUI.openBrowser() here because the Listener already did it!

// 1. Click the 'Bank Manager Login' button
WebUI.click(findTestObject('Manager_Obj/button_Bank Manager Login'))

// 2. Verify that we are on the dashboard (Optional but good)
// Use verifyElementVisible to confirm the next button is ready
WebUI.verifyElementVisible(findTestObject('Manager_Obj/Open_Account_Obj/button_Open Account'))