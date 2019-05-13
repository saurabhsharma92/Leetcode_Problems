package arrayandstring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LongestChain {
	public int findLongestChain(String[] words) {
		if (words == null || words.length == 0)
			return 0;
		int chainLength = 0;
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		for (String w : words) {
			if (wordMap.containsKey(w))
				continue;
			wordMap.put(w, 1);
			for (int i = 0; i < w.length(); i++) {
				StringBuilder sb = new StringBuilder(w);
				sb.deleteCharAt(i);
				String temp = sb.toString();
				if (wordMap.containsKey(temp) && wordMap.get(temp) + 1 > wordMap.get(w)) {
					wordMap.put(w, wordMap.get(temp) + 1);
				}
			}
			if (wordMap.get(w) > chainLength)
				chainLength = wordMap.get(w);
		}
		return chainLength;
	}

	public static void main(String[] args) {
		LongestChain sol = new LongestChain();
		 String[] words = new String[]{"6", "a", "b", "ba", "bca", "bda", "bdca"};
		// String[] words = new String[]{"a", "a", "bc", "exf", "abc"};
		//String[] words = new String[] { "bc", "abc" };
		int longestChain = sol.findLongestChain(words);
		System.out.println(longestChain);
	}
}
