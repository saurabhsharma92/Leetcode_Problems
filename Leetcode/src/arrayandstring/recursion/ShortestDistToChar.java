package arrayandstring.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistToChar {

	public static void main(String[] args) {
		//String S = "loveleetcode";
		//String S = "eabeeede";
		String S = "aaab";
		char C = 'a';
		/*int[] chars = new int[S.length()];
		List<Integer> l = new ArrayList<Integer>();
		char[] ch = S.toCharArray();
		for(int i= 0; i<ch.length; i++) {
			if(ch[i] == C) {
				l.add(i);
			}
		}
		int min = 0;
		int max = 0;
		int temp = 0;
		for(int j=0;j<l.size();j++) {
			min = temp;
			if(j != ch.length && max == l.get(l.size()-2)) {
				max = ch.length;
			}else {
				max = l.get(j);
			}
			int i = j == 0 ? 0 : temp+1;
			for( ; i<max; i++) {
				if(ch[i] != C) {
					if(min == 0) {
						chars[i] = Math.abs(max-i);
					}else {
						chars[i] = Math.min(Math.abs(min-i), Math.abs(max-i));
					}
				}else {
					chars[i] = 0;
					break;
				}
			}
			temp = l.get(j);
			
		}*/
		
		     int[] a =new int[S.length()];
			
			for(int i=0;i<S.length();i++)
			{
				int index=S.indexOf(C,i);
				int last=S.lastIndexOf(C, i);
				if(last<0)
				{
					a[i]=Math.abs(i-index);
				}
				else if(index<0)
				{
					a[i]=Math.abs(i-last);
				}
				/*else if(Math.abs(i-index) <= Math.abs(i-last))
				{
					a[i]=Math.abs(i-index);
				}*/
				else
				{
					a[i]=Math.min(Math.abs(i-last),Math.abs(i-index));
				}
				
				
			} 
		       // return a;
		System.out.println(Arrays.toString(a));
	}
}
