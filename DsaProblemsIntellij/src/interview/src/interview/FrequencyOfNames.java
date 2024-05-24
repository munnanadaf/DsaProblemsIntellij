package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOfNames {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("sachin");
		l.add("milind");
		l.add("jha");
		l.add("sachin");
		l.add("milind");

		frequency(l);

	}

	public static void frequency(List<String> nameList) {
		
		Map<String, Integer> freqMap = new HashMap<>();
		
		for (String name : nameList) {
			freqMap.put(name, freqMap.getOrDefault(name, 0) + 1);
		}

		for (java.util.Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

}
