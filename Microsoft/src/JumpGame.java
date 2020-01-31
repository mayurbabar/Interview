// https://leetcode.com/discuss/interview-question/451482/

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class JumpGame {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,4,2,3,0,3,1,2,1}, 7)); // True
		System.out.println(solution(new int[] {3,4,2,3,0,5,1,2,1}, 7)); // False
	}

	private static boolean solution(int[] A, int start) {
		if(A == null || A.length == 0)
			return false;
		
		Set<Integer> visited = new HashSet<>();
		Deque<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visited.add(start);
		while(q.size()>0) {
			int current = q.poll();
			
			if(A[current] == 0)
				return true;
			
			int index = current - A[current];
			if(index >=0 && !visited.contains(index)) {
				q.offer(index);
				visited.add(index);
			}
			
			index = current + A[current];
			if(index < A.length && !visited.contains(index)) {
				q.offer(index);
				visited.add(index);
			}
		}
		return false;
	}
}
