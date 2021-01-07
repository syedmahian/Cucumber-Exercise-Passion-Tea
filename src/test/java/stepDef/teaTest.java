package stepDef;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class teaTest {
	
	
		private static WebDriver driver;
		private static String URL = "http://www.practiceselenium.com/welcome.html";

		
		@Before
		public void setup() {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1366, 768));

		}

		

		@Given("^the correct web address$")
		public void the_correct_web_address() {
			driver.get(URL);
			assertEquals("Welcome", driver.getTitle());

		}

		@When("^I navigate to the 'Menu' page$")
		public void i_navigate_to_the_Menu_page() {
			driver.findElement(By.linkText("Menu")).click();
		}

		@Then("^I can browse a list of the available products\\.$")
		public void i_can_browse_a_list_of_the_available_products() {
			assertThat(driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000453230000 strong")).getText(), is("Green Tea"));
		    assertThat(driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000453231072 strong")).getText(), is("Red Tea"));
		}
		
		

		@When("^I click the checkout button$")
		public void i_click_the_checkout_button() {
			driver.findElement(By.cssSelector(".button-content")).click();
		}

		@Then("^I am taken to the checkout page$")
		public void i_am_taken_to_the_checkout_page() throws InterruptedException {
			driver.findElement(By.cssSelector(".button-content")).click();
			Thread.sleep(2000);
			assertEquals("Check Out", driver.getTitle());
		}
		
		@After
		public void tearDown() {
			driver.close();
		}
	}
	
