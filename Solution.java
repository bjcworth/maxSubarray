*/QUESTION: Given an array, write a function to identify the sub-array with the maximum sum. 
For example if the input is [1, -3, 5, -2, 9, -8, -6, 4] the output would be [5, -2, 9]
 */

import java.io.*;
import java.util.*;


// This is a simple solution inspired by Kadane's Algorithm
class Solution {
  
  public static void maxSub(int[] A) {
    int maxStart = 0;
    int maxEnd = 0;
    int maxSum = Integer.MIN_VALUE;
    
    int cumSum = 0;
    int maxStartNow = 0;
    
    for (int i=0; i<A.length; i++) {
      int a_elem = A[i];
      cumSum += a_elem;
      
      if(cumSum > maxSum) {
        maxSum = cumSum;
        maxStart = maxStartNow;
        maxEnd = i;
      }
      else if (cumSum < 0) {
        maxStartNow = i+1;
        cumSum = 0;
      }
    }
    int[] subArray = Arrays.copyOfRange(A, maxStart, maxEnd+1);  
    System.out.println(Arrays.toString(subArray));
  }
  
  public static void main(String[] args) {
    int[] array = {0, 10, 1, 2, -100};
    maxSub(array);
  }
}


