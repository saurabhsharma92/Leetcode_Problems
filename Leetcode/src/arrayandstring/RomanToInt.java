package arrayandstring;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public static void main(String[] args) {
		System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
	}

	public int romanToInt(String s) {
        char[] c = s.toCharArray();
        Map<Character,Integer> romanToInt = new HashMap<Character,Integer>();
        romanToInt.put('I',1);
        romanToInt.put('V',5);
        romanToInt.put('X',10);
        romanToInt.put('L',50);
        romanToInt.put('C',100);
        romanToInt.put('D',500);
        romanToInt.put('M',1000);
        int sum = 0;
        char prev = 0;
        for(int i=0; i < c.length; i++){
            sum += romanToInt.get(c[i]);
            if(c[i-1] == 'I' && ( c[i]=='V' || c[i]=='X' )){
                sum -= 2;
            }else if(prev=='X' && (c[i]=='L' || c[i]=='C')){
                sum -= 20;
            }else if(prev=='C' && (c[i]=='D' || c[i]=='M')){
                sum -= 200;
            }
            prev = c[i];
        }
        
        return sum;
    }
}
