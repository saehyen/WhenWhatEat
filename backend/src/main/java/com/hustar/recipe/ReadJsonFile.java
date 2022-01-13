package com.hustar.recipe;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;

public class ReadJsonFile {
	public static void main(String[] args) throws IOException, ParseException {
		
		Reader reader = new FileReader("./recipe.json");

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reader);
		
		JSONArray jsonArr = (JSONArray) obj;
		
		if(jsonArr.size() > 0) {
			for(int i = 0; i < jsonArr.size(); i++) {
				JSONObject jsonObj = (JSONObject)jsonArr.get(i);
				Object infoObj = (Object)jsonObj.get("info");
				JSONObject infoObject = (JSONObject) infoObj;
				System.out.println(infoObject.get("info1"));
				
//				System.out.println((Object)jsonObj.get("info"));
			}
		}
		
	}
}