// https://leetcode.com/discuss/interview-question/492652/

import java.util.HashSet;
import java.util.Set;

public class PlaneSeatReservation {

	public static void main(String[] args) {
		System.out.println(solution(2, "1A 2F 1C"));          // 2
		System.out.println(solution(3, "1A 2F 1C 3A 3K"));    // 4
		System.out.println(solution(3, "1A 2F 1C 3C 3J"));    // 3
		System.out.println(solution(0, "1A 2F 1C 3C 3J"));    // 0
		System.out.println(solution(3, null));                // 0
		System.out.println(solution(3, ""));                  // 6
		System.out.println(solution(2, "1J 2F 2B 2H 1E 1C")); // 0
		
	}
	
	public static int solution(int N, String S) {
		int family =0;
		Set<String> bookedSeats = new HashSet<>();
		
		// if plane have 0 rows then we can't assign any seat.
		// Assuming S is never null. If it is null then it's a bad data so return 0.
		// if S is empty that means none of the seat is booked.
		if(N <=0 || S == null)
			return 0;
		
		String[] arr = S.split(" ");
		
		for(String str : arr)
			bookedSeats.add(str);
		
		for(int i=1; i<=N; i++) {
			// Check if we can accommodate family on either side of aisle.
			if(!bookedSeats.contains(i+"B") && !bookedSeats.contains(i+"C") && !bookedSeats.contains(i+"D") && !bookedSeats.contains(i+"E")) {
				family++;
				bookedSeats.add(i+"B");
				bookedSeats.add(i+"C");
				bookedSeats.add(i+"D");
				bookedSeats.add(i+"E");
			}
			
			// Check if we can accommodate family on either side of aisle.
			if(!bookedSeats.contains(i+"F") && !bookedSeats.contains(i+"G") && !bookedSeats.contains(i+"H") && !bookedSeats.contains(i+"J")) {
				family++;
				bookedSeats.add(i+"F");
				bookedSeats.add(i+"G");
				bookedSeats.add(i+"H");
				bookedSeats.add(i+"J");
			}
			
			// Check if we can accommodate family on middle seats.
			if(!bookedSeats.contains(i+"D") && !bookedSeats.contains(i+"E") && !bookedSeats.contains(i+"F") && !bookedSeats.contains(i+"G"))
				family++;
		}
		
		return family;
	}

}
