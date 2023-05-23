package com.Swiggy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwiggyPageObjects {

	public WebDriver driver;

	public SwiggyPageObjects(WebDriver driver) {

		this.driver = driver;

	}

	public static String assertVal;
	public static String resName;
	public static String respageName;
	public static String locSelect;
	public static String URL = "https://www.swiggy.com/";
	public static By textBox = By.xpath("//input[@id='location']");
	public static By searchList = By.xpath("//button[contains(@class,'_3lmRa')]");
	public static By restaurantPage = By.className("BZR3j");
	public static By locPage = By.xpath("//span[@class='_3HusE']");
	public static By resItem = By.className("nA6kb");

	public static By resItempage = By.xpath("//*[@class='RestaurantNameAddress_name__2IaTv']");

	public void selectLocation() throws InterruptedException {
		List<WebElement> Locations = driver.findElements(searchList);
		for (WebElement loc : Locations) {			

			if (Locations.indexOf(loc)==0) {

				locSelect = loc.getText();
				loc.click();
//				Thread.sleep(3000);
				

			}

		}
		
	}
	
	public void locSelected() throws InterruptedException {
		
//		Thread.sleep(3000);
		assertVal = driver.findElement(locPage).getText();
//		System.out.println(assertVal);

	}

	public void selectRestaurant() {
		List<WebElement> restaurantList = driver.findElements(resItem);

		for (WebElement res : restaurantList) {

			if (restaurantList.indexOf(res)==1) {

				resName = res.getText();
				res.click();

			}

		}

	}
	

	public void pageRestaurant() throws InterruptedException {
		
//		Thread.sleep(3000);

		respageName = driver.findElement(resItempage).getText();

		if (resName==respageName) {

			System.out.println("Test case is passed");

		}

		else {

			System.out.println("Test case is failed");

		}

	}

}
