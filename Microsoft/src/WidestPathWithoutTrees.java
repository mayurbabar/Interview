// https://leetcode.com/discuss/interview-question/447448/

import java.util.Arrays;

public class WidestPathWithoutTrees {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {5,5,5,7,7,7}, new int[] {3,4,5,1,3,7})); // 2
		System.out.println(solution(new int[] {6,10,1,4,3}, new int[] {2,5,3,1,6})); // 4
	}

	public static int solution(int[] X, int[] Y) {
		int result=0;
		
		Arrays.sort(X);
		
		for(int i=0; i<X.length-1; i++)
			result = Math.max(result, X[i+1] - X[i]);
		
		return result;
	}

}
