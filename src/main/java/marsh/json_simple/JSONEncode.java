package marsh.json_simple;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONEncode {

	public JSONEncode() {
		HashMap<Object, Object> jsonObject = new HashMap<Object, Object>();
		jsonObject.put("name", "Marshal");
		jsonObject.put("age", new Integer(30));
		jsonObject.put("address", "India");
		jsonObject.put("salary", new Double(1000));
		jsonEncode(jsonObject);

		String jsonString = "{\"name\":\"Marshal\",\"age\":30,\"address\":\"India\"}";
		jsonDecode(jsonString);
	}

	public void jsonEncode(HashMap<Object, Object> input) {
		System.out.println("Inside jsonEncode method.");
		try {
			JSONObject object = (JSONObject) new JSONParser().parse(JSONObject.toJSONString(input));
			System.out.println(object);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void jsonDecode(String jsonInput) {
		System.out.println("Inside jsonDecode method.");
		Object object = JSONValue.parse(jsonInput);
		JSONObject jsonObject = (JSONObject) object;
		String name = (String) jsonObject.get("name");
		System.out.println("Name: " + name);
	}

}