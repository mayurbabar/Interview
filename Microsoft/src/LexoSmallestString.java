// https://leetcode.com/discuss/interview-question/366869/

public class LexoSmallestString {

	public static void main(String[] args) {
		System.out.println(solution("abczd")); // abcd
		System.out.println(solution("abcde")); // abcd
		System.out.println(solution("eabcd")); // abcd
		System.out.println(solution(""));      // ""
		System.out.println(solution(null));    // ""
	}

	public static String solution(String S) {
		if(S == null ||  S.length() == 0)
			return "";
		
		StringBuilder sb = new StringBuilder(S);
		
		int i=0;
		
		// break if you find character is greater than next character and delete that character.
		for(; i < sb.length()-1; i++) {
			if(sb.charAt(i) > sb.charAt(i+1))
				break;
		}
		sb.deleteCharAt(i);
		
		return sb.toString();
	}
}
