package scenario_Component;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import org.testng.log4testng.Logger;

import pageObject_Component.PageObject_Search;
import generic_Component.BaseClass;

public class Scenario_Search  extends BaseClass{
	
	static Logger log = Logger.getLogger(Scenario_Search.class);
	
	@Test (dataProvider = "dp_invalidSearch", dataProviderClass= dataprovider_Component.Dataprovider_Search.class,groups={"smoke"})
	
	public void test_InvalidSearch(String TC_ID, String Order, String Search_item, String Exp_Result) throws IOException {
		
		log.info("Executing invalid search");
		
		start_Server();
		init_App();
		
		PageObject_Search pos = new PageObject_Search();
		
		//explicit_Wait(pos.search_btn, 25);
		pos.click_searchbtn();
		
		//explicit_Wait(pos.search_txt, 10);
		pos.enter_serachitem(Search_item);
		
		//explicit_Wait(pos.noitem_msg, 10);
		String Actual_result = pos.get_noitem();
		
		if (Actual_result.equals(Exp_Result))
		{
			log.info("testcase pass"+ Actual_result +"expected result is " + Exp_Result);
		}
		else
		{
			log.info("test case failed" + Actual_result + "Expected result is " + Exp_Result);
			
		}
		
		stop_Server();	
		
		
	}
	



	public void valid_Search(String TC_ID, String Order, String Search_Item, String Exp_Result) throws IOException, InterruptedException
	{
		
		log.info("Executing valid search");
		
		start_Server();
		init_App();
		
		PageObject_Search pos = new PageObject_Search();
		Thread.sleep(1000);
		
		//explicit_Wait(pos.search_btn, 25);
		pos.click_searchbtn();
		
		//explicit_Wait(pos.search_txt, 10);
		pos.enter_serachitem(Search_Item);
		
		//explicit_Wait(pos.item_count, 10);
		String Actual_Result = pos.get_itemcount();
		
		if (Actual_Result.equals(Exp_Result))
		{
			log.info("pass"+ Actual_Result+ "Expected result is "+ Exp_Result);
		}
		else
		{
			log.info("fail" + Actual_Result + "Expected result is " + Exp_Result);
		}
		
		stop_Server();
		
		
	}
	
	

}
