package arrayandstring;

import java.util.Arrays;
import java.util.Comparator;

/**
	Given a list of non negative integers, arrange them such that they form the largest number.
	Example 1:
	Input: [10,2]
	Output: "210"
	Example 2:
	Input: [3,30,34,5,9]
	Output: "9534330"
	Note: The result may be very large, so you need to return a string instead of an integer. *
 */

public class LargestPossibleNumber {

	public static void main(String[] args) {
		//int[] nums = {1,4,7,2,5,8,0,3,6,9};
		//int[] nums = {0,9,8,7,6,5,4,3,2,1};
		int[] nums = {3,30,34,5,9};
		System.out.println(largestNumber(nums));
	}
	
	private static String largestNumber(int[] nums) {
		if(nums.length == 0 || nums == null ) return "";
		String[] str = new String[nums.length];
		for(int i=0; i<nums.length; i++) {
			str[i] = String.valueOf(nums[i]);
		}
		
		Comparator<String> comp = new Comparator<String>() {
			public int compare(String s1, String s2) {
				String str1 = s1+s2;
				String str2 = s2+s1;
				return str2.compareTo(str1);
			}
		};
		Arrays.sort(str, comp);
		if(str[0].charAt(0) == '0') return "0";
		StringBuilder sb = new StringBuilder();
		for(String s: str) {
			sb.append(s);
		}
		return sb.toString();
	}
}
