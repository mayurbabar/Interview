// https://leetcode.com/discuss/interview-question/398037/

public class LongestSemiAlternatingSubstring {

	public static void main(String[] args) {
		System.out.println(solution("aabbaaaaabb"));      // expected: aabbaa          // 6
		System.out.println(solution("aabbaabbaabbaa"));   // expected: aabbaabbaabbaa  // 14
		System.out.println(solution("abbaabbaaabbaaa"));  // expected: abbaabbaa       // 9
		System.out.println(solution("abbaaabababbaaa"));  // expected: aabababbaa      // 10
		System.out.println(solution("baaabbabbb"));       // expected: aabbabb         // 7
		System.out.println(solution("babba"));            // expected: aabababbaa      // 5
		System.out.println(solution("abaaaa"));           // expected: abaa            // 4
		System.out.println(solution("a"));                // expected: a               // 1
	}

	public static int solution(String S) {
		if(S.length() < 3)
			return S.length();
		
//		int start =0; 
		int curr =0, end = 1, maxLen=1, count=0;
		char c = S.charAt(0);
		
		while(end < S.length()) {
			if(S.charAt(end) == c) {
				count++;
				if(count == 2) {
					if(end - curr+1 > maxLen) {
						maxLen = end - curr +1;
//						start=curr;
					}
				}
				else 
					curr = end-1;
			}
			else {
				c = S.charAt(end);
				count=1;
				
				if(end - curr+1 > maxLen) {
					maxLen = end - curr +1;
//					start=curr;
				}
			}
			end++;
		}
//		String result = S.substring(start, start+maxLen);
		
		return maxLen;
	}
}
