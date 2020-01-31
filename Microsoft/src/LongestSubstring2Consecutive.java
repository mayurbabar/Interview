// https://leetcode.com/discuss/interview-question/398031/

public class LongestSubstring2Consecutive {

	public static void main(String[] args) {
		System.out.println(solution("aabbaaaaabb"));      // expected: aabbaa
		System.out.println(solution("aabbaabbaabbaa"));  // expected: aabbaabbaabbaa
		System.out.println(solution("abbaabbaaabbaaa"));  // expected: abbaabbaa
		System.out.println(solution("abbaaabbaabbaaa"));  // expected: aabbaabbaa
	}

	public static String solution(String S) {
		if(S.length() < 3)
			return S;
		
		int start =0, curr =0, end = 1, maxLen=1, count=0;
		char c = S.charAt(0);
		
		while(end < S.length()) {
			if(S.charAt(end) == c) {
				count++;
				if(count == 2) {
					if(end - curr+1 > maxLen) {
						maxLen = end - curr +1;
						start=curr;
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
					start=curr;
				}
			}
			end++;
		}
		return S.substring(start, start+maxLen);
	}
}
