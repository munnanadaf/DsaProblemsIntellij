//package general;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.*;
//
//public class JsonParser {
//	public static void main(String[] args) {
//		String s = "{ \r\n"
//				+ "  \"accounting\" : [   \r\n"
//				+ "                     { \"firstName\" : \"John\",  \r\n"
//				+ "                       \"lastName\"  : \"Doe\",\r\n"
//				+ "                       \"age\"       : 23 },\r\n"
//				+ "\r\n"
//				+ "                     { \"firstName\" : \"Mary\",  \r\n"
//				+ "                       \"lastName\"  : \"Smith\",\r\n"
//				+ "                        \"age\"      : 32 }\r\n"
//				+ "                 ],                            \r\n"
//				+ "  \"sales\"      : [ \r\n"
//				+ "                     { \"firstName\" : \"Sally\", \r\n"
//				+ "                       \"lastName\"  : \"Green\",\r\n"
//				+ "                        \"age\"      : 27 },\r\n"
//				+ "\r\n"
//				+ "                     { \"firstName\" : \"Jim\",   \r\n"
//				+ "                       \"lastName\"  : \"Galley\",\r\n"
//				+ "                       \"age\"       : 41 }\r\n"
//				+ "                 ] \r\n"
//				+ "} ";
//		parseJson(s);
//	}
//	
//	public static void parseJson(String s) {
//		JSONObject jo = new JSONObject();
//		try {
//			Object obj = new JSONParser().parse(s);
//			JSONObject jobj = (JSONObject) obj;
//			for (iterable_type iterable_element : jobj) {
//				
//			}
//			System.out.println(obj.getClass()+" class");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		System.out.println(s);
//	}
//
//}
