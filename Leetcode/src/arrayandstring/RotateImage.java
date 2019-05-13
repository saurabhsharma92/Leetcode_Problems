package arrayandstring;

import java.util.Arrays;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		rotate(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void rotate(int[][] matrix) {
        int n = matrix.length;
        System.out.println("n : "+n);
        for(int i = n; i> 1; i-=2){
            int lo = (n-i)/2;
            int hi = lo+i-1;
            System.out.println("lo : "+lo+" hi : "+hi);
            for(int j =0; j<i-1; j++){
                int temp = matrix[hi-j][lo];
                System.out.println(temp);
                matrix[hi-j][lo] = matrix[hi][hi-j];
                matrix[hi][hi-j] = matrix[lo+j][hi];
                matrix[lo+j][hi] = matrix[lo][lo+j];
                matrix[lo][lo+j] = temp;
            }
        }
        return;
    }
}

/**
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
