package arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestCommonPrefix(new String[]{"aa","a"}));

	}
	public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int fLen = strs[0].length();
        if(fLen == 0) return "";
        //System.out.println(strs.length);
        List<char[]> l = new ArrayList<char[]>();
        for(String s : strs){
            l.add(s.toCharArray());
        }
        String match = "";
        char temp;
        boolean ret = false;
        for(int i=0; i<fLen; i++){
            temp = l.get(0)[i];
            for(int j = 1; j<l.size(); j++){
                System.out.println(j+"....... "+Arrays.toString(l.get(j)));
                if(l.get(j).length == 0 || i >= l.get(j).length){
                    ret = true;
                    break;
                }else if(null != l.get(j)  && temp != l.get(j)[i]){
                    ret = true;
                    break;
                }
            }
            if(ret){
                break;
            }else{
                match = match + temp;
            }
        }
        return match;
    }
}
