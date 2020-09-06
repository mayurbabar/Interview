// https://leetcode.com/discuss/interview-question/398026/

public class MinMovesStringWithout3IdenticalLetters {

	public static void main(String[] args) {
		System.out.println("Min moves to obtain String without 3 identical consecutive letters: ");
		System.out.println(solution("baaaaa"));         // 1
		System.out.println(solution("baaabbaabbba"));   // 2
		System.out.println(solution("baabab"));         // 0
		System.out.println(solution("aaaaaabaaa"));     // 3
		System.out.println(solution(""));               // 0
		System.out.println(solution(null));             // 0
	}

	public static int solution(String S) {
	    int moves = 0;
	    
	    if(S == null || S.length() == 0)
	    	return 0;
	    
	    for (int i = 0 ; i < S.length(); i++) {
	        int runLength = 1;
	        
	        // Find the length of consecutive same characters 
	        while (i + 1 < S.length() && S.charAt(i) == S.charAt(i + 1)) {
	            runLength++;
	            i++;
	        }
	        
	     // For every 3 consecutive same character swap 1 character
	        moves += runLength / 3;
	    }
	    return moves;
	}

}
