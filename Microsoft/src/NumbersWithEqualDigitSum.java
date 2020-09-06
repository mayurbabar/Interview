// https://leetcode.com/discuss/interview-question/365872/

import java.util.HashMap;
import java.util.Map;

public class NumbersWithEqualDigitSum {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {51,71,17,42}));                 // 93
		System.out.println(solution(new int[] {42,33,60}));                    // 102
		System.out.println(solution(new int[] {51,32,43}));                    // -1
		System.out.println(solution(new int[] {51,71,17,42,33,44,24,62}));     // 133
		System.out.println(solution(new int[] {}));                            // -1
		System.out.println(solution(null));                                    // -1
	}
	
	public static int solution(int[] A) {
		if(A == null || A.length <= 1)
			return -1;
		
		// stores digit sum and number
		Map<Integer, Integer> map = new HashMap<>();
		
		int result = -1;
		for(int num: A) {
			int digitSum = calculateSum(num);
			
			if(!map.containsKey(digitSum))
				map.put(digitSum, num);
			else {
				int presentNum = map.get(digitSum);
				result = Math.max(result, presentNum + num);
				
				// if current number is greater than already present map number then put current number in map
				map.put(digitSum, Math.max(num, presentNum));
			}
		}
		
		return result;
	}
	
	// Gets number as a input and returns sum of the digits 
	public static int calculateSum(int num) {
		int sum =0;
		
		while(num > 0) {
			sum += num%10;
			num = num/10;
		}
		return sum;
	}

}
