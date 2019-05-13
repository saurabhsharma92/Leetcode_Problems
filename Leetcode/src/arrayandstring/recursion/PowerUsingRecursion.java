package arrayandstring.recursion;

import java.util.HashMap;
import java.util.Map;

public class PowerUsingRecursion {

	/**
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(myPow(1.00001,123456,0));
		//System.out.println(myPow(2,12,0));
	}
	
	static Map<Integer, Double> powerMap = new HashMap<Integer,Double>();
	public static double myPow(double x, int n, double result) {
        if(n == 0){
           return 1; 
        }
        if(powerMap.containsKey(n)) {
        	return powerMap.get(n);
        }
        if(n<0){
            result = 1/x * myPow(x,n+1,result);
        }else if(n>0){
            result = x * myPow(x,n-1,result);
        }
        powerMap.put(n,result);
        return result;
    }
}
