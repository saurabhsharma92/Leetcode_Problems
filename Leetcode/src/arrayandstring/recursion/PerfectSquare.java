package arrayandstring.recursion;
/**
 *	Given a positive integer num, write a function which returns True if num is a perfect square else False.

	Note: Do not use any built-in library function such as sqrt.
	
	Example 1:
	
	Input: 16
	Output: true
	Example 2:
	
	Input: 14
	Output: false
 */
public class PerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(16));

	}

	public static boolean isPerfectSquare(int num) {
		int i = 1;
		int j = num;
		// Map<Integer, Integer> sqMap = new HashMap<>();
		while (i <= j) {
			long mid = (i + j) / 2;
			long sq = mid * mid;
			// if(!sqMap.containsKey(mid)){
			// sqMap.put(mid, (mid*mid));
			// }
			if (sq == num) {
				return true;
			}
			if (sq < num) {
				i = (int) mid + 1;
			} else {
				j = (int) mid - 1;
			}
		}
		return false;
	}

}
