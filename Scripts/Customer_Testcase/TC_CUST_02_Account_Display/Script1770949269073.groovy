import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. LOGIN
WebUI.callTestCase(findTestCase('Customer_Testcase/TC_CUST_01_Login_Valid'),
	[('customerName') : customerName], FailureHandling.STOP_ON_FAILURE)

// 2. VERIFY BALANCE (Object Check)
// This checks if the Balance number is actually visible
WebUI.verifyElementVisible(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))

// 3. (Optional) Print the balance to the console log
String currentBalance = WebUI.getText(findTestObject('Page_Customer_Dashboard/Page_Customer_List/balance_amount'))
println(">>> LOGIN SUCCESS: " + customerName + " | BALANCE: " + currentBalance)