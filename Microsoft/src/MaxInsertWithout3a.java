// https://leetcode.com/discuss/interview-question/398056/
	
// Time Complexity: O(N)
// Space Complexity: O(1)
public class MaxInsertWithout3a {

	public static void main(String[] args) {
		System.out.println(solution("aabab"));  // 3
		System.out.println(solution("dog"));    // 8
		System.out.println(solution("aa"));     // 0
		System.out.println(solution("baaaa"));  // -1
		System.out.println(solution("aaba"));   // 1
	}
	
	public static int solution(String S) {
		int result =0;
		int countA =0;
		
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i) != 'a') {
				result += 2 - countA;
				countA=0;
			}
			else {
				countA++;
					
				if(countA > 2)
					return -1;
			}
		}
		
		if(S.charAt(S.length()-1) == 'a')
			result = 2 - countA;   // if last character is 'a' then we can add either 0 or 1 'a' at the end
		else
			result += 2;           // if last character is not 'a' then we can add 2 more 'a' at the end
		
		return result;
	}
}
