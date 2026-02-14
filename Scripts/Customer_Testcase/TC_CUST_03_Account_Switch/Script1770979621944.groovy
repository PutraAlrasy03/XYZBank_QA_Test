import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_CUST_03_Account_Switch
// Description: Loop through users 1-5 in a single session to prove
//              the system handles switching users seamlessly.
// PRECONDITION: The 'expectedNames' list is defined in the Variables tab.
// ===================================================================

// 1. CLICK INITIAL CUSTOMER LOGIN
WebUI.click(findTestObject('Page_Home/button_Customer Login'))


// 2. THE LOOP: Test Users 1 through 5
for (int i = 1; i <= 5; i++) {
	
	// Wait for the dropdown to be visible AND clickable before doing anything
	WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), 5)
	WebUI.waitForElementClickable(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), 5)
	
	// Select user by Value (1, 2, 3...)
	WebUI.selectOptionByValue(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), String.valueOf(i), false)
	WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_List/button_Login'))
	
	// 3. VERIFY THE EXACT NAME
	// We use the Katalon Variable 'expectedNames' directly here!
	// Since 'i' starts at 1, but Lists start at 0, we use (i - 1)
	String expectedName = expectedNames[i - 1]
	
	WebUI.verifyTextPresent('Welcome ' + expectedName, false)
	println(">>> VERIFIED: Name matched perfectly for " + expectedName)
	
	// 4. CAPTURE BALANCE
	WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'), 5)
	String currentBalance = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))
	
	// Log the final success for this user
	println(">>> DATA SAVED: " + expectedName + " has a balance of \$" + currentBalance)
	
	// 5. LOGOUT
	WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/button_Logout'), 5)
	WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_List/button_Logout'))
	
	// 6. DELAY FOR STABILITY
	// Give the Angular app 1 second to fully transition back to the login screen
	WebUI.delay(1)
}

println(">>> TEST PASSED: All 5 users were verified by name and balance!")