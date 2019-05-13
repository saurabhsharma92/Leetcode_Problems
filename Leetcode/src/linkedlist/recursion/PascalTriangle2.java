package linkedlist.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

	/**
	 *return pascal traingle for given input
	 *				1
	 *			   1 1
	 *			  1 2 1
	 *			 1 3 3 1
	 *			1 4 6 4 1
	 *
	 *Given a pascal traingle and k
	 *return the row at k the index
	 */
	public static void main(String[] args) {
		PascalTriangle2 pt = new PascalTriangle2();
		pt.generate(3);
	}
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> val = null;
        for(int i = 0; i<= numRows; i++){
        	val = new ArrayList<Integer>();
            for(int j = 0; j<=i; j++){
            	if(j==0 || j==i) {
            		val.add(1);
            	}else {
            		List<Integer> f = result.get(i-1);
            		int fVal = f.get(j-1);
            		int sVal = f.get(j);
            		val.add(fVal+sVal);
            	}
            }
            result.add(val);
        }
        System.out.println(result.get(numRows));
        return result;
    }
    

}
