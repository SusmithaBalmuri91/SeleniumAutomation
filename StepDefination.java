package com.stepDefs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination {

	WebDriver driver;

	@Given("^I launch the chrome driver$")
	public void i_launch_the_chrome_driver() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\susmitha\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Then("^I open the google search engine$")
	public void i_open_the_google_search_engine() {
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement textbox = driver.findElement(By.xpath("//input[@name='q']"));
		textbox.sendKeys("LexisNexis");
		textbox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^I click on the third URL$")
	public void i_click_on_the_third_url() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> allLinks = driver.findElements(By.xpath("//*[@id='rso']//h3"));
		allLinks.get(2).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^I get the title of the page$")
	public void i_get_the_title_of_the_page() throws Throwable {
		String pageTitle = driver.getTitle();
		System.out.println("Title of the page is: " + pageTitle);
		driver.quit();
	}
}
