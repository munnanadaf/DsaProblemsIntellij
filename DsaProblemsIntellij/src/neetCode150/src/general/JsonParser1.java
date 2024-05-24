package general;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser1 {
	public static void main(String[] args) {

		String s = "{ \r\n" + "  \"accounting\" : [   \r\n" + "                     { \"firstName\" : \"John\",  \r\n"
				+ "                       \"lastName\"  : \"Doe\",\r\n"
				+ "                       \"age\"       : 23 },\r\n" + "\r\n"
				+ "                     { \"firstName\" : \"Mary\",  \r\n"
				+ "                       \"lastName\"  : \"Smith\",\r\n"
				+ "                        \"age\"      : 32 }\r\n" + "                 ],                           "
				+ " \r\n" + "  \"sales\"      : [ \r\n" + "                     { \"firstName\" : \"Sally\", \r\n"
				+ "                       \"lastName\"  : \"Green\",\r\n"
				+ "                        \"age\"      : 27 },\r\n" + "\r\n"
				+ "                     { \"firstName\" : \"Jim\",   \r\n"
				+ "                       \"lastName\"  : \"Galley\",\r\n"
				+ "                       \"age\"       : 41 }\r\n" + "                 ] \r\n" + "} ";

		JSONParser parser = new JSONParser();

		Object obj;
		try {
			obj = parser.parse(s);
			JSONObject jsonObject = (JSONObject) obj;
			printJSON((JSONObject) jsonObject);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void printJSON(JSONObject jsonObj) {
		for (Object keyObj : jsonObj.keySet()) {
			String key = (String) keyObj;
			Object valObj = jsonObj.get(key);
			if (valObj instanceof JSONObject) {
				printJSON((JSONObject) valObj);
			} else {
				printJSON((JSONArray) valObj);
//				System.out.println("key : " + key);
//				System.out.println("value : " + valObj.toString());
			}
		}
	}

	public static void printJSON(JSONArray jsonArray) {
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jobj = (JSONObject) jsonArray.get(i);
			for (Object object : jobj.keySet()) {
				String key = (String) object;
				System.out.println(key + " : " + jobj.get(key));
			}
		}
	}
}