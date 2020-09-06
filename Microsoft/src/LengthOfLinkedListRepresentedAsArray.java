// https://leetcode.com/discuss/interview-question/546683/OA-Microsoft-2020 (Task-3)

// Time Complexity: O(N) 
// Space Complexity: O(1)

public class LengthOfLinkedListRepresentedAsArray {

	public static void main(String[] args) {
		System.out.println("Finding the lengths of the array -> an array represents a linked list where index 0 represents the head...");
		System.out.println(solution(new int[] {1,4,-1,3,2}));  // 4
		System.out.println(solution(new int[] {-1,4,-1,3,2})); // 0
		System.out.println(solution(new int[] {1,4,3,-1,2}));  // 5

	}

	private static int solution(int[] A) {
		if(A == null || A.length == 0 || A[0] == -1)
			return 0;
		
		int length=0;
		int index=0;
		
		while (true) {
			length++;
			index = A[index];
			
			if(index == -1)
				break;
		}
		
		return length;
	}
}
