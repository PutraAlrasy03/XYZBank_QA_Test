import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID: TC_CUST_01_Login_Valid
// Description: Verify that a valid user can log in successfully.
//              (Uses Data-Driven Testing via 'customerName' variable)
// ===================================================================

// NOTE: Browser Open/Navigate is handled automatically by the Test Listener.

// 1. NAVIGATE TO CUSTOMER LOGIN
WebUI.click(findTestObject('Page_Home/button_Customer Login'))


// 2. SELECT USER DYNAMICALLY
// Wait for the dropdown to be ready (Best Practice)
WebUI.waitForElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), 5)

// Select the name using the 'customerName' variable (linked to Excel)
WebUI.selectOptionByLabel(findTestObject('Page_Customer_Dashboard/Page_Customer_List/select_userSelect'), customerName, false)


// 3. CLICK LOGIN
WebUI.click(findTestObject('Page_Customer_Dashboard/Page_Customer_List/button_Login'))


// 4. VERIFY LOGIN SUCCESS
// Verify that the Welcome message appears with the correct name
WebUI.verifyTextPresent('Welcome ' + customerName, false)

println(">>> TEST PASSED: Successfully logged in as " + customerName)

// NOTE: Browser Close is handled automatically by the Test Listener.