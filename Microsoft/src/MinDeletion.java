// https://leetcode.com/discuss/interview-question/421975/

public class MinDeletion {

	public static void main(String[] args) {
		System.out.println("Min Deletion to obtain string in right format: ");
		System.out.println(solution("BAAABAB")); // 2
		System.out.println(solution("BBABAA"));  // 3
		System.out.println(solution("AABBBB"));  // 0

	}
	
	public static int solution(String S) {
		int countA = 0;
		int startA = -1;
		int endA = -1;
		int startB = -1;
		int endB = -1;
		
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i) == 'A') {
				countA++;
				if(startA == -1)
					startA = i;
				
				endA = i;
			}
			else {
				if(startB == -1)
					startB = i;
				
				endB = i;
			}
		}
		
		int countB = S.length()-countA;
		int removeA = 0;
		int removeB = 0;
		
		//remove B
		removeB = startA - 0;
		removeB += (endA-startA+1) - countA;
		
		//removeA
		removeA = (S.length()-1) - endB;
		removeA += (endB-startB+1) - countB;
		
		return Math.min(removeA, removeB);
	}

}
