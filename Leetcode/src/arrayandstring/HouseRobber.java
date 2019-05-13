package arrayandstring;

public class HouseRobber {

	public static void main(String[] args) {
		int [] nums = new int[] {2,1,1,3};
		System.out.println(nums.length-1);
		System.out.println(nums);
		int val = rob(nums, nums.length -1);
		System.out.println(val);
	}
	
	private static int rob(int[] nums, int i) {
	    if (i < 0) {
	        return 0;
	    }
	    int val = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	    return val;
	}
	    
}
