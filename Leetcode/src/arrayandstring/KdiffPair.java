package arrayandstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KdiffPair {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5} ;
		int k = -1;
		System.out.println(findPairs(nums,k));
	}
	public static int findPairs(int[] nums, int k) {
        k = Math.abs(k);
        Map<Integer,String> l = new HashMap<Integer,String>();
        List<Integer> d = new ArrayList<Integer>();
        for(int j : nums){
            d.add(j);
        }
        
        for(int i=0; i< nums.length; i++){
            if(!l.containsKey(nums[i]) && d.contains(nums[i]-k) && d.indexOf(nums[i]) != d.lastIndexOf(nums[i]-k)){
                l.put(nums[i],"("+nums[i]+","+(nums[i]-k)+")");
                System.out.println(nums[i]);
            }
            Integer val = nums[i];
            d.remove(val);
        }
        return l.keySet().size();
    }
}
