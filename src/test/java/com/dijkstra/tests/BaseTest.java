package com.dijkstra.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();

		;
		driver.get("https://curious-halva-9294ed.netlify.app/");
//		test.log(Status.PASS, "Naviagted to URL:" + "\"https://curious-halva-9294ed.netlify.app/\"");

		driver.manage().window().maximize();

		// Add explicit wait to ensure the page is fully loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h1[text()='Dijkstra’s Algorithm Calculator'])[1]")));

//		test.log(Status.PASS, "Landing page loaded");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
