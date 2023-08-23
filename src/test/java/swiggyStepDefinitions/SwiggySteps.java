package swiggyStepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.Swiggy.SwiggyPageObjects;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwiggySteps {


	public static WebDriver driver;
	SwiggyPageObjects SwiggyPO;
	public static String resPage;
	public static String selectedresName;

	@Before
	public void BeforeAllChr() {

		System.setProperty("webdriver.chrome.driver", "./BrowserUtils/chromedriver.exe");
		driver = new ChromeDriver();
		SwiggyPO = new SwiggyPageObjects(driver);
		driver.manage().window().maximize();

	}

	@Given("^The user is in Swiggy Home Page$")
	public void the_user_is_in_swiggy_home_page() throws Throwable {

		driver.get(SwiggyPO.URL);

	}

	@When("^The user enters (.+)$")
	public void the_user_enters(String location) throws Throwable {

		driver.findElement(SwiggyPO.textBox).sendKeys(location);
		Thread.sleep(3000);

	}

	@Then("^The user clicks on Location from list of locations displayed$")
	public void the_user_clicks_on_location_from_list_of_locations_displayed() throws Throwable {

		SwiggyPO.selectLocation();
		Thread.sleep(3000);
		SwiggyPO.locSelected();

	}

	@Then("^Verify the user is in restaurants page as per location selected$")
	public void verify_the_user_is_in_restaurants_page_as_per_location_selected() throws Throwable {

		Thread.sleep(3000);
		resPage = driver.findElement(SwiggyPO.locPage).getText();
		Assert.assertEquals(resPage, SwiggyPO.locSelect);

	}

	@When("^The user clicks on any restaurant$")
	public void the_user_clicks_on_any_restaurant() throws Throwable {

		Thread.sleep(3000);
		SwiggyPO.selectRestaurant();
		Thread.sleep(3000);

	}

	@Then("^Verify that the correct restaurant page is opened$")
	public void verify_that_the_correct_restaurant_page_is_opened() throws Throwable {

		Thread.sleep(3000);
		selectedresName = driver.findElement(SwiggyPO.resItempage).getText();
		Assert.assertEquals(selectedresName, SwiggyPO.resName);

	}

	@After
	public void AfterAll() {

		driver.close();

	}

}


