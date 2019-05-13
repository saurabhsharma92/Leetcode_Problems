package arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
	
	public static List<String> letterCombinations(String digits) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r","s"));
        map.put(8, Arrays.asList("v", "t", "u"));
        map.put(9, Arrays.asList("y", "w", "x","z"));

        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        return divide(digits, 0,digits.length()-1, map);
        
    }

    
    private static List<String> divide(String digits, int lo, int hi, HashMap<Integer, List<String>> map) {
        int mid = lo+(hi-lo)/2;
        if(lo>=hi) {
            return map.get(digits.charAt(lo)-'0');
        }
        List<String> c1 = divide(digits, lo, mid, map);
        List<String> c2 = divide(digits, mid+1, hi, map);
        
        List<String> newList = new ArrayList<>();
        for(int j=0; j<c1.size();j++) {
            for(int k=0;k<c2.size();k++) {
                newList.add(c1.get(j)+c2.get(k));
            }
        }
        
        return newList;
    }

}
