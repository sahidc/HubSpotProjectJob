package com.qa.HubSpot.Util;

import java.util.ArrayList;

import com.qa.HubSpot.Utility.Xls_Reader;

public class TestUtil1 {
	
		public static Xls_Reader r;
		public static ArrayList<Object[]> getDataFromExcel(){
		ArrayList<Object[]> data= new ArrayList<Object[]>();
		try {
			r=new Xls_Reader("C:\\Users\\Mashuda\\eclipse-workspace\\SeleniumProject\\HubSpotPOM\\src\\main\\java\\com\\qa\\HubSpot\\TestData\\POMHUBSPOT.xlsx");
			
		}
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
		for(int rn=2; rn<=r.getRowCount("Sheet1");rn++) {
			String uesrid=r.getCellData("Sheet1", "uesrid", rn);
			String FirstName=r.getCellData("Sheet1", "FirstName", rn);
			String LastName=r.getCellData("Sheet1", "LastName", rn);
			String JobTitle=r.getCellData("Sheet1", "JobTitle", rn);
			String PhoneNumber=r.getCellData("Sheet1", "PhoneNumber", rn);
			
			Object ob[]= {uesrid,FirstName,LastName,JobTitle,PhoneNumber};
			data.add(ob);
			
		}
		return data;
	}
		
		public static ArrayList<Object[]> getDataFromExcelSheet2(){
			ArrayList<Object[]> data1= new ArrayList<Object[]>();
			try {
				r=new Xls_Reader("C:\\Users\\Mashuda\\eclipse-workspace\\SeleniumProject\\HubSpotPOM\\src\\main\\java\\com\\qa\\HubSpot\\TestData\\POMHUBSPOT.xlsx");
				
			}
		    catch(Exception e) {
		    	e.printStackTrace();
		    }
			for(int rn=2; rn<=r.getRowCount("Sheet2");rn++) {
				String DealName=r.getCellData("Sheet2", "DealName", rn);
				String Deal_Amount=r.getCellData("Sheet2", "Deal_Amount", rn);
				Object ob[]= {DealName,Deal_Amount};
				data1.add(ob);
				
			}
			return data1;
		}
	}


