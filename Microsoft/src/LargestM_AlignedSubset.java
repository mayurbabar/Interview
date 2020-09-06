// https://leetcode.com/discuss/interview-question/525894/
// We have to ensure that all numbers in a group have the same remainder after dividing by m. Because if i % m == j % m, then (i - j) % m == 0, which satisfies our "M-aligned" criteria for the group.
// Time Complexity: O(N) Where N is the size of input array 
// Space Complexity: O(M)

public class LargestM_AlignedSubset {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {-3,-2,1,0,8,7,1}, 3));  // 4
		System.out.println(solution(new int[] {7,2,4,8,6},2));         // 4
		System.out.println(solution(new int[] {3,1,4,1,5},1));         // 5
		System.out.println(solution(new int[] {5,5,5,5,5},0));         // 0
		System.out.println(solution(new int[] {4,7,10,6,9},3));        // 3
		System.out.println(solution(new int[] {1,4},2));               // 0
	}

	private static int solution(int[] array, int M) {
        if (array == null || array.length == 0 || M <= 0) 
        	return 0;
        
        // store the count of array numbers by the reminder
        int[] subsetSize = new int[M];
        int index=0;
        int result = 0;
        
        for (int num : array) {
            // get reminders, and convert negative reminders to positive
            if (num < 0) 
            	index = (num % M + M) % M;
            else
            	index = num % M;
            
            subsetSize[index]++;
            result = Math.max(subsetSize[index], result);
        }
        
        return (result < 2) ? 0 : result;
    }
}
