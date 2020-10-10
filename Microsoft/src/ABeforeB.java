// https://stackoverflow.com/questions/62687206/how-to-write-a-function-solution-in-java-that-given-a-string-consisting-of-lette

public class ABeforeB {

	public static void main(String[] args) {
		System.out.println("Using RegEx Solution: ");
		System.out.println(solution("aabbb"));  // True
		System.out.println(solution("ba"));     // False
		System.out.println(solution("aaa"));    // True
		System.out.println(solution("b"));      // True
		System.out.println(solution("abba"));   // False
		
		System.out.println("Using Solution 2: ");
		System.out.println(solution2("aabbb"));  // True
		System.out.println(solution2("ba"));     // False
		System.out.println(solution2("aaa"));    // True
		System.out.println(solution2("b"));      // True
		System.out.println(solution2("abba"));   // False
		
		System.out.println("Using Solution 3: ");
		System.out.println(solution3("aabbb"));  // True
		System.out.println(solution3("ba"));     // False
		System.out.println(solution3("aaa"));    // True
		System.out.println(solution3("b"));      // True
		System.out.println(solution3("abba"));   // False
		System.out.println(solution3("aabab"));   // False

	}
	
	// Time Complexity: O(N) or O(2^N) depending on RegEx implementation.
	// Space Complexity: O(1)
	public static Boolean solution(String S) {
		return S.matches("a*b*");
	}

	// Time Complexity: O(N) Where N is the length of input string.
	// Space Complexity: O(1)
	public static Boolean solution2(String S) {
		int i=0, j=S.length()-1;
		
		while(i < j) {
			if(S.charAt(i) > S.charAt(j))
				return false;
			
			if(S.charAt(i) == S.charAt(j) && S.charAt(j) == 'b')
				j--;
			else
				i++;
		}
		
		return true;
	}
	
	// Time Complexity: O(N) Where N is the length of input string.
	// Space Complexity: O(1)
	public static boolean solution3(String S) {
	    boolean seenA = false;
	    
	    for (int i = S.length()-1; i >= 0; i--) {
	        char c = S.charAt(i);
	        
	        if (c == 'a')
	             seenA = true;
	        else if (c == 'b' && seenA)
	             return false;
	    }
	    return true;
	}
	
	
}
