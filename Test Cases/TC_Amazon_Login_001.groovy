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

// Click on the Sign-in button
WebUI.waitForElementClickable(findTestObject('Object Repository/Amazon_Login_OR/Page_Amazon.com. Spend less. Smile more/span_Sign in'), 
    10, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Amazon_Login_OR/Page_Amazon.com. Spend less. Smile more/span_Sign in'))

// Enter email or phone number
WebUI.waitForElementVisible(findTestObject('Object Repository/Amazon_Login_OR/Page_Amazon Sign-In/input_Email or mobile phone number_email'), 
    10, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Amazon_Login_OR/Page_Amazon Sign-In/input_Email or mobile phone number_email'), 
    'your_email@example.com') // Replace with actual email

// Click Continue button
WebUI.waitForElementClickable(findTestObject('Object Repository/Amazon_Login_OR/Page_Amazon Sign-In/input_Enter your email or mobile phone numb_fc7402'), 
    10)
WebUI.click(findTestObject('Object Repository/Amazon_Login_OR/Page_Amazon Sign-In/input_Enter your email or mobile phone numb_fc7402'))

// Enter password
WebUI.waitForElementVisible(findTestObject('Object Repository/Amazon_Login_OR/Page_Amazon Sign-In/input_Forgot your password_password'), 
    10, FailureHandling.STOP_ON_FAILURE)
WebUI.setEncryptedText(findTestObject('Object Repository/Amazon_Login_OR/Page_Amazon Sign-In/input_Forgot your password_password'), 
    'your_encrypted_password') // Replace with encrypted password from Katalon Studio

// Click Sign-in button
WebUI.waitForElementClickable(findTestObject('Object Repository/Amazon_Login_OR/Page_Amazon Sign-In/input_Enter your password_signInSubmit'), 
    10)
WebUI.click(findTestObject('Object Repository/Amazon_Login_OR/Page_Amazon Sign-In/input_Enter your password_signInSubmit'))

// Close browser after login
WebUI.delay(5) // Allow some time to verify login
WebUI.closeBrowser()
