// https://leetcode.com/discuss/interview-question/414660/

import java.util.ArrayList;
import java.util.List;

public class MinSwapGroupRedBalls {

	public static void main(String[] args) {
		System.out.println(solution("WRRWWR"));    // 2
		System.out.println(solution("WWRWWWRWR")); // 4
		System.out.println(solution("WWW"));       // 0
		System.out.println(solution("RRRWRR"));    // 2

		System.out.println("2nd function");
		System.out.println(min_swap("WRRWWR"));    // 2
		System.out.println(min_swap("WWRWWWRWR")); // 4
		System.out.println(min_swap("WWW"));       // 0
		System.out.println(min_swap("RRRWRR"));    // 2
	}

	public static int solution(String s) {
		List<Integer> redIndices = getRedIndices(s);
		int mid = redIndices.size() / 2;
		int minSwaps = 0;
		for (int i = 0; i < redIndices.size(); i++) {
			// number of swaps for each R is the distance to mid, minus the number of R's
			// between them
			minSwaps += Math.abs(redIndices.get(mid) - redIndices.get(i)) - Math.abs(mid - i);
		}
		return minSwaps;
	}

	private static List<Integer> getRedIndices(String s) {
		List<Integer> indices = new ArrayList<>(s.length());
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'R') {
				indices.add(i);
			}
		}
		return indices;
	}

	public static int min_swap(String s) {
		int red_count = 0;
		char[] arr = s.toCharArray();
		
		// Count the total number of red balls
		for (char c : arr) {
			if (c == 'R')
				++red_count;
		}
		
		int i = 0, j = s.length() - 1, result = 0;
		
		while (i < j) {
			
			// If we find R at i and j
			if (arr[i] == 'R' && arr[j] == 'R') {
				red_count -= 2;
				result += j - i - 1 - red_count;   // we have to swap the white balls in between i and j.
				
				++i;
				--j;
			} else if (arr[i] != 'R') {
				++i;
			} else {
				--j;
			}
		}
		return result;
	}

}
