package arrayandstring;

import java.util.ArrayList;
import java.util.List;

public class Subset {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(subsets(nums));
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> pList = new ArrayList();
        pList.add(new ArrayList<Integer>());
        generate(pList, nums, 0);
        return pList;
    }
    
    private static void generate(List<List<Integer>> pList, int[] nums, int index){
        if(index == nums.length){
            return;
        }else{
            int size = pList.size();
            for(int i=0; i<size; i++){
                List<Integer> temp = new ArrayList<>(pList.get(i));
                temp.add(nums[index]);
                pList.add(temp);
            }
            generate(pList, nums, index+1);
        }
    }
}
