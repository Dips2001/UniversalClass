package com.stepDefinition;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class UniversalClassTest {
	
	public static WebDriver driver;
	Properties prop;
	File f=new File("src/test/resources/UniversalClassData.xlsx");
	FileInputStream is;
	XSSFWorkbook w;
	static int flag=0;
	
	@Before
	public void beforeScenario() throws IOException {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		FileInputStream fs = new FileInputStream("src/test/resources/UniversalClass.properties");
		prop = new Properties();
		prop.load(fs);
		is=new FileInputStream(f);
		w=new XSSFWorkbook(is);
	}
	
	/******************************* Common Part ****************************/
	
	@Given("UniversalClass website is ready")
	public void universal_class_website_is_ready() {
		System.out.println("Universal Class website is up and running");
	}

	@When("I launch URL in chrome browser")
	public void i_launch_url_in_chrome_browser() {
		driver.get("https://www.universalclass.com/");
		driver.manage().window().maximize();
	}

	@Then("Home page of UniversalClasses website should open")
	public void home_page_of_universal_classes_website_should_open() {
	    String title = driver.getTitle();
	    assertEquals(title, "UniversalClass: Online Courses and Continuing Education");
	}
	
	/******************************* Sign In ****************************/
	
	@When("I click on the Hamburger icon")
	public void i_click_on_the_hamburger_icon() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("hamburger"))));
	    assertTrue(driver.findElement(By.id(prop.getProperty("hamburger"))).isDisplayed());
	}

	@Then("Sign In option should be visible")
	public void sign_in_option_should_be_visible() {
		assertTrue(driver.findElement(By.xpath(prop.getProperty("signin"))).isDisplayed());
	}

	@When("I click on the Sign In option")
	public void i_click_on_the_sign_in_option() {
	    driver.findElement(By.linkText("Sign In")).click();
	}

	@Then("Sign In page should be displayed")
	public void sign_in_page_should_be_displayed() {
	    String title = driver.getTitle();
	    assertEquals(title, "Member Sign In | UniversalClass.com");
	}

	@Then("two textboxes for email and password should be visible and enabled")
	public void two_textboxes_for_email_and_password_should_be_visible_and_enabled() {
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    assertTrue(driver.findElement(By.id(prop.getProperty("uid"))).isEnabled());
	    assertTrue(driver.findElement(By.id(prop.getProperty("pwd"))).isEnabled());
	}

	@Then("a Sign In button should be visible and clickable")
	public void a_sign_in_button_should_be_visible_and_clickable() {
	    assertTrue(driver.findElement(By.name(prop.getProperty("submit"))).isDisplayed());
	}
	
	@When("I enter valid email as <{string}> in Sign In page")
	public void i_enter_valid_email_as_in_sign_in_page(String string) {
	    driver.findElement(By.id(prop.getProperty("uid"))).sendKeys(string);
	}

	@When("I enter valid password as <{string}> in Sign In page")
	public void i_enter_valid_password_as_in_sign_in_page(String string) {
		driver.findElement(By.id(prop.getProperty("pwd"))).sendKeys(string);
	}

	@When("I click on Sign In button")
	public void i_click_on_sign_in_button() {
		driver.findElement(By.name(prop.getProperty("submit"))).click();
	}
	
	@Then("I wait")
	public void i_wait() {
		WebDriverWait wait = new WebDriverWait(driver,80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("cc_button"))));
	}

	@Then("I get logged in to our respective profiles")
	public void i_get_logged_in_to_our_respective_profiles() {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("signed_heading"))));
	}

	@When("I enter email as <{string}> in Sign In page")
	public void i_enter_email_as_in_sign_in_page(String string) {
		driver.findElement(By.id(prop.getProperty("uid"))).sendKeys(string);
	}

	@When("I enter password as <{string}> in Sign In page")
	public void i_enter_password_as_in_sign_in_page(String string) {
		driver.findElement(By.id(prop.getProperty("pwd"))).sendKeys(string);
	}

	@Then("I get an error message stating that email or password is incorrect")
	public void i_get_an_error_message_stating_that_email_or_password_is_incorrect() {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("signed_alert"))));
	}
	
	/******************************* Forgot Password ****************************/
	
	@Then("a Forgot Password link should be visible")
	public void a_forgot_password_link_should_be_visible() {
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("fp_link"))).isDisplayed());
	}

	@When("I click on the Forgot your password link")
	public void i_click_on_the_forgot_your_password_link() {
		driver.findElement(By.xpath(prop.getProperty("fp_link"))).click();
	}

	@Then("Forgot Password page should be displayed")
	public void forgot_password_page_should_be_displayed() {
	    String title=driver.getTitle();
	    assertEquals(title, "Password Recovery | UniversalClass.com");
	}

	@Then("a textbox for email should be visible and enabled")
	public void a_textbox_for_email_should_be_visible_and_enabled() {
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    assertTrue(driver.findElement(By.name(prop.getProperty("email"))).isEnabled());
	}

	@Then("a Recover Password button should be visible and clickable")
	public void a_recover_password_button_should_be_visible_and_clickable() {
		assertTrue(driver.findElement(By.name(prop.getProperty("recover"))).isDisplayed());
	}

	@When("I enter valid email in Forgot Password page")
	public void i_enter_valid_email_in_forgot_password_page() {
		XSSFSheet sheet=w.getSheetAt(0);
		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		driver.findElement(By.name(prop.getProperty("email"))).sendKeys(email);
	}

	@When("I click on Recover Password button")
	public void i_click_on_recover_password_button() {
		driver.findElement(By.name(prop.getProperty("recover"))).click();
	}

	@Then("I get a Password Reset Request mail")
	public void i_get_a_password_reset_request_mail() {
		assertTrue(driver.findElement(By.xpath(prop.getProperty("fp_confirm"))).isDisplayed());
	}

	@When("I enter invalid email in Forgot Password page")
	public void i_enter_invalid_email_in_forgot_password_page() {
		XSSFSheet sheet=w.getSheetAt(0);
		String email=sheet.getRow(2).getCell(0).getStringCellValue();
		driver.findElement(By.name(prop.getProperty("email"))).sendKeys(email);
	}
	
	@When("I enter null email in Forgot Password page")
	public void i_enter_null_email_in_forgot_password_page() {
		XSSFSheet sheet=w.getSheetAt(0);
		String email=sheet.getRow(3).getCell(0).getStringCellValue();
		driver.findElement(By.name(prop.getProperty("email"))).sendKeys(email);
	}

	@Then("I get an error message stating that email was not found")
	public void i_get_an_error_message_stating_that_email_was_not_found() {
		assertTrue(driver.findElement(By.xpath(prop.getProperty("fp_alert"))).isDisplayed());
	}
	
	
	/******************************* Search Courses ****************************/
	
	@Then("a search box should be visible and enabled")
	public void a_search_box_should_be_visible_and_enabled() {
	    assertTrue(driver.findElement(By.name(prop.getProperty("search_text"))).isEnabled());
	}

	@Then("a search icon should be visible and clickable")
	public void a_search_icon_should_be_visible_and_clickable() {
		assertTrue(driver.findElement(By.xpath(prop.getProperty("search_button"))).isDisplayed());
	}

	@When("I enter search string as <{string}>")
	public void i_enter_search_string_as(String string) {
		driver.findElement(By.name(prop.getProperty("search_text"))).sendKeys(string);
	}

	@When("I click on search icon")
	public void i_click_on_search_icon() {
		driver.findElement(By.xpath(prop.getProperty("search_button"))).click();
	}
	
	@Then("I get course results related to searched string")
	public void i_get_course_results_related_to_searched_string() {
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    String title=driver.getTitle();
	    assertEquals(title, "Search | UniversalClass.com");
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("search_result"))).isDisplayed());
	}
	
	@Then("I get suggestions of available courses")
	public void i_get_suggestions_of_available_courses() {
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    String title=driver.getTitle();
	    assertEquals(title, "Search | UniversalClass.com");
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("search_result"))).isDisplayed());
	}
	
	
	/******************************* Course Catalog ****************************/
	@Then("I should see Course Catalog button")
	public void i_should_see_course_catalog_button() {
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("cc_button"))).isDisplayed());
	}
	
	@When("I click on Course Catalog button")
	public void i_click_on_course_catalog_button() {
	    driver.findElement(By.xpath(prop.getProperty("cc_button"))).click();
	}
	
	@Then("I get list of available courses")
	public void i_get_list_of_available_courses() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(700);
	}
	
	
	/******************************* My Classes ****************************/
	
	@Then("I should see My Classes button")
	public void i_should_see_my_classes_button() {
		assertTrue(driver.findElement(By.xpath(prop.getProperty("mc_button"))).isDisplayed());
	}

	@When("I click on My Classes button")
	public void i_click_on_my_classes_button() {
		driver.findElement(By.xpath(prop.getProperty("mc_button"))).click();
	}

	@Then("joined courses should be displayed")
	public void joined_courses_should_be_displayed() {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("mc_result"))));
	}
	
	@After
	public void afterScenario() {
		driver.quit();
	}
}
