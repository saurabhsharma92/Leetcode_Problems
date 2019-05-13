package arrayandstring;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationOfArray {

	public static void main(String[] args) {
		combinations(new int[] {1,2,2,2}, 3);
	}
	/*public static void combinations(int n, int[] arr, List<int[]> list) {
	    // Calculate the number of arrays we should create
	    int numArrays = (int)Math.pow(arr.length, n);
	    // Create each array
	    for(int i = 0; i < numArrays; i++) {
	        list.add(new int[n]);
	    }
	    // Fill up the arrays
	    for(int j = 0; j < n; j++) {
	        // This is the period with which this position changes, i.e.
	        // a period of 5 means the value changes every 5th array
	        int period = (int) Math.pow(arr.length, n - j - 1);
	        for(int i = 0; i < numArrays; i++) {
	            int[] current = list.get(i);
	            // Get the correct item and set it
	            int index = i / period % arr.length;
	            current[j] = arr[index];
	        }
	    }
	}*/
	
	public static void combinations(int[] input, int k) {
		List<int[]> subsets = new ArrayList<>();
	
		int[] s = new int[k];                  // here we'll keep indices 
		                                       // pointing to elements in input array
	
		if (k <= input.length) {
		    // first index sequence: 0, 1, 2, ...
		    for (int i = 0; (s[i] = i) < k - 1; i++);  
		    subsets.add(getSubset(input, s));
		    for(;;) {
		        int i;
		        // find position of item that can be incremented
		        for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--); 
		        if (i < 0) {
		            break;
		        }
		        s[i]++;                    // increment this item
		        for (++i; i < k; i++) {    // fill up remaining items
		            s[i] = s[i - 1] + 1; 
		        }
		        subsets.add(getSubset(input, s));
		    }
		}
		
		for(int[] t : subsets) {
			System.out.println(Arrays.toString(t));
		}
	}
	// generate actual subset by index sequence
	static int[] getSubset(int[] input, int[] subset) {
	    int[] result = new int[subset.length]; 
	    for (int i = 0; i < subset.length; i++) 
	        result[i] = input[subset[i]];
	    return result;
	}
}
