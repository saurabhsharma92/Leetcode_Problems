package arrayandstring;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sum3Indices {

	public static void main(String[] args) {
		int[] in = new int[] {-1,0,1,2,-1,-4};
		//int[] in = new int[] {-1,0,1,0};
		//int[] in = new int[] {0,0,0,0};
		//int[] in = new int[] {1,2,-2,-1};
		//int[] in = new int[] {-1,0,1,-1};
		System.out.println(new Sum3Indices().threeSum(in));
	}
	
	//faster way - 43 ms
	//The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
	//For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. 
	//Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
	public List<List<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
	
	//shitty way to do it - 6.3sec
	/*public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean isZeros = true;
		int count = 0;
		while(count < nums.length) {
			if(nums[count] != 0)
				isZeros = false;
			count++;
		}
		if (isZeros && nums.length > 3) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(0);
			l.add(0);
			l.add(0);
			result.add(l);
			return result;
		}
		Arrays.sort(nums);
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length;j++) {
				for(int k = j+1; k<nums.length ; k++) {
					List<Integer> temp = null;
					if(nums[i] + nums[j] + nums[k] == 0) {
						temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
					}
					if(null != temp && !result.contains(temp)) {
						result.add(temp);
					}
				}
			}
			
		}
		return result;
	}*/
}
