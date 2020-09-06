import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/discuss/interview-question/645626/

// Time Complexity: O(1)
// Space Complexity: O(1) 

public class CountOfHoursVariations {

	public static void main(String[] args) {

		System.out.println(solution(1,0,0,2) == 12);
		System.out.println(solution(2,1,2,1) == 6);
		System.out.println(solution(1,4,8,2) == 5);
		System.out.println(solution(4,4,4,4) == 0);
	}
	
	public static int solution(int A, int B, int C, int D) {
		int digits[] = new int[] {A,B,C,D};
		boolean used[] = new boolean[4];
		Set<Integer> set = new HashSet<>(); 
		
		helper(digits, used, 0, 0, 0, set);
		
		return set.size();
	}
	
	public static void helper(int[] digits, boolean[] used, int idx, int hour, int min, Set<Integer> set) {
		if(hour >= 24 || min >= 60)
			return;
		
		if(idx >= digits.length) {
			set.add(hour * 60 + min);
			return;
		}
		
		for(int i=0; i<digits.length; i++) {
			if(used[i])
				continue;
			
			used[i] = true;
			
			if(idx < 2)
				helper(digits, used, idx+1, hour*10 + digits[i], min, set);
			else
				helper(digits, used, idx+1, hour, min*10 + digits[i], set);
			
			used[i] = false;
		}
	}

}
