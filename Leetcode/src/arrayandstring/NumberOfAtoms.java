package arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a chemical formula (given as a string), return the count of each atom.
	An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.	
	1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, 
	but H1O2 is impossible.	
	Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.	
	A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.	
	Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), 
	followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
	
	Example 1:
	Input: 
	formula = "H2O"
	Output: "H2O"
	Explanation: 
	The count of elements are {'H': 2, 'O': 1}.
	Example 2:
	Input: 
	formula = "Mg(OH)2"
	Output: "H2MgO2"
	Explanation: 
	The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
	Example 3:
	Input: 
	formula = "K4(ON(SO3)2)2"
	Output: "K4N2O14S4"
	Explanation: 
	The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 */
public class NumberOfAtoms {

	public static void main(String[] args) {
		//String str = "((HHe28Be26He)9)34";
		//String str = "(H12H8Li20B4)47";
		//String str = "(NB3)33";
		//String str = "(B2O39He17BeBe49)39";
		//String str = "H11He49NO35B7N46Li20";
		//String str = "K4(ON(SO3)2)2";
		String str = "Mg(OH)2";
		//String str = "(ScTh13)16Tb22C18Fl34Ag14(At41Bk4NpEsTc27Am20)3";
		//String str = "((Bi16LrSc30As49As23La13La(Ba21Re28BkRf40DbP29SeSe41La27Cn16)48(TcRn)49(Sb28Ti4Po35Mn16)21(Ta36Tl2Br5Dy21S41)6(Bh37Li36O20Tb48)24Cr43Pd11Pu39OgYb43Zr35FmHe44(Rh35BiLaCf4RnHLi10RgLuRg)3(Cn15PbS44Nd18)8)25((Hs11B41Rf46)20(At48Te45)32(Cs15Mt19OgHs34Ts5La33Ga23Np50Dy33O24)4)13((Po21ZnPdK27Pm16TlCo34Nd30Y4N)16(Nh2BaNa28Ga15LuAl38)17(Rb23ReRf2Rf33I32Te48Bh)50(Cf37Ne32W33BeRgIr21Cs34Mc17Zn43)43(Ho23ArEs38Er40Tb8DyIn41Tc36Hg21Cl9)42(Y8B25Ts16S10Fr2Lv22Po6)2(Zn46N34Ds7Sg20HoRf31P25ZrIHo22)40(FeRh50Kr9ThPt49)37(TaLrKr35Kr12SrCd26Xe28Mt26CnFl)43)23)17";
		System.out.println(countOfAtoms(str));
		//String s = "BeBe";
		//String [] a = s.split("(?<=\\G.{2})");
		//System.out.println(Arrays.toString(a));
	}
	public static String countOfAtoms(String formula) {
		Map<String,Integer> atomCount = new HashMap<String,Integer>();
		String[] ele = formula.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)|(?<=\\()|(?<=\\W)|(?=\\W)");
		System.out.println(Arrays.toString(ele));
		String result = "";
		int num = 1;
		int tempNum = 1;
		int countParen = 0;
		List<Integer> nums = new ArrayList<Integer>();
		for(int i = ele.length-1; i >= 0 ;i--) {
			String ch = String.valueOf(ele[i]);
			System.out.println(ch);
			if(ch.matches("[0-9]*")) {
				if(ele[i-1].equals(")")) {
					nums.add(Integer.parseInt(ch));
					num = num * Integer.parseInt(ch);
				}else {
					tempNum = Integer.parseInt(ch);
				}
			}else if(ch.equals(")")) {
				countParen++;
				continue;
			}else if(ch.equals("(")) {
				countParen--;
				int dec = nums.get(nums.size()-1);
				num = num / dec;
				nums.remove(nums.size()-1);
				if(countParen == 0) 	num = 1;
			}else{ 
				if(ch.length() >= 2) {
					String[] tEle = ch.split("(?<=\\G.{1})");
					for(int j = tEle.length-1 ; j>=0; j--) {
						String s = "";
						if(tEle[j].matches("[A-Z]")) {
							s = tEle[j];
						}else if (tEle[j].matches("[a-z]") && tEle[j-1].matches("[A-Z]")) {
							s = tEle[j-1] + tEle[j];
							j--;
						}
						if(!atomCount.containsKey(s)) {
							atomCount.put(s, (num * tempNum));
						}else {
							atomCount.put(s , (num * tempNum + atomCount.get(s)));
						}
						tempNum = 1;
					}
				}else {
					if(!atomCount.containsKey(ch)) {
						atomCount.put(ch, (num * tempNum));
					}else {
						atomCount.put(ch , (num * tempNum + atomCount.get(ch)));
					}
					tempNum = 1;
				}
			}
		}
		List<String> keys = new ArrayList<String>();
		keys.addAll(atomCount.keySet());
		Collections.sort(keys);
		for(String k : keys) {
			if(atomCount.get(k) != 1) {
				result = result + k +  atomCount.get(k);
			}else {
				result = result + k;
			}
		}
        return result;
	}
	/*public static String countOfAtoms(String formula) {
		Map<String,Integer> atomCount = new HashMap<String,Integer>();
		char[] c = formula.toCharArray();
		//String[] ele = formula.split("(?<=\\()|(?=\\))");
		String[] ele = formula.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)|(?<=O)|(?<=\\()|(?=O)|(?=\\()");
		System.out.println(Arrays.toString(ele));
		String result = "";
		int num = 1;
		int tempNum = 1;
		int countParen = 0;
		String e = "";
		List<Integer> nums = new ArrayList<Integer>();
		for(int i = c.length-1; i >= 0 ;i--) {
			String ch = String.valueOf(c[i]);
			if(ch.matches("[0-9]")) {
				if(c[i-1] == ')') {
					nums.add(Integer.parseInt(ch));
					num = num * Integer.parseInt(ch);
				}else if(String.valueOf(c[i-1]).matches("[0-9]")){
					int tNum = Integer.parseInt(String.valueOf(c[i-1])+ch);
					num = num * tNum;
					i = i-1;
					nums.add(tNum);
					continue;
				}else {
					tempNum = Integer.parseInt(ch);
				}
			}else if(ch.equals(")")) {
				countParen++;
				continue;
			}else if(String.valueOf(ch).matches("[a-z]")) {
				e = ch;
				continue;				
			}else if(ch.matches("[A-Z]")) { // && !String.valueOf(c[i+1]).matches("[a-z]")) {
				e = ch + e;
				//result = result + ch + (num * tempNum);
				if(!atomCount.containsKey(e)) {
					atomCount.put(e, (num * tempNum));
				}else {
					atomCount.put(e, (num * tempNum + atomCount.get(e)));
				}
				tempNum = 1;
				e = "";
				int dec = nums.get(nums.size()-1);
				num = num / dec;
				nums.remove(nums.size()-1);
				if(countParen == 0) 	num = 1;
			}else if(ch.equals("(")) {
				countParen--;
				int dec = nums.get(nums.size()-1);
				num = num / dec;
				nums.remove(nums.size()-1);
				if(countParen == 0) 	num = 1;
			}
		}
		List<String> keys = new ArrayList<String>();
		keys.addAll(atomCount.keySet());
		Collections.sort(keys);
		for(String k : keys) {
			if(atomCount.get(k) != 1) {
				result = result + k +  atomCount.get(k);
			}else {
				result = result + k;
			}
		}
        return result;
    }*/
}
