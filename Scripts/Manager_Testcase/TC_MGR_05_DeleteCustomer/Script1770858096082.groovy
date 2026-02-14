import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// ===================================================================
// Test Case ID : TC_MGR_05_SearchAndDeleteCustomer
// Description  : 1. Search for customer by name.
//                2. Verify search result accuracy.
//                3. Delete customer and verify they are removed.
// ===================================================================

// 1. PRECONDITION: Login as Bank Manager
WebUI.callTestCase(findTestCase('Manager_Testcase/TC_MGR_01_Login'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. NAVIGATE: Go to the 'Customers' list
WebUI.click(findTestObject('Page_Manager_Dashboard/Page_CustomersList/button_Customers'))

// 3. SEARCH: Type the customer name
WebUI.waitForElementVisible(findTestObject('Page_Manager_Dashboard/Page_CustomersList/input_Search Customer'), 10)
WebUI.setText(findTestObject('Page_Manager_Dashboard/Page_CustomersList/input_Search Customer'), customerName)

// --- STEP 1: VERIFY RESULT BEFORE DELETING ---

// Define the object for the First Name cell in the first filtered row
TestObject firstCell = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//table/tbody/tr[1]/td[1]')

// Explicit wait for the filtered name to appear
WebUI.waitForElementPresent(firstCell, 5)

String actualName = WebUI.getText(firstCell)
println(">>> [SEARCH VERIFICATION] Expected: ${customerName} | Actual: ${actualName}")

// Verify the search actually found the correct person
WebUI.verifyMatch(actualName, customerName, false, FailureHandling.STOP_ON_FAILURE)

// --- STEP 2: ACTION - DELETE ---

// Define the Delete button for that specific row
TestObject deleteButton = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//table/tbody/tr[1]/td[5]/button')

WebUI.click(deleteButton)
println(">>> [ACTION] Clicked Delete for ${customerName}.")

// --- STEP 3: VERIFY DELETION ---

// Small delay to allow Angular table to update its DOM
WebUI.delay(2)

// Create a dynamic object to search for the name anywhere in the table
TestObject deletedNameObj = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//td[text()='" + customerName + "']")

// Verify the name is NO LONGER in the table
WebUI.verifyElementNotPresent(deletedNameObj, 5)

println(">>> [SUCCESS] ${customerName} has been wiped from the database.")