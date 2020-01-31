// https://leetcode.com/discuss/interview-question/366869/

public class LexoSmallestString {

	public static void main(String[] args) {
		System.out.println(solution("abczd")); // abcd
		System.out.println(solution("abcde")); // abcd
		System.out.println(solution("eabcd")); // abcd
	}

	public static String solution(String S) {
		StringBuilder sb = new StringBuilder(S);
		
		int i=0;
		for(; i < sb.length()-1; i++) {
			if(sb.charAt(i) > sb.charAt(i+1))
				break;
		}
		sb.deleteCharAt(i);
		
		return sb.toString();
	}
}
