// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

import java.util.Arrays;

public class UniqueIntegerSum0 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(1)));
		System.out.println(Arrays.toString(solution(2)));
		System.out.println(Arrays.toString(solution(3)));
		System.out.println(Arrays.toString(solution(4)));

	}
	
	public static int[] solution(int N) {
		// if N is odd we need to add 0 in the result
		boolean addZero = (N%2 == 1) ? true : false;
		int[] result = new int[N];
		
		int i=0;
		int num=1;
		while(i< N/2) {
			result[i++] = num++;
		}
		
		num=-1;
		for(int j=0; j< N/2; j++) {
			result[i++] = num--;
		}
		
		if(addZero)
			result[N-1] = 0;
		
		return result;
	}	

}
