import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


// 1. PRECONDITION: Login
WebUI.callTestCase(findTestCase('Manager_Testcase/TC_MGR_01_Login'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. NAVIGATE: Go to the 'Customers' list
WebUI.click(findTestObject('Page_Manager_Dashboard/Page_CustomersList/button_Customers'))

// 3. SEARCH: Type the name
WebUI.setText(findTestObject('Page_Manager_Dashboard/Page_CustomersList/input_Search Customer'), customerName)

// --- CRITICAL QA STEP 1: VERIFY RESULT BEFORE DELETING ---

// A. Wait a moment for the table to filter
WebUI.delay(2)

// B. Define the object for the "First Row, First Name Cell"
// (This XPath //tbody/tr[1]/td[1] always finds the first name in the first row)
TestObject firstCell = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//tbody/tr[1]/td[1]')

// C. Verify the text in that cell matches "Harry"
String actualName = WebUI.getText(firstCell)
WebUI.verifyMatch(actualName, customerName, false)

println(">>> VERIFICATION PASSED: Found " + actualName + " in the search results.")

// ---------------------------------------

// 4. ACTION: Delete the customer
// (We use the Delete button specifically for the first row)
TestObject deleteButton = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//tbody/tr[1]/td[5]/button')
WebUI.click(deleteButton)

// --- CRITICAL QA STEP 2: VERIFY THE DELETION ---

// A. Wait for the table to refresh
WebUI.delay(2)

// B. Create a dynamic object that looks for the name "Harry" anywhere in the table
// XPath meaning: Find any cell (td) that contains the text 'Harry'
TestObject deletedName = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//td[normalize-space()='" + customerName + "']")

// C. Verify that this object is NO LONGER PRESENT
// If "Harry" is still there, this step will FAIL (which is what we want!)
WebUI.verifyElementNotPresent(deletedName, 5)

println(">>> SUCCESS: " + customerName + " has been successfully deleted and is gone from the list!")