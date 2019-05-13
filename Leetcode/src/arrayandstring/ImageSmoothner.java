package arrayandstring;

import java.util.Arrays;

public class ImageSmoothner {
    public static void main(String[] args) {
        int[][] M = {{1,1,1},
                     {1,0,1},
                     {1,1,1}};
        int[][] res = imageSmoother(M);
        System.out.println(Arrays.toString(res[0]));
        System.out.println(Arrays.toString(res[1]));
        System.out.println(Arrays.toString(res[2]));
    }

    public static int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        for(int i=0; i<M.length; i++){
            for(int j=0; j<M[0].length; j++){
                res[i][j] = helper(i, j, M);
            }
        }
        return res;
    }

    private static int helper(int i, int j, int[][] M){
        int[] row = {1,1,1,0,0,-1,-1,-1};
        int[] col = {1,-1,0,1,-1,1,-1,0};
        int r = 0, c = 0, val = M[i][j], node = 1;
        while(r != 8){
            if(i+row[r] >= 0 && i+row[r] < M.length
                    && j+col[c] >= 0 && j+col[c] < M[0].length){
                node++;
                val += M[i+row[r]][j+col[c]];
            }
            r++;
            c++;
        }
        return (int) Math.floor(val/node);
    }
}
