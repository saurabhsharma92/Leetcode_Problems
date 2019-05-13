package arrayandstring;

/**
	Count the number of prime numbers less than a non-negative number, n.
	Example:
	Input: 10
	Output: 4
	Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7. 
 */
public class CountPrimes {

	public static void main(String[] args) {
		System.out.println(countPrime(5));
	}

	private static int countPrime(int n) {
		boolean[] res = new boolean[n];
		int count = 0;
		for(int i=2; i<n; i++) {
			if(res[i] == false) {
				count++;
				for(int j=2; j*i<n; j++) {
					res[i*j] = true;
				}
			}
		}
		return count;
	}

}
