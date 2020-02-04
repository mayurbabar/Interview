// https://leetcode.com/discuss/interview-question/364760/

public class MaxNetworkRank {

	public static void main(String[] args) {
		System.out.println("Max Network Rank: ");
		System.out.println(solution(new int[] {1,2,3,3}, new int[] {2,3,1,4}, 4));     //4
		System.out.println(solution(new int[] {1,2,3,3,2}, new int[] {2,3,1,4,5}, 5)); //5
		System.out.println(solution(new int[] {1,2,3,3}, new int[] {2,3,1,4}, 5));     //4
		System.out.println(solution(new int[] {}, new int[] {}, 2));                   //0
		System.out.println(solution(null, null, 2));                                   //0
	}

	public static int solution(int[] A, int[] B, int N) {
		if(A == null || B == null || A.length == 0 || B.length == 0 || N <= 0)
			return 0;
		
		int result =Integer.MIN_VALUE;
		int[] nodeCount = new int[N+1];
		
		// Store the count of incoming + outgoing roads for each city.
		for(int i=0; i<A.length; i++) {
			nodeCount[A[i]]++;
			nodeCount[B[i]]++;
		}
		
		for(int i=0; i<A.length; i++) {
			
			// -1 because we are counting same road connecting 2 cities twice (for City A and City B)
			int sum = nodeCount[A[i]] + nodeCount[B[i]] -1 ;
			if(sum > result)
				result = sum; 
		}
		
		return result;
	}
}
