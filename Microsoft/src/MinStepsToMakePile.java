// https://leetcode.com/discuss/interview-question/364618/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinStepsToMakePile {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {5,2,1}));     // 3
		System.out.println(solution(new int[] {5,4,3,2}));   // 6
		System.out.println(solution(new int[] {4,5,5,4,2})); // 6
		
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
	
	private static int minSteps(int[] piles) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int p : piles) {
			map.put(p, map.getOrDefault(p, 0)+1);
		}
		
		Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getKey() - a.getKey());
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
