package PageClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestProject.Tokopedia.BaseClass;

public class SwagLabsPage {

	WebDriver driver;
	WebDriverWait wait;

	public SwagLabsPage(WebDriver driver) {
		this.driver = driver;

	}

	// WebDriver driver;

//	driver=BaseClass.getInstance().getDriver();

	@FindBy(id = "user-name")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement passWord;

	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='app_logo']")
	private WebElement swagLabHeader;
	
	@FindBy(xpath = "//select[@class='@FindBy(xpath = ']")
	private WebElement filterTab;
	
	
	@FindBy(xpath = "//select[@class='@FindBy(xpath = ']/option")
	private WebElement filterTabOption;
	
	
	@FindBy(xpath = "//*[@class='inventory_item_price']")
	private WebElement generalPriceTag;
	
	
	@FindBy(xpath="//*[@class='inventory_item_img'][1]")
	private WebElement productSegment_1;
	
	@FindBy(xpath="//button[contains(@id,'add-to-cart')]")
	private WebElement button_AddToCart;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cartbag;
	
	
	@FindBy(xpath="//*[@id='checkout']")
	private WebElement checkoutBtn;
	
	
	
	@FindBy(id="first-name")
	private WebElement firstName_Checkout;
	
	@FindBy(id="last-name")
	private WebElement lastName_Checkout;
	
	
	@FindBy(id="postal-code")
	private WebElement pincode_Checkout;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueBTN;
	
	
	@FindBy(id="finish")
	private WebElement finishBTN;
	
	
	@FindBy(xpath="//h2[@class='complete-header']")
	private WebElement thankyouHeader;
	

	public void waitForVisibilityMethod(WebElement element) {

		try {
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean launchURL(String url) {
		boolean state= false;
		try {
			driver.get(url);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;

	}

	public boolean enterUserName(String user) {
		boolean state= false;
		try {
			waitForVisibilityMethod(userName);
			userName.sendKeys(user);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public boolean enetrPassword(String Pass) {
		boolean state= false;
		try {
			waitForVisibilityMethod(passWord);
			passWord.sendKeys(Pass);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public boolean click() {
		boolean state= false;
		try {
			waitForVisibilityMethod(loginButton);
			loginButton.click();
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	
	
	public boolean verifyTitleOfPage() {
		boolean state= false;
		try {
			waitForVisibilityMethod(swagLabHeader);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public boolean sortProduct(String type) {
		boolean state= false;
		try {
			waitForVisibilityMethod(filterTab);
			filterTab.click();
			Select sel= new Select(filterTabOption);
			sel.selectByValue(type);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	
	public boolean verifySortProductFromHiToLo() {
		boolean state= false;
		try {
			List<String > l= new ArrayList<String>();
			
			List<WebElement> li= driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
			for(WebElement e:li) {
				l.add(e.getText());
			}
			List<String > l1=l;
			Collections.sort(l);
			if(l1.get(0).equals(l.get(l.size()-1)))
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}


	public Map<String ,String> selectProductandVerifyDetails() {
		Map<String ,String> mp= new HashMap<>();
		try {
			waitForVisibilityMethod(productSegment_1);
			productSegment_1.click();
			String name= driver.findElement(By.xpath("//*[@class='inventory_details_name large_size']")).getText();
			String price=driver.findElement(By.xpath("//*[@class='inventory_details_price']")).getText();
			mp.put(name, price);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mp;
	} 
	
	
	public boolean buyProduct() {
		boolean state= false;
		try {
			waitForVisibilityMethod(button_AddToCart);
			button_AddToCart.click();
			waitForVisibilityMethod(cartbag);
			cartbag.click();
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	
	
	
	public boolean checkoutProduct() {
		boolean state= false;
		try {
			waitForVisibilityMethod(checkoutBtn);
			checkoutBtn.click();
			
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	
	
	
	public boolean enterDetail(List<String> list) {
		boolean state= false;
		try {
			firstName_Checkout.sendKeys(list.get(0));
			lastName_Checkout.sendKeys(list.get(1));
			pincode_Checkout.sendKeys(list.get(2));
			waitForVisibilityMethod(continueBTN);
			continueBTN.click();
			waitForVisibilityMethod(finishBTN);
			finishBTN.click();
			
			
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public String verifyOrderPlaced() {
		String text="";
		try {
			
			waitForVisibilityMethod(thankyouHeader);
			text= thankyouHeader.getText();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}
	
}
