package com.multi.rest.content.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.rest.content.model.vo.Cat;


public class MyRestApiParse {
	public static String MyURL = "http://localhost/animal/catWeb";
	
	
	public static void main(String[] args) {
		StringBuffer urlBuffer = new StringBuffer(MyURL);
//		urlBuffer.append("/1");
		System.out.println(urlBuffer);
		try {
			URL url = new URL(urlBuffer.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			int code = conn.getResponseCode();
			System.out.println("ResponseCode : " + code);
			
			if(code < 200 || code > 300) {
				System.out.println("페이지가 잘못되었습니다.");
				return;
			}
			
			InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject)jsonParser.parse(br);
			JSONArray catList = (JSONArray)jsonObj.get("list");
			
			List<Cat> list = new ArrayList<>();
			for (int i = 0; i < catList.size(); i++) {
				JSONObject cat = (JSONObject) catList.get(i);
				int id = Integer.parseInt(cat.get("id").toString());
				String name = cat.get("name").toString();
				String info = cat.get("info").toString();
				String eyeColor = cat.get("eyeColor").toString();
				String hairLength = cat.get("hairLength").toString();
				String features = cat.get("features").toString();
				String color = cat.get("color").toString();
				String weight = cat.get("weight").toString();
				Cat catObj = new Cat(id, name, info, eyeColor, hairLength, features, color, weight, null);
				list.add(catObj);
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
