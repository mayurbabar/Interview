// https://leetcode.com/discuss/interview-question/398039/

public class StringWithout3ConsecutiveLetters {

	public static void main(String[] args) {
		System.out.println(solution("eedaaad"));          // expected: eedaad
		System.out.println(solution("aabbaabbaabbaa"));   // expected: aabbaabbaabbaa
		System.out.println(solution("abbaaaaaaabaaa"));   // expected: abbaabaa
		System.out.println(solution("xxxtxxx"));          // expected: xxtxx

	}

	public static String solution(String S) {
		if(S.length() < 3)
			return S;
		
		StringBuilder sb = new StringBuilder();
		sb.append(S.charAt(0));
		int count=1;
		char c = sb.charAt(0);
		
		for(int i=1; i< S.length();i++) {
			if(S.charAt(i) == c)
				count++;
			else {
				c = S.charAt(i);
				count=1;
			}
			
			if(count < 3)
				sb.append(S.charAt(i));
		}
		return sb.toString();
	}
}
