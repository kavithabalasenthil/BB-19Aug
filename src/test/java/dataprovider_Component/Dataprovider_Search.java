package dataprovider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import generic_Component.ExcelReadWrite;

public class Dataprovider_Search {
	@DataProvider(name="dp_invalidSearch")
	
	public static Iterator<String[]> invalid_SearchData() throws IOException
	{
	List<String[]> Invalid_SearchObj = flagRowCount("Invalid_Search");
		return Invalid_SearchObj.iterator();
	}
	
	public static Iterator<String[]> Valid_SearchData() throws IOException
	{
		List<String[]> Valid_SearchObj = flagRowCount("Valid_Search");
		return Valid_SearchObj.iterator();
		
	}
	
		
	
	//common method to read the test data where executable flag is "y"
	public static List<String[]> flagRowCount(String scriptname) throws IOException{
	
			ExcelReadWrite xl=new ExcelReadWrite("E:\\Kavitha Work\\BB_Framework\\TestData\\Test_Data.xls");
			
			HSSFSheet Scenario_Search = xl.Setsheet("Scenario_Search");
			int Rowcount = xl.getrowcount(Scenario_Search);
			
			List<String[]> list_Search = new ArrayList<String[]>();
			 
			
			for(int xlrow=1; xlrow<Rowcount; xlrow++)
			{
				
				String Execute_Flag = xl.Readvalue(Scenario_Search, xlrow, "Execute_Flag");
				String Script_name = xl.Readvalue(Scenario_Search, xlrow, "Script_name");
				
				
				if (Execute_Flag.equals("y") && Script_name.equals(scriptname))
				{
					
					String[] list_arr = new String[4];
					
					list_arr[0]= xl.Readvalue(Scenario_Search, xlrow, "TC_ID");
					list_arr[1]=xl.Readvalue(Scenario_Search, xlrow, "Order");
					list_arr[2]=xl.Readvalue(Scenario_Search, Rowcount, "Search_Item");
					list_arr[3]=xl.Readvalue(Scenario_Search, Rowcount, "Exp_Result");
					
					list_Search.add(list_arr);
				}// end of If condition
				
				
				
			} // end of for loop
			return   list_Search;
			
		
		
		
	}

}
