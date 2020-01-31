// https://leetcode.com/discuss/interview-question/398026/

public class MinMovesString {

	public static void main(String[] args) {
		System.out.println("Min moves to obtain String without 3 identical consecutive letters: ");
		System.out.println(solution("baaaaa"));         // 1
		System.out.println(solution("baaabbaabbba"));   // 2
		System.out.println(solution("baabab"));         // 0
		System.out.println(solution("aaaaaabaaa"));     // 3
	}

	public static int solution(String S) {
	    int moves = 0;
	    
	    for (int i = 0 ; i < S.length(); i++) {
	        int runLength = 1;
	        
	        while (i + 1 < S.length() && S.charAt(i) == S.charAt(i + 1)) {
	            runLength++;
	            i++;
	        }
	        moves += runLength / 3;
	    }
	    return moves;
	}

}
