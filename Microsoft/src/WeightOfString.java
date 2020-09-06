// https://leetcode.com/discuss/interview-question/538445/Microsoft-or-OA-2020-or-Weight-of-string

// Time Complexity: O(N) Where N is the length of the input string
// Space Complexity: O(1)

public class WeightOfString {

	public static void main(String[] args) {

		System.out.println(solution("hellomrz", 2) == 91);
		System.out.println(solution("aaaaa", 1) == 5);
		System.out.println(solution("a", 25) == 25);
		System.out.println(solution("az", 1) == 1);

	}
	
	public static int solution(String S, int n) {
		if(S == null || S.length() == 0)
			return 0;
		
		int weight=0;
		
		for(char c: S.toCharArray()) {
			weight += ((c - 'a') + n) % 26;
		}
		
		return weight;
	}

}
