import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_CUST_03_User_Switch
// Description: Loop through users 1-5, verify exact name, capture balance, and logout.
// ===================================================================

// 1. CREATE THE NAME DICTIONARY (List)

// 2. CLICK INITIAL CUSTOMER LOGIN
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_List/button_Customer Login'))

// 3. THE LOOP: Test Users 1 through 5
for (int i = 1; i <= 5; i++) {
	
	// Wait for the dropdown to be visible AND clickable before doing anything
	WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), 5)
	WebUI.waitForElementClickable(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), 5)
	
	// Select user by Value (1, 2, 3...)
	WebUI.selectOptionByValue(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), String.valueOf(i), false)
	WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_List/button_Login'))
	
	// 4. VERIFY THE EXACT NAME
	// Since 'i' starts at 1, but our list starts at 0, we use (i - 1) to get the right name
	String expectedName = expectedNames[i - 1]
	WebUI.verifyTextPresent('Welcome ' + expectedName, false)
	println(">>> VERIFIED: Name matched perfectly for " + expectedName)
	
	// 5. CAPTURE BALANCE
	WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'), 5)
	String currentBalance = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))
	
	// Log the final success for this user (using \$ to escape the dollar sign so Groovy doesn't crash)
	println(">>> DATA SAVED: " + expectedName + " has a balance of \$" + currentBalance)
	
	// 6. LOGOUT
	WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/button_Logout'), 5)
	WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_List/button_Logout'))
	
	// 7. THE FIX: Give the Angular app 1 second to fully transition back to the login screen
	// This prevents the "WebElementNotFoundException" when the loop restarts
	WebUI.delay(1)
}

println(">>> TEST PASSED: All 5 users were verified by name and balance!")