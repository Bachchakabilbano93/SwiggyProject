package com.Swiggy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingOutputs {

	public static String URL = "https://www.swiggy.com/";
	public static By textbox = By.xpath("//input[@id='location']");
	public WebDriver driver;
	public static String assertVal;
	public static String locSelect;
	public static By restaurantPage = By.className("BZR3j");
	public static By locPage = By.xpath("//span[@class='_3HusE']");
	public static By resItem = By.className("nA6kb");
	public static String resName;
	public static By resItempage = By.xpath("//p[@class='RestaurantNameAddress_name__2IaTv']");
	public static String respageName;
	



	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub	
		System.setProperty("webdriver.chrome.driver", "./BrowserUtils/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(textbox).sendKeys("Kolkata");
		Thread.sleep(2000);
		List<WebElement> test = driver.findElements(By.xpath(".//button[contains(@class,'_3lmRa')]"));
		System.out.println(test);

		for (WebElement webElement : test) {

			if (test.indexOf(webElement)==0) {
				
				locSelect = webElement.getText();
				webElement.click();
				Thread.sleep(3000);


			}

		}
		

		assertVal = driver.findElement(locPage).getText();
		System.out.println(assertVal);
		Thread.sleep(3000);
		
		if (locSelect.equalsIgnoreCase(assertVal)) {
			
			System.out.println("Locations are same");
			
		} else {
			
			System.out.println("Incorrect Location");

		}
		
		List<WebElement> restaurantList = driver.findElements(resItem);

		for (WebElement res : restaurantList) {

			if (restaurantList.indexOf(res)==1) {
				
				resName = res.getText();
				res.click();
				
			}

		}
		
		System.out.println(resName);
		
		Thread.sleep(3000);
		
		respageName = driver.findElement(resItempage).getText();
		
		if (resName.equalsIgnoreCase(respageName)) {

			System.out.println("Test case is passed");

		}

		else {

			System.out.println("Test case is failed");

		}
		
		Thread.sleep(3000);

		driver.close();

	}

}

