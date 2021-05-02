package com.citi.service.implementation;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NSEDataServiceImpl {
	public static String NSEData() {
		try {
			URL urlN = new URL("https://www.nseindia.com/api/equity-stockIndices?index=NIFTY%2050");
			
			HttpURLConnection connection = (HttpURLConnection) urlN.openConnection();
			connection.setRequestMethod("POST");
			connection.connect();
			
			int responseCode = connection.getResponseCode();
			System.out.println("Hello");
			System.out.println(responseCode);
			
			if(responseCode != 200) {
				throw new RuntimeException("HttpResponseCode : "+ responseCode);
			}
			else {
				String inline = "";
				String requiredAttributes = "[";
				Scanner sc = new Scanner(urlN.openStream());
				
				while(sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				
				
				JSONParser parser = new JSONParser();
				JSONObject stockN;
				
				try {
					JSONArray jsonArrayN = (JSONArray) parser.parse(inline);
					
					for(Object ob : jsonArrayN) {
						stockN = (JSONObject) ob;
						requiredAttributes += "{";
						requiredAttributes += "symbol : "+stockN.get("symbol")+", previousClose : "+ stockN.get("previousClose");
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





