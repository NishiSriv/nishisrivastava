package StepDefination;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import TestProject.Tokopedia.BaseClass;
import TestProject.Tokopedia.ControllerClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SwagDef {


	@Before
	public void setUp() {
		BaseClass.getInstance().initializeDriver("Chrome");

	}


	@Given(": Launch the URL")
	public void lunchURL(DataTable dt) {
		List<List<String>> li= dt.asLists();
		Assert.assertTrue(ControllerClass.getInstance().swagPage().launchURL(li.get(0).get(0)),"Unabl to launch the URL");

	}

	@Then(": Enter the credentials username and password")
	public void enterCredentials(DataTable dt) {

		List<List<String>> li= dt.asLists();
		Assert.assertTrue(ControllerClass.getInstance().swagPage().enterUserName(li.get(0).get(0)),"Unable to enter the username");
		Assert.assertTrue(ControllerClass.getInstance().swagPage().enetrPassword(li.get(0).get(1)),"Unable to enter the password");
		Assert.assertTrue(ControllerClass.getInstance().swagPage().click(),"Unable to login");
	}
	
	
	@And(": Verify that user loggedinSuccessfully")
	public void verifyLogin(DataTable dt) {
		List<List<String>> li= dt.asLists();
		Assert.assertTrue(ControllerClass.getInstance().swagPage().click(),"Unable to login");
		Assert.assertTrue(ControllerClass.getInstance().swagPage().verifyTitleOfPage(),"Page Title is not verified");

	}

	@Then(": Sort the Product with the highest price")
	public void sortTheProductandVerifyTheSame() {
		Assert.assertTrue(ControllerClass.getInstance().swagPage().sortProduct("hilo"),"Unable to sort the product");
		Assert.assertTrue(ControllerClass.getInstance().swagPage().verifySortProductFromHiToLo(),"Unable to sort correctly");
	}
	
	
	
	@Then(": Select the first Product and Verify its detail")
	public void selectProductAndVerifyItsDetail() {

		Map<String ,String> mp=ControllerClass.getInstance().swagPage().selectProductandVerifyDetails();
	}
	
	
	@Then(": Select the product and checkout the order")
	public void selectAndCheckout() {
		Assert.assertTrue(ControllerClass.getInstance().swagPage().buyProduct(),"Unable toBuy the Product");
		Assert.assertTrue(ControllerClass.getInstance().swagPage().checkoutProduct(),"Unable to Chekout the Product");


	}
	
	
	@Then(": Enter detail for checkOut")
	public void enterDetails(DataTable dt) {
		List<List<String>> li=dt.asLists();
		for(List<String> l:li) {
			Assert.assertTrue(ControllerClass.getInstance().swagPage().enterDetail(l),"Unable toBuy the Product");
		}

	}
	@Then(": verify Order is Placed")
	public void verifyOrderIsPlaced(DataTable dt) {
		List<List<String>> li=dt.asLists();
		Assert.assertEquals(ControllerClass.getInstance().swagPage().verifyOrderPlaced(),li.get(0).get(0) ,"Under Status didnot shown up correctly");
	}


	
	@After
	public void quitdriver() {
		BaseClass.getInstance().getDriver().quit();
		
		
	}

}

//}
