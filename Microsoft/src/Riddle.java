// https://leetcode.com/discuss/interview-question/578315/

// Since we need to check just the previous and the next characters, we can fulfill any pattern using maximum 3 characters.
// We just need to check if both previous and next characters are different from 'a', 'b' or 'c' and put the one which satisfy the condition.

public class Riddle {

	public static void main(String[] args) {
		System.out.println(solution("ab?ac?"));        // abcaca
		System.out.println(solution("rd?e?wg??"));     // rdaeawgab
		System.out.println(solution("????????"));      // abababab
	}

	private static String solution(String str) {
		if(str.length() == 0)
			return str;
		
		char[] arr = str.toCharArray();
		
		for (int i = 0; i < arr.length; ++i) {
	        if (arr[i] == '?') {
	            for (char c = 'a'; c <= 'c'; ++c) {
	                if ((i == 0 || c != arr[i - 1]) && (i == arr.length - 1 || c != arr[i + 1])) {
	                    arr[i] = c;
	                    break;
	                }
	            }
	        }
	    }

	    return String.copyValueOf(arr);
	}
}
