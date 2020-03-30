// https://leetcode.com/discuss/interview-question/451422/

public class FairIndexs {

	public static void main(String[] args) {
		System.out.println(solution2(new int[] {4,-1,0,3}, new int[] {-2,5,0,3}));       // 2
		System.out.println(solution2(new int[] {2,-2,-3,3}, new int[] {0,0,-4,4}));      // 1
		System.out.println(solution2(new int[] {4,-1,0,3}, new int[] {-2,6,0,4}));       // 0
		System.out.println(solution2(new int[] {1,4,2,-2,5}, new int[] {7,-2,-2,2,5}));  // 2
	}

	public static int solution(int[] A, int[] B) {
		int result=0;
		
		for(int i=1; i<A.length; i++) {
			if(getSum(A, 0, i-1) == getSum(A, i, A.length-1) && getSum(B, 0, i-1) == getSum(A, i, B.length-1))
				result++;
		}
		
		return result;
	}

	private static int getSum(int[] arr, int start, int end) {
		int sum =0;
		
		for(int i=start; i<=end; i++)
			sum += arr[i];
		
		return sum;
	}
	
	public static int solution2(int[] A, int[] B) {
		int sumA=0, sumB=0;
		int result=0;
		
		// Calculate the complete sum for both the array elements
		for(int i=0; i<A.length; i++) {
			sumA += A[i];
			sumB += B[i];
		}
		
		// Store the intermediate sum
		int tempA=0, tempB=0;
		for(int i=0; i <A.length; i++) {
			// sum of both the arrays till index i-1 is same and intermediate sum of both the arrays is half of complete 
			// sum of respective array then it is a fair index. 
			if(i!=0 && tempA == tempB && 2*tempA == sumA && 2*tempB == sumB)
				result++;
			
			//store the sum of arrays till index i
			tempA += A[i];
			tempB += B[i];
		}
		
		return result;
	}
}
