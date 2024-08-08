package com.dijkstra.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPathPage {
	WebDriver driver;

	@FindBy(xpath = "//h3[text()='Select Path']")
	WebElement ele_SelectPath;

	@FindBy(id = "fromNode")
	WebElement dd_fromNode;

	@FindBy(id = "toNode")
	WebElement dd_toNode;

	@FindBy(xpath = "//div[@id='fromNode']")
	WebElement dd_fromValue;

	@FindBy(xpath = "//div[@id='fromNode']/div/div/div/input")
	WebElement tf_fromValue;

	@FindBy(xpath = "//div[@id='toNode']")
	WebElement dd_toValue;

	@FindBy(xpath = "//div[@id='toNode']/div/div/div/input")
	WebElement tf_toValue;

	@FindBy(xpath = "//button[text()='Calculate']")
	WebElement btn_calculate;

	@FindBy(xpath = "//button[text()='Clear']")
	WebElement btn_clear;

	@FindBy(xpath = "//p[text()='Result']/../div/p")
	private List<WebElement> ele_results;

	public SelectPathPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHeader() {
		return ele_SelectPath.isDisplayed();
	}

	public void selectFromNode(String node) {
		dd_fromValue.click();
		tf_fromValue.sendKeys(node + Keys.ENTER);

	}

	public void selectToNode(String node) {
		dd_toValue.click();
		tf_toValue.sendKeys(node + Keys.ENTER);
	}

	public void calculatePath() {
		btn_calculate.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clearPath() {
		btn_clear.click();
	}

	public List<String> getResults() {
		List<String> resultsList = new ArrayList<>();
		int length = ele_results.size();

		for (int i = 0; i < length; i++) {
			String result = ele_results.get(i).getText();
			resultsList.add(result);
		}
		return resultsList;
	}

	public void calaculateShortestPath() {

	}
}
