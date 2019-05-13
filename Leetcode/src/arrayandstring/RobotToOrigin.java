package arrayandstring;
import java.util.Arrays;

public class RobotToOrigin {

	public static void main(String[] args) {
		String moves = "LRRLLR";
		System.out.println(new RobotToOrigin().judgeCircle(moves));
		moves.toCharArray();
	}
	
	public boolean judgeCircle(String moves) {
        int start[] = {0,0};
        int i = 0, j = 0;
        String move[] = moves.split("");
        for(String m : move) {
        	i = start[0];
         	j = start[1];
        	if(m.equalsIgnoreCase("R")) {
        		/*if(j < 0) {
        			j += 1;
        		}else if (j >= 0) {
        			j += 1;
        		}*/
        		j += 1;
        	}else if(m.equalsIgnoreCase("L")) {
        		/*if(j <= 0) {
        			j -= 1;
        		}else if (j >= 0) {
        			j += 1;
        		}*/
        		j -= 1;
        	}else if(m.equalsIgnoreCase("U")) {
        		i += 1;
        	}else if(m.equalsIgnoreCase("D")) {
        		i -= 1;
        	}
        	start[0] = i;
        	start[1] = j;
        	System.out.println("m : "+m+" i : "+i+" j : "+j);
        }
        System.out.println(Arrays.toString(move));
        if(i == 0 && j == 0)
        	return true;
        else
        	return false;
    }
}
