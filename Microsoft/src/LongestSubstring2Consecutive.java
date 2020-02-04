// https://leetcode.com/discuss/interview-question/398031/

public class LongestSubstring2Consecutive {

	public static void main(String[] args) {
		System.out.println(solution("aabbaaaaabb"));      // expected: aabbaa
		System.out.println(solution("aabbaabbaabbaa"));   // expected: aabbaabbaabbaa
		System.out.println(solution("abbaabbaaabbaaa"));  // expected: abbaabbaa
		System.out.println(solution("abbaaabbaabbaaa"));  // expected: aabbaabbaa
		System.out.println(solution(""));                 // expected: ""
		System.out.println(solution(null));               // expected: ""
	}

	public static String solution(String S) {
		if(S == null ||  S.length() < 3)
			return (S==null) ? "" : S;
		
		int start =0, curr =0, end = 1, maxLen=1, count=0;
		char c = S.charAt(0);  // current character
		
		while(end < S.length()) {
			if(S.charAt(end) == c) {
				count++; // incrementing same character count
				
				// valid enough to consider to be a part of the substring
				if(count == 2) {
					
					// length of the current substring is greater than maxlen then update the maxlen
					if(end - curr+1 > maxLen) {
						maxLen = end - curr +1;
						start=curr;
					}
				}
				else 
					curr = end-1;    // count > 2, therefore we need to start a new substring; reset curr
			}
			else {
				c = S.charAt(end);  // different character found, reset current character.
				count=1;            // reset same letter consecutive appearance counter
				
				// length of the current substring is greater than maxlen then update the maxlen
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
