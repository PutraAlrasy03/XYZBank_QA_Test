import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.webui.common.WebUiCommonHelper

// 1. Login & Navigate
WebUI.click(findTestObject('Manager_Obj/Open_Account_Obj/button_Bank Manager Login'))
WebUI.click(findTestObject('Manager_Obj/Open_Account_Obj/button_Open Account'))

// --- SMART SELECT START ---
// This block finds the dropdown, loops through options, and picks the one containing "Harry"

// A. Get the dropdown element directly from the browser
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Manager_Obj/Open_Account_Obj/select_userSelect'), 30)
Select dropdown = new Select(element)

// B. Loop through every name in the list
for (WebElement option : dropdown.getOptions()) {
	// Check if the current option contains your First Name (e.g. "Harry")
	if (option.getText().contains(FirstName)) {
		// Found it! Select it using the full text (e.g. "Harry Potter")
		dropdown.selectByVisibleText(option.getText())
		println(">>> SUCCESS: Found and selected " + option.getText())
		break
	}
}
// --- SMART SELECT END ---

// 2. Select Currency
WebUI.selectOptionByValue(findTestObject('Manager_Obj/Open_Account_Obj/select_currency'), 'Dollar', false)

// 3. Click Process
WebUI.click(findTestObject('Manager_Obj/Open_Account_Obj/button_Process'))

// 4. Verification
WebUI.verifyAlertPresent(5)
def actualAlertText = WebUI.getAlertText()
println(">>> OPEN ACCOUNT ALERT: " + actualAlertText)

WebUI.verifyMatch(actualAlertText, 'Account created successfully with account Number.*', true)
WebUI.acceptAlert()