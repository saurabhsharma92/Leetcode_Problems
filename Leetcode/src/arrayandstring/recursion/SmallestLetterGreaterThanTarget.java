package arrayandstring.recursion;
/**
 *	Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
	Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
	Examples:
	Input:
	letters = ["c", "f", "j"]
	target = "a"
	Output: "c"
	
	Input:
	letters = ["c", "f", "j"]
	target = "c"
	Output: "f"
	
	Input:
	letters = ["c", "f", "j"]
	target = "d"
	Output: "f"
	
	Input:
	letters = ["c", "f", "j"]
	target = "g"
	Output: "j"
	
	Input:
	letters = ["c", "f", "j"]
	target = "j"
	Output: "c"
	
	Input:
	letters = ["c", "f", "j"]
	target = "k"
	Output: "c" 
 */
public class SmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		char[] letters = {'c','f','j'};
		char target = 'a';
		System.out.println(nextGreatestLetter(letters, target));
	}
	
	public static char nextGreatestLetter(char[] letters, char target) {
		int start = 0;
		int end = letters.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			char left = (mid == 0) ? 'a' : letters[mid-1];
			if(target >= left && target < letters[mid]) {
				return letters[mid];
			}
			if(target >= letters[mid]) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return letters[0];
	}
}
