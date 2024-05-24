package maps;

import java.util.HashMap;
import java.util.Map;

class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {

		if (ransomNote.length() > magazine.length())
			return false;

		int map[] = new int[26];

		for (Character c : magazine.toCharArray()) {
			map[c - 'a']++;
		}

		for (Character c : ransomNote.toCharArray()) {
			if (map[c - 'a'] == 0) // starting only it should not be 0
				return false;
			map[c - 'a']--;
		}

		return true;

//        if (ransomNote.length() > magazine.length()) return false;
//        Map<Character,Integer> rMap = new HashMap<>();
//        Map<Character,Integer> mMap = new HashMap<>();
//        for(Character c:ransomNote.toCharArray()){
//            rMap.put(c,rMap.getOrDefault(c,0)+1);
//        }
//        for(Character c:magazine.toCharArray()){
//            mMap.put(c,mMap.getOrDefault(c,0)+1);
//        }
//        for(Character c:rMap.keySet()){
//            if(mMap.get(c) == null)
//                return false;
//            if(rMap.get(c) > mMap.get(c))
//                return false;
//        }
//        return true;
	}
}