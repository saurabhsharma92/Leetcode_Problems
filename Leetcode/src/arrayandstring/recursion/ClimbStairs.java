package arrayandstring.recursion;

public class ClimbStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(2));
	}
	 public static int climbStairs(int n) {
	        if(n == 1){
	            return 1;
	        }
	        int[] arr = new int[n+1];
	        arr[1] = 1;
	        arr[2] = 2;
	        for(int i=3; i<n+1; i++){
	            arr[3] = arr[i-1]+arr[i-2];
	        }
	        return arr[n];        
	    }
}
