package com.dijkstra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RandomModePage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "(//h1[text()='Dijkstra’s Algorithm Calculator'])[1]")
	WebElement ele_LandingPageHeader;

	@FindBy(xpath = "//p[contains(text(),'Discovering Optimal Routes Through Nodes Using Dijkstra')]")
	WebElement ele_LandingSubPageHeader;

	@FindBy(xpath = "//span[text()='Enable Random Mode']/../div")
	WebElement ele_randomModeToggle;

	@FindBy(xpath = "//img[@src='/refresh.svg']")
	WebElement img_refreshIcon;

	public RandomModePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLandingPageHeaders() {
		return ele_LandingPageHeader.isDisplayed() && ele_LandingSubPageHeader.isDisplayed();
	}

	public void clickOnToggleRandomMode() {
		ele_randomModeToggle.click();

	}

	public boolean isRefreshIconDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img_refreshIcon.isDisplayed();
	}

}