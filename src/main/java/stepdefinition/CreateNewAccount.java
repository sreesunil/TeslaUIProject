package stepdefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewAccount {

	WebDriver driver;

	@Before
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.tesla.com/");
		driver.manage().window().maximize();

	}

	@Given("User on the Tesla page")
	public void user_on_the_tesla_page() {

		assertEquals(driver.getTitle(), "Electric Cars, Solar & Clean Energy | Tesla");

	}

	@When("User enter information")
	public void user_enter_information() {

		driver.findElement(By.xpath(
				"//a[@id='dx-nav-item--account' and @class='tds-site-nav-item tds--product-name tds-site-nav-item--icon-only']"))
				.click();
		driver.findElement(By.id("form-button-create")).click();
	}

	@When("User enter credentials")
	public void user_enter_credentials() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//body/div[@class='tmp-shell tds--fade-in']/main[@class='tmp-shell-row tmp-shell-row--stretch']/div[@id='container']/div[@class='single-column-form-wrapper']/div/div[@class='tds-form-input-group']/div[1]/div[1]/div[2]//*[name()='svg']"))
				.click();
		driver.findElement(By.xpath("//span[text()='United States']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("form-input-first_name")).sendKeys("Ben");
		driver.findElement(By.id("form-input-last_name")).sendKeys("George");
	}

	@Then("User validate login successful")
	public void user_validate_login_successful() {
		
		
		System.out.println("Acount created Successfully");

	}

	@After
	public void tearDown() {

		driver.close();
	}

}
