package arrayandstring;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubstringWithoutRepChrs {

	public static void main(String[] args) {
		String input = "pwwkew";
		//System.out.println(getLength(input));
		System.out.println(lengthOfLongestSubstring(input));
	}

	private static int getLength(String input) {
		char[] str = input.toCharArray();
		List<Character> temp = new ArrayList<Character>();
		List<Character> charSet = new ArrayList<Character>();
		for (int i = 0; i < str.length;) {
			int j = i;
			while (j < str.length) {
				if (!temp.contains(str[j])) {
					temp.add(str[j]);
					j++;
				} else {
					break;
				}
			}
			if (temp.size() > charSet.size()) {
				charSet = new ArrayList<Character>();
				charSet.addAll(temp);
			}
			temp = new ArrayList<Character>();
			if (j < str.length) {
				i = Math.max(input.indexOf(str[j]) + 1, j);
			} else {
				break;
			}
		}
		return charSet.size();
	}

	public static int lengthOfLongestSubstring(String s) {
        int count=0;
        int k=-1;
        int max=0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // loop through string and check if char is present in set
        for(int i=0; i<s.length(); i++){
            // if not, increment count
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>k){
                k=map.get(s.charAt(i));
                count=i-k;
            } else {
                count+=1;
            }
            map.put(s.charAt(i), i);
            if(count>max){
                max=count;
            }
        }     
         return max;
    }
}
