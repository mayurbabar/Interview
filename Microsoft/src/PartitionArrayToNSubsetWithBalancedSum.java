import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/discuss/interview-question/430981/
// O(nlog(k)) Java

public class PartitionArrayToNSubsetWithBalancedSum {
	public static void main(String[] args) {
		System.out.println(part(new int[] {1,2,3,4,5},3));
		System.out.println(part(new int[] {1,1,2,3,4,5},3));
		System.out.println(part(new int[] {2,4,3,4,5},3));
	}
	
	public static List<List<Integer>> part(int[] T, int n) {
		int[] sums = new int[n];
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return sums[a] - sums[b];
			}
		});
		
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			result.add(new ArrayList<>());
			pq.add(i);
		}
		
		for (int i = T.length - 1; i >= 0; i--) {
			int c = pq.poll();
			result.get(c).add(T[i]);
			sums[c] += T[i];
			pq.add(c);
		}
		
		return result;
	}
}