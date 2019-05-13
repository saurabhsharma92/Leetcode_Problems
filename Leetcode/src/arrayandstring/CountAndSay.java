package arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("output : " + countAndSay(4));
	}

	public static String countAndSay(int n) {
		List<String> l = new ArrayList<>();
		l.add("1");
		// l.add("11");
		for (int i = 1; i < n; i++) {
			char[] temp = l.get(i - 1).toCharArray();
			StringBuffer bf = new StringBuffer();
			System.out.println("----" + Arrays.toString(temp));
			int count = 0;
			int j = 0;
			while(j < temp.length) {
				if(j == 0) {
					count = 1;
				}else if(temp[j] == temp[j-1]) {
					count++;
				}else {
					count = 1;
				}
				if(temp[j] != temp[j+1] || j == temp.length - 1) {
					bf.append(count+""+temp[j]);
				}
				j++;
			}
			l.add(bf.toString());
		}
		System.out.println(l.toString());
		return l.get(n - 1);
	}
}



/*
 * if ((j != 0 && temp[j - 1] != temp[j]) || (j == temp.length-1)) {
 * bf.append(count + "" + temp[j]); }else{ bf.append(count + "" + temp[j]); }
 */