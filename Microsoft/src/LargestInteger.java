// https://leetcode.com/discuss/interview-question/406031/

import java.util.HashSet;
import java.util.Set;

public class LargestInteger {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,2,-2,5,-3}));  // 3
		System.out.println(solution(new int[] {1,2,3,-4}));     // 0
	}

	private static int solution(int[] A) {
		Set<Integer> set = new HashSet<>();
		int result =0;
		
		// Insert the inverted number into set (if not present). if present select the max of current result and number.
		for(int num : A) {
			int invert = num * (-1);
			if(set.contains(invert) && Math.abs(num) > result)
				result = Math.abs(num);
			else
				set.add(num);
		}
		
		return result;
	}
}
