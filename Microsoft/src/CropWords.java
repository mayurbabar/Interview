// https://leetcode.com/discuss/interview-question/507367/

// Time Complexity: O(N) Where N is the length of the input string
// Space Complexity: O(N)

public class CropWords {

	public static void main(String[] args) {

		System.out.println(solution("Codility we test coders", 14).equals("Codility we"));
		System.out.println(solution(" co de my", 5).equals(" co"));
		System.out.println(solution(" co de my", 7).equals(" co de"));
		System.out.println(solution("   ", 2).equals(""));
		System.out.println(solution("   re", 2).equals("")); //3 spaces before
		System.out.println(solution(" c ", 3).equals(" c"));
		System.out.println(solution(" c d  ", 5).equals(" c d"));
		System.out.println(solution("co de my", 5).equals("co de"));
		System.out.println(solution("Word", 4).equals("Word"));
		System.out.println(solution("codility We test coders", 23).equals("codility We test coders"));
		System.out.println(solution("withOutSpaces", 14).equals("withOutSpaces"));
		System.out.println(solution("", 14).equals(""));
		System.out.println(solution("Separatedby hyphens", 14).equals("Separatedby"));
		System.out.println(solution("      Codility We test coders     ", 14).equals("      Codility")); //6 leading spaces
		System.out.println(solution("      Codility We test coders     ", 10).equals("")); //6 leading spaces

	}
	
	public static String solution(String message, int K) {
		if(message == null || message.length() == 0)
			return "";
		
		if (message.length() <= K)
			return trim(message);
		
		StringBuilder sb = new StringBuilder(message.substring(0, K+1));
		
		while(sb.length() > 0 && sb.charAt(sb.length() - 1) != ' '){
			sb.deleteCharAt(sb.length() - 1);
		}
		
		return trim(sb.toString());
	}
	
	private static String trim(String message){
		int i = message.length() - 1;
		
		while(i >= 0 && message.charAt(i) == ' '){
			i--;
		}
			
		if (i < 0)
			return "";
		
		return message.substring(0, i+1);
	}

}
