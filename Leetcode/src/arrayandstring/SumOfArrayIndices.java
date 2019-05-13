package arrayandstring;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumOfArrayIndices {

	public static void main(String[] args) {
		int arr [] = {2, 7, 11, 15};
		int arr1[] = {3,2,4};
		int arr2[] = {3,3};
		int arr3[] = {0,0,3,4};
		int arr4[] = {2,3,4};
		int target = 9;
		int target1, target2, target4 = 6;
		int target3 = 0;
		System.out.println(Arrays.toString(new SumOfArrayIndices().twoSum(arr4,target4)));
	}
	
	/*public int[] twoSum(int[] nums, int target) {
        List<Integer> l = new ArrayList<Integer>();
        
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i ; j < nums.length ; j++){
                if((nums[i] + nums[j]) == target && i != j){
                    l.add(i);
                    l.add(j);
                }
                //break;
            }
        }
        int res[] = new int[l.size()] ;
        for(int i = 0; i< l.size(); i++) {
        	res[i] = l.get(i);
        }
        return res;
    }*/

	
	public int[] twoSum(int[] nums, int target) {
	   //List<int[]> l = Arrays.asList(nums);
		List<Integer> l = new ArrayList<Integer>();
		for(int n : nums) {
			l.add(n);
		}
	   System.out.println(Arrays.toString(l.toArray()));
	   List<Integer> res = new ArrayList<Integer>();
       for(int i = 0; i< nums.length ; i++) {
    	   if(l.contains(target - nums[i])) {
    		   res.add(i);
    	   }
       }
       System.out.println(res);
       int output[] = new int[res.size()] ;
       for(int i = 0; i< res.size(); i++) {
    	   output[i] = res.get(i);
       }
	return output;
    }

}
