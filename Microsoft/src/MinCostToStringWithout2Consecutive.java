// https://leetcode.com/discuss/interview-question/558379/

// Logic is to keep the cost of an item which we don't want to delete.
// Time Complexity : O(N)
// Space Complexity: O(1)

public class MinCostToStringWithout2Consecutive {

	public static void main(String[] args) {
		System.out.println("Min Cost to Get String Without 2 Identical Consecutive Letters: ");
		System.out.println(solution("abccbd", new int[] {0,1,2,3,4,5})); // 2
		System.out.println(solution("aabbcc", new int[] {1,2,1,2,1,2})); // 3
		System.out.println(solution("aaaa", new int[] {3,4,5,6}));       // 12
		System.out.println(solution("ababa", new int[] {10,5,10,5,10})); // 0
		System.out.println(solution("ab", new int[] {1,3}));             // 0

	}
	
	private static int solution(String s, int[] nums) {
		int res = 0;
		int sum = nums[0], max = nums[0];
		
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i) != s.charAt(i-1)) {
				res += sum - max;
				sum = nums[i];
				max = nums[i];
			}else {
				sum += nums[i];
				// Find the cost of character which we don't want to delete
				max = Math.max(max, nums[i]);
			}
		}
		
		// if last few characters are same
		res += sum - max;
		
		return res;
	}
}
