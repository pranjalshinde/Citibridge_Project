package com.citi.service.implementation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class BSEDataServiceImpl {
	
	public static String BSEData() {
		try {
			URL urlB = new URL("https://api.bseindia.com/BseIndiaAPI/api/GetStkCurrMain/w?flag=Equity&ddlVal1=Index&ddlVal2=S%26P%20BSE%20SENSEX&m=0&pgN=1");
//			URL urlB = new URL("https://www.nseindia.com/api/equity-stockIndices?index=NIFTY%2050");
			HttpURLConnection connection = (HttpURLConnection) urlB.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			int responseCode = connection.getResponseCode();
			
			System.out.println(responseCode);
			
			if(responseCode != 200) {
				throw new RuntimeException("HttpResponseCode : "+ responseCode);
			}
			else {
				String inline = "";
				String requiredAttributes = "[";
				Scanner sc = new Scanner(urlB.openStream());
				
				while(sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				
				
				JSONParser parser = new JSONParser();
				JSONObject stockB;
				
				try {
					JSONArray jsonArrayB = (JSONArray) parser.parse(inline);
					
					for(Object ob : jsonArrayB) {
						stockB = (JSONObject) ob;
						requiredAttributes += "{";
						requiredAttributes += "ScripName : "+stockB.get("ScripName")+", Price : "+ stockB.get("Price");
						requiredAttributes += "},";
						
					}
					requiredAttributes= requiredAttributes.substring(0, requiredAttributes.length()-1);
					requiredAttributes+="]";
					System.out.println(requiredAttributes);
					return requiredAttributes;
				}catch (ParseException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				return "";				
			}
			
		}
		catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
		
	}
	
		
}
