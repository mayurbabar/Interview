// https://leetcode.com/discuss/interview-question/555702/Microsoft-or-Online-Codility-Assessment-or-Counterexample-(Task-1)

// Time Complexity: O(N) 
// Space Complexity: O(N)

public class CounterExample {
	
	public static int find_min(int[] A) {
		int ans=0;
		
		for(int i=1; i<A.length; i++) {
			if(ans > A[i])
				ans = A[i];
		}
		return ans;
	}
	
	public static int correct_find_min(int[] A) {
		int ans=Integer.MAX_VALUE;
		
		for(int i=0; i<A.length; i++) {
			if(A[i] < ans)
				ans = A[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println("Result with fin_min function...");
		System.out.println(find_min(solution(4)));      // 0
		System.out.println(find_min(solution(1)));      // 0
		System.out.println(find_min(solution(1000)));   // 0
		
		System.out.println("Result with correct_fin_min function...");
		System.out.println(correct_find_min(solution(4)));      // 1
		System.out.println(correct_find_min(solution(1)));      // 1
		System.out.println(correct_find_min(solution(1000)));   // 1
	}

	private static int[] solution(int N) {
		int[] result = new int[N];

		for(int i=0; i<N; i++) {
			result[i] = i+1;
		}
		
		return result;
	}
}
