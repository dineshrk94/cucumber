package com.telecom.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddCustomerSteps {
	
	static WebDriver driver ;
	
	@Given("user launches telecom application")
	public void user_launches_telecom_application() {
		
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.get("http://www.demo.guru99.com/telecom/");
	 driver.manage().window().maximize();
	 	   
	}

	@Given("user click on add customer button")
	public void user_click_on_add_customer_button() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	  
	}

	@When("user need to fill up the fields")
	public void user_need_to_fill_up_the_fields() {
		driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		driver.findElement(By.id("fname")).sendKeys("Dinesh");
		driver.findElement(By.id("lname")).sendKeys("Kumar");
		driver.findElement(By.id("email")).sendKeys("nddinesh479@gmail.com");
		driver.findElement(By.name("addr")).sendKeys("Thanjavur");
		driver.findElement(By.id("telephoneno")).sendKeys("9123524910");
	}

	@When("user click on submit button")
	public void user_click_on_submit_button() {
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
	
	}

	@Then("user verify customer id is generated")
	public void user_verify_customer_id_is_generated() {
	   
		Assert.assertTrue(driver.findElement(By.id("(//td[@align='center'])[2]")).isDisplayed());
		String D = driver.findElement(By.id("(//td[@align='center'])[2]")).getText ();
	    System.out.println(D);	
	}
}
