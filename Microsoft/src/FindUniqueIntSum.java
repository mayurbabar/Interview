// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

import java.util.Arrays;

public class FindUniqueIntSum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sumZero(5))); //[1,-1,2,-2,0]
		System.out.println(Arrays.toString(sumZero(3))); //[1,-1,0]
		System.out.println(Arrays.toString(sumZero(4))); //[1,-1,2,-2]
		System.out.println(Arrays.toString(sumZero(1))); //[0]
	}
	
    public static int[] sumZero(int n) {
        boolean addZero = (n%2 == 1);
        int[] result = new int[n];
        
        int k=0;
        for(int i=1; i<=n/2; i++){
            result[k++] = i;
            result[k++] = -i;
        }
        
        if(addZero)
            result[k] = 0;
        
        return result;
    }

}
