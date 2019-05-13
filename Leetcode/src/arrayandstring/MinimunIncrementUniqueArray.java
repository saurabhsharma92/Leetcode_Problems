package arrayandstring;

import java.util.Arrays;

public class MinimunIncrementUniqueArray {
	
	/**
	 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
		Return the least number of moves to make every value in A unique.		
		Example 1:		
		Input: [1,2,2]
		Output: 1
		Explanation:  After 1 move, the array could be [1, 2, 3].
		Example 2:		
		Input: [3,2,1,2,1,7]
		Output: 6
		Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
		It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
	 */
	public static void main(String[] args) {
		int[] A = new int[]{3,2,1,2,1,7};
		//int[] A = new int[]{1,2,2};
		System.out.println(minIncrementForUnique(A));
	}
	public static int minIncrementForUnique(int[] A) {
		if(null == A || A.length < 2) return 0;
		Arrays.sort(A);
		int count = 0;
		int inc = 0;
		for(int i =1; i<A.length; i++) {
			if(A[i] <= A[i-1]) {
				inc = A[i-1] - A[i] + 1;
				count += inc;
				A[i] += inc;
			}
		}
		return count;
    }
}
