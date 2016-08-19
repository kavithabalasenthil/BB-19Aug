package pageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class PageObject_Search {
	
	AndroidDriver driver;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/action_search")
	public WebElement search_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtAddress")
	public WebElement search_txt;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement noitem_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement item_count;
	
	
	
	public PageObject_Search()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void click_searchbtn()
	{
		search_btn.click();
	}
	
	public void enter_serachitem(String searchValue)
	{
		search_txt.sendKeys(searchValue);
	}
	
	public String get_noitem()
	{
		return noitem_msg.getText();
	}
	
	public String get_itemcount()
	{
		return item_count.getText();
	}

}
