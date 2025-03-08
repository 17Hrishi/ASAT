import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Open browser and navigate to Amazon
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.amazon.com/')

// Function to search for an item within a category
def searchItem(String categoryObject, String categoryValue, String searchBoxObject, String searchKeyword, String searchButtonObject) {
    WebUI.waitForElementPresent(findTestObject(categoryObject), 10, FailureHandling.STOP_ON_FAILURE)
    WebUI.selectOptionByValue(findTestObject(categoryObject), categoryValue, true)

    WebUI.waitForElementPresent(findTestObject(searchBoxObject), 10, FailureHandling.STOP_ON_FAILURE)
    WebUI.setText(findTestObject(searchBoxObject), searchKeyword)

    WebUI.waitForElementClickable(findTestObject(searchButtonObject), 10, FailureHandling.STOP_ON_FAILURE)
    WebUI.click(findTestObject(searchButtonObject))
}

// **Search for Books Category - "Da Vinci Code"**
searchItem(
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com. Spend less. Smile more/select_All Departments',
    'search-alias=stripbooks-intl-ship',
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com. Spend less. Smile more/input_Search Amazon_field-keywords',
    'da vinci code',
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com. Spend less. Smile more/input_Search Amazon_nav-search-submit-button'
)

// **Search for Electronics - "Mobile Phones"**
searchItem(
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com  da vinci code/select_All Departments',
    'search-alias=electronics-intl-ship',
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com  da vinci code/input_Search Amazon_field-keywords',
    'Mobile phones',
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com  da vinci code/input_Search Amazon_nav-search-submit-button'
)

// **Search for Home Appliances - "Washing Machines"**
searchItem(
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com  Mobile phones/select_Electronics',
    'search-alias=aps',
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com  Mobile phones/input_Search Amazon_field-keywords',
    'Washing Machines',
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com  Mobile phones/input_Search Amazon_nav-search-submit-button'
)

// **Search for Furniture - "Wooden Tables"**
searchItem(
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com  Washing Machines/select_Electronics',
    'search-alias=aps',
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com  Washing Machines/input_Search Amazon_field-keywords',
    'Wooden Tables',
    'Object Repository/Amazon_ValidateSearchFieldItem_OR/Page_Amazon.com  Washing Machines/input_Search Amazon_nav-search-submit-button'
)

// Close browser
WebUI.delay(5) // Wait for search results to load before closing
WebUI.closeBrowser()
