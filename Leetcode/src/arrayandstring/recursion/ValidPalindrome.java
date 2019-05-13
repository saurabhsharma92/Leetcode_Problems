package arrayandstring.recursion;

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	public static boolean isPalindrome(String s) {
        return helper(s.toLowerCase(),0,s.length()-1);
    }
    
    private static boolean helper(String s, int start, int end){
    	if(start >= end){
            return true;
        }
        boolean isValidSC = String.valueOf(s.charAt(start)).matches("[a-zA-Z0-9]") ? true : false;
        boolean isValidEC = String.valueOf(s.charAt(end)).matches("[a-zA-Z0-9]") ? true : false;
        if(!isValidSC) start++;
        if(!isValidEC) end++;
        System.out.println("start : <"+s.charAt(start)+"> end : <"+s.charAt(end)+">");
        //System.out.println("isValidSC : "+isValidSC+" isValidEC : "+isValidEC);
        if(s.charAt(start) != s.charAt(end) && isValidSC && isValidEC){
            System.out.println("start : "+start+" ch: <"+s.charAt(start)+"> end : "+end+" ch : <"+s.charAt(end)+">");
            return false;
        }
        //System.out.println("start : "+start+" end : "+end);
        return helper(s, start+1, end-1);
    }
}
