import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class Global_Setup_Teardown {
	/**
	 * Executes before every test case starts.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		println(">>> STARTING TEST CASE: " + testCaseContext.getTestCaseId())
		
		// 1. Open the browser
		WebUI.openBrowser('')
		
		// 2. Navigate to the banking project URL
		WebUI.navigateToUrl('https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login')
		
		// 3. Maximize the window so elements are visible
		WebUI.maximizeWindow()
	}

	/**
	 * Executes after every test case ends.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		println(">>> FINISHED TEST CASE: " + testCaseContext.getTestCaseId())
		
		// 1. Close the browser regardless of pass/fail
		WebUI.closeBrowser()
	}
}