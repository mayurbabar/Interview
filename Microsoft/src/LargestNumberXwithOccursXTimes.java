// https://leetcode.com/discuss/interview-question/525977/

// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class LargestNumberXwithOccursXTimes {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,8,2,3,3,2}));   // 3
		System.out.println(solution(new int[] {7,1,2,8,2}));     // 2
		System.out.println(solution(new int[] {3,1,4,1,5}));     // 0
		System.out.println(solution(new int[] {5,5,5,5,5}));     // 5
	}

	private static int solution(int[] A) {
		Map<Integer, Integer> numFrequency = new HashMap<>();
		int max =0;
		
		// Calculate the frequency of each number in the input array
		for(int num : A)  
			numFrequency.put(num, numFrequency.getOrDefault(num, 0) +1);

		for(int key: numFrequency.keySet()) {
			// If frequency of number is same as number and it's greater than current result(max) then update result
			if(key == numFrequency.get(key) && key > max)
				max = key;
		}
		
		return max;
	}
}
