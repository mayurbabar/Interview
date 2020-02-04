// https://leetcode.com/discuss/interview-question/364618/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinStepsToMakePile {

	public static void main(String[] args) {
		System.out.println(solution2(new int[] {5,2,1}));     // 3
		System.out.println(solution2(new int[] {5,4,3,2}));   // 6
		System.out.println(solution2(new int[] {4,5,5,4,2})); // 6
		
		System.out.println("\nUsing Priority Queue:");
		System.out.println(minSteps(new int[] {5,2,1}));     // 3
		System.out.println(minSteps(new int[] {5,4,3,2}));   // 6
		System.out.println(minSteps(new int[] {4,5,5,4,2})); // 6
	}
	
	public static int solution(int[] A) {
		int result =0;
		
		Arrays.sort(A);
		
		while(A[0] != A[A.length - 1]) {
			for(int i=A.length-1; i > 0; i--) {
				if(A[i] != A[i-1]) {
					A[i] = A[i-1];
					result++;
				}
			}
		}
		
		return result;
	}
	
	public static int solution2(int[] A) {
        if(A == null || A.length <= 1) 
        	return 0;
        
        Arrays.sort(A);
        
        int result = 0, distinctNums = 0;
        
        // Traverse the array and find the unique numbers between number at index i and starting number and sum them.
        for(int i = 1; i < A.length; ++i){
            if(A[i] == A[i - 1]){
                result += distinctNums;
            }
            else{
                distinctNums++;
                result += distinctNums;
            }
        }
        return result;
	}
	
	private static int minSteps(int[] piles) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int p : piles) {
			map.put(p, map.getOrDefault(p, 0)+1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getKey() - a.getKey());
		maxHeap.addAll(map.entrySet());
		
		while(maxHeap.size() > 1) {
			Map.Entry<Integer, Integer> entry1 = maxHeap.poll();
			Map.Entry<Integer, Integer> entry2 = maxHeap.poll();
			
			res += entry1.getValue();
			
			entry2.setValue(entry2.getValue() + entry1.getValue());
			maxHeap.offer(entry2);
		}
		return res;
	}

}
