package com.gandhi.test.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuOptList {
	/*
	 * This is a class to store all the menu options required in different forms
	 * 
	 * Use data structure to build this option
	 * 1. List
	 * 2. Array List
	 * 3. Map
	 * 4. HashMap
	 * 5. 
	 * 6.
	 * 7.
	 * 8.
	 * 
	 * */

	List<String> tranOptList;
	List<String> cardBrandList;
	List<Integer> cardOptList;
	List<String> hostList;
	HashMap<String, String> hostList1;
	
	public List<String> gettranOptList(){
		tranOptList = new ArrayList<String>();
		tranOptList.add("01");
		tranOptList.add("02");
		tranOptList.add("03");
		tranOptList.add("04");
		tranOptList.add("05");
		tranOptList.add("06");
		tranOptList.add("07");
		tranOptList.add("08");
		tranOptList.add("09");
		tranOptList.add("10");
		tranOptList.add("11");
		return tranOptList;
	}
	
	public List<String> getcardBrandList(){
		cardBrandList = new ArrayList<String>();
		cardBrandList.add("RBS");
		cardBrandList.add("NWB");
		cardBrandList.add("UBN");
		cardBrandList.add("UBR");
		return cardBrandList;
	}
	
	public List<Integer> getcardOptList(){
		cardOptList = new ArrayList<Integer>();
		cardOptList.add(1);
		cardOptList.add(2);
		cardOptList.add(3);
		cardOptList.add(4);
		return cardOptList; 
	}
	
	public List<String> gethostList(){
		hostList = new ArrayList<String>();
		hostList.add("QPLEX");
		hostList.add("MPLEX");
		hostList.add("PPLEX");
		hostList.add("zVM");
		return hostList;
	}
	
	public HashMap<String, String> gethostList1(){
		hostList1 = new HashMap<String, String>();
		hostList1.put("QPLEX", "11.138.64.52");
		hostList1.put("MPLEX", "11.138.64.52");
		hostList1.put("PPLEX", "11.138.64.52");
		hostList1.put("zVM", "11.138.64.52");
		return hostList1;
	}
	
}
