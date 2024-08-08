package com.dijkstra.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dijkstra.pages.DistanceCalculator;
import com.dijkstra.pages.RandomModePage;
import com.dijkstra.pages.SelectPathPage;
import com.dijkstra.utils.DataProviderUtil;

public class ShortestRouteCalculationTest extends BaseTest {

	@Test
	public void testRandomModeSelection() {
		RandomModePage randomModePage = new RandomModePage(driver);
		randomModePage.verifyLandingPageHeaders();
		randomModePage.clickOnToggleRandomMode();
		boolean value = randomModePage.isRefreshIconDisplayed();
		Assert.assertTrue(value);
	}

	@Test(dataProvider = "TestDataProvider", dataProviderClass = DataProviderUtil.class)
	public void testFromToNodeSelectionAndVerifyTheResults(String fromNode, String toNode) {
		SelectPathPage selectionPage = new SelectPathPage(driver);
		selectionPage.selectFromNode(fromNode);
		selectionPage.selectToNode(toNode);
		selectionPage.calculatePath();

		List<String> resultsList = selectionPage.getResults();
		System.out.println(resultsList);

		String pathLine = resultsList.get(0);
		String distanceLine = resultsList.get(1);

		String resultsText = pathLine.split(":")[1].split(",")[0].trim();
		DistanceCalculator dc = new DistanceCalculator();
		int distance = dc.processResultsList(resultsList);

		Assert.assertTrue(pathLine.contains(resultsText));
		Assert.assertTrue(distanceLine.contains("Total Distance: " + distance));
	}

	@Test(dataProvider = "TestDataProvider", dataProviderClass = DataProviderUtil.class)
	public void testClearSelection(String fromNode, String toNode) {
		SelectPathPage selectionPage = new SelectPathPage(driver);
		selectionPage.selectFromNode(fromNode);
		selectionPage.selectToNode(toNode);
		selectionPage.clearPath();
		List<String> resultsList = selectionPage.getResults();
		Assert.assertTrue(resultsList.isEmpty());
	}
}
