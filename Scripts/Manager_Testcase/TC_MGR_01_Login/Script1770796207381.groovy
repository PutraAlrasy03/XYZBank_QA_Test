import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// ===================================================================
// Test Case ID : TC_MGR_01_Login
// Description  : Verify that the Bank Manager can log in and view
//                the management dashboard buttons.
// ===================================================================

// 1. ACTION: Click the 'Bank Manager Login' button
// We assume the browser is already at the Home Page from the Listener
WebUI.waitForElementVisible(findTestObject('Page_Manager_Dashboard/button_Bank Manager Login'), 10)
WebUI.click(findTestObject('Page_Manager_Dashboard/button_Bank Manager Login'))

// 2. VERIFICATION: Ensure the Manager Dashboard is fully loaded
// A good manager login test verifies all 3 core management options are visible
WebUI.waitForElementVisible(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/button_Add Customer'), 5)

WebUI.verifyElementVisible(findTestObject('Page_Manager_Dashboard/Page_AddCustomer/button_Add Customer'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Page_Manager_Dashboard/Page_OpenAccount/button_Open Account'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Page_Manager_Dashboard/Page_CustomersList/button_Customers'), FailureHandling.STOP_ON_FAILURE)

println(">>> SUCCESS: Bank Manager logged in. All management options are visible.")