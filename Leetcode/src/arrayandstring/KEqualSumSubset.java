package arrayandstring;

import java.util.HashMap;
import java.util.Map;

public class KEqualSumSubset {

	public static void main(String[] args) {
		int [] nums = {4, 3, 2, 3, 5, 2, 1};
		int k = 4;
		System.out.println(canPartitionKSubsets(nums, k));
	}
	
	public static boolean canPartitionKSubsets(int[] nums, int k) {
        int avg = 0;
        for(int i: nums){
            avg += i;
        }
        avg = avg / k;
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        int j = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == avg){
                count++;
                continue;
            }
            System.out.println("nums[i] : "+nums[i]+" i : "+i+" j : "+j); //+" map.get(nums[i]) : "+map.get(nums[i]));
            if(!map.containsKey(nums[i])){
                map.put(avg-nums[i]+"-"+i, i);
            }else{
                if(nums[i] + nums[map.get(nums[i]+"-"+i)] == avg){
                    count++;
                }
            }
            System.out.println(map.toString());
            j++;
        }
        return count == k;
    }
}
