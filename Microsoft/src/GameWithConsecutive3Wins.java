// https://leetcode.com/discuss/interview-question/548119/

public class GameWithConsecutive3Wins {

	public static void main(String[] args) {
		System.out.println(solution("OXXXOXOOX"));        // expected: X
		System.out.println(solution("XOXXXOOOXOOO"));     // expected: tie
		System.out.println(solution("XX"));               // expected: tie
		System.out.println(solution("XXOO"));             // expected: tie
		System.out.println(solution("XXOOOOOXX"));        // expected: O

	}

	public static String solution(String S) {
		if(S.length() < 3)
			return "tie";
		
		int xCount = 0;
		int oCount = 0;

		int count=1;
		char previous = S.charAt(0);
		
		for(int i=1; i< S.length();i++) {
			// Count the number of same consecutive characters
			if(S.charAt(i) == previous) {
				count++;
				
				// If the consecutive count is 3 then update the update the game count for X or O
				if(count == 3) {
					if(S.charAt(i) == 'X')
						xCount++;
					else
						oCount++;
					
					count=0;
				}
					
			}			
			else {
				previous = S.charAt(i);
				count=1;
			}
		}
		
		if((xCount == 0 && oCount == 0) || (xCount > 0 && oCount > 0))
			return "tie";
		else if (xCount > 0)
			return "X";
		else
			return "O";
	}
}
