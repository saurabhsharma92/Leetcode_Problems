package arrayandstring;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BracketValidator {

	public static void main(String[] args) {
		String s = "){";
		Boolean result = validateBracket(s);
		System.out.println(result);
	}

	private static Boolean validateBracket(String s) {
		char[] chars = s.toCharArray();
		if(chars.length % 2 != 0)
			return false;
		List<Character> tempList = new ArrayList<Character>();
		Map<Character,Character> matchMap = new HashMap<Character,Character>();
		matchMap.put('(', ')');
		matchMap.put('[', ']');
		matchMap.put('{', '}');
		Map<Character,Character> revMatchMap = new HashMap<Character,Character>();
		revMatchMap.put(')', '(');
		revMatchMap.put(']', '[');
		revMatchMap.put('}', '{');
		for(int i=0; i< chars.length;i++) {
			if(matchMap.containsKey(chars[i])) {
				tempList.add(chars[i]);
			}
			if(!tempList.isEmpty() && matchMap.containsValue(chars[i]) && tempList.get(tempList.size()-1) == revMatchMap.get(chars[i])){
				tempList.remove(tempList.size()-1);
			}
		}
		if(tempList.size() == 0)
			return true;
		else
			return false;
	}

}

/**
 * Same logic implemented through stack
 * public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
 */

