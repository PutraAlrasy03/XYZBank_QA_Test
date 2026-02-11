import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable 

// 1. Click the Initial Login Button based on the active Profile
WebUI.click(findTestObject(GlobalVariable.Login_Locator))
	
// 2. Handle the next steps based on the role
if (GlobalVariable.Role == 'Customer') {
	println(">>> Logging in as Customer")
	// Add the steps to select "Hermoine Granger" and click Login
    // WebUI.selectOptionByLabel(...)
    // WebUI.click(...)
    
} else if (GlobalVariable.Role == 'Manager') {
	println(">>> Logging in as Manager")
	// For the Manager, usually clicking the first button is enough to reach the dashboard, 
    // but if there are extra steps, put them here.
}

// 3. Verify Login was successful
// You might verify the dashboard appeared here.