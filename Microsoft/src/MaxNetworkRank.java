// https://leetcode.com/discuss/interview-question/364760/

public class MaxNetworkRank {

	public static void main(String[] args) {
		System.out.println("Max Network Rank: ");
		System.out.println(solution(new int[] {1,2,3,3}, new int[] {2,3,1,4}, 4)); //4
		System.out.println(solution(new int[] {1,2,3,3,2}, new int[] {2,3,1,4,5}, 5)); //5
	}

	public static int solution(int[] A, int[] B, int N) {
		int result =Integer.MIN_VALUE;
		int[] nodeCount = new int[N+1];
		
		for(int i=0; i<N; i++) {
			nodeCount[A[i]]++;
			nodeCount[B[i]]++;
		}
		
//		System.out.println(Arrays.toString(nodeCount));
		
		for(int i=0; i<N; i++) {
			int sum = nodeCount[A[i]] + nodeCount[B[i]] -1 ;
			if(sum > result)
				result = sum; 
		}
		
		return result;
	}
}
