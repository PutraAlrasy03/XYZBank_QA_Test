import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

class Global_Setup_Teardown {

	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {

		println(">>> STARTING TEST CASE: " + testCaseContext.getTestCaseId())

		// Open browser (from profile if defined)
		WebUI.openBrowser('')
		WebUI.maximizeWindow()

		// Navigate using GlobalVariable
		WebUI.navigateToUrl(GlobalVariable.baseURL)

		// Wait until home page is ready
		WebUI.waitForElementVisible(
			findTestObject('Page_Home/button_Customer Login'),
			10
		)
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {

		println(">>> FINISHED TEST CASE: " + testCaseContext.getTestCaseId())

		// Take screenshot if failed
		if (testCaseContext.getTestCaseStatus() == "FAILED") {
			WebUI.takeScreenshot()
		}

		WebUI.closeBrowser(FailureHandling.OPTIONAL)
	}
}
