package arrayandstring;

public class PermutationOfArray {

	public static void main(String[] args) {
		permute(java.util.Arrays.asList(2,3,6,7), 0);
	}
	
	static void permute(java.util.List<Integer> arr, int k){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            System.out.println(java.util.Arrays.toString(arr.toArray()));
        }
    }
}
