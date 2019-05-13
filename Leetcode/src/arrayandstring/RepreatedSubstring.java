package arrayandstring;

public class RepreatedSubstring {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abaababaab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        if(s.length() == 1) return false;
        int start = 0;
        int end = 0;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(start) == s.charAt(i)){
                end = i;
                int len = (end - start) + start;
                while(start < len &&
                        end < s.length() &&
                        s.charAt(start) == s.charAt(end)){
                    start++;
                    end++;
                }
                if(end == s.length() && start == len){
                    return true;
                }
                if(end < s.length()){
                    i = end-1;
                }
                if(len != start){
                    start = 0;
                }
            }
        }
        return false;
    }
}
