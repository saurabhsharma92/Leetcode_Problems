package arrayandstring;

public class DecodeString {
	/**
	 *A message containing letters from A-Z is being encoded to numbers using the following mapping:
		'A' -> 1
		'B' -> 2
		...
		'Z' -> 26
		Given a non-empty string containing only digits, determine the total number of ways to decode it.
		
		Example 1:		
		Input: "12"
		Output: 2
		Explanation: It could be decoded as "AB" (1 2) or "L" (12).
		Example 2:		
		Input: "226"
		Output: 3
		Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
	 */
	public static void main(String[] args) {
		String s = "110";
		System.out.println(numDecodings(s));
	}
	
	public static int numDecodings(String s) {
		char[] c = s.toCharArray();
		for(int i=1; i< c.length; i++) {
			if(Integer.parseInt(c[i]+"") > 0 && Integer.parseInt(c[i]+"") < 27) {
				
			}
		}
		return 0;
	}
	
	 /*public static int numDecodings(String s) {
	      char[] c = s.toCharArray();
	        int d[] = new int[c.length+1];
			if (c[0] == '0') {
				d[0] = 0;
				d[1] = 0;
			}else if (c.length > 1 && (c[0] == '1'||c[0] == '2') && (c[1] == '0'|| c[1] == '1')){
				d[0] = 0;
				d[1] = 1;
			}else {
				d[0] = 1;
				d[1] = 1;
			}
	        for(int i=1;i<c.length;i++) {
	        	if((Integer.parseInt(c[i]+"") + Integer.parseInt(c[i-1]+"")*10 > 0 &&
	        			Integer.parseInt(c[i]+"") + Integer.parseInt(c[i-1]+"")*10 <= 26) 
	        			)
	                d[i+1] = d[i]+d[i-1];
	            else if(Integer.parseInt(c[i]+"") <= 0)
	                return 0;
	            else
	                d[i+1] = d[i];
	        }
	        return d[c.length];
	    }*/
}
