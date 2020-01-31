// https://leetcode.com/problems/day-of-the-week/

public class DaysOfWeek2 {
	// starting with Monday because known date is 01/20/2020 - Monday
	int[] months = {0 ,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	
	public static void main(String[] args) {
		DaysOfWeek2 solution = new DaysOfWeek2();
		
		System.out.println(solution.dayOfTheWeek(20, 1, 2020)); // Monday
		System.out.println(solution.dayOfTheWeek(18, 7, 1999)); // Sunday
		System.out.println(solution.dayOfTheWeek(15, 8, 1993)); // Sunday
		System.out.println(solution.dayOfTheWeek(20, 8, 2021)); // Friday
	}

	public String dayOfTheWeek(int day, int month, int year) {
		int curr = daysFromStart(20, 1, 2020);
		int cnt = daysFromStart(day, month, year);
		return days[((cnt - curr) % 7 + 7) % 7];   // if difference%7 is negative add 7;
	}

	private int daysFromStart(int day, int month, int year) {
		int sum = 0;
		for (int i = 1971; i < year; i++) {
			sum += 365;
			if (isLeapYear(i)) {
				sum++;
			}
		}
		for (int i = 1; i < month; i++) {
			sum += months[i];
			if (i == 2 && isLeapYear(year)) {
				sum++;
			}
		}
		sum += day - 1; // remove the starting day 01/01/1971
		return sum;
	}

	private boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
}
