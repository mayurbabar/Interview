import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class BuzzWords {

	public static void main(String[] args) {
		List<String> toys = new ArrayList<>();
		toys.add("elmo");
		toys.add("elsa");
		toys.add("legos");
		toys.add("drone");
		toys.add("tablet");
		toys.add("warcraft");

		List<String> quotes = new ArrayList<>();
		quotes.add("Elmo is the hottest of the season! Elmo will be on every kid's wishlist!");
		quotes.add("The new Elmo dolls are super high quality");
		quotes.add("Expect the Elsa dolls to be very popular this year, Elsa!");
		quotes.add("Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good Drone");
		quotes.add("For parents of older kids, look into buying them a drone");
		quotes.add("Warcraft is slowly rising in popularity ahead of the holiday season Warcraft");

		System.out.println(solution(6, 3, toys, 6, quotes));

	}

	public static List<String> solution(int numToys, int topToys, List<String> toys, int numQuotes, List<String> quotes) {
		Map<String, int[]> freq = new HashMap<>();
		
		for (String toy : toys) {
			freq.put(toy, new int[] { 0, 0 });
		}

		for (String quote : quotes) {
			Set<String> used = new HashSet<>();

			String[] words = quote.split("\\W+");
			for (String word : words) {
				String wordLc = word.toLowerCase();
				if (!freq.containsKey(wordLc)) {
					continue;
				}

				int[] nums = freq.get(wordLc);

				nums[0]++;
				if (!used.contains(wordLc)) {
					nums[1]++;
				}

				used.add(wordLc);
			}
		}
		

		PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) -> {
			if (freq.get(t1)[0] != freq.get(t2)[0]) {
				return freq.get(t1)[0] - freq.get(t2)[0];
			}

			if (freq.get(t1)[1] != freq.get(t2)[1]) {
				return freq.get(t1)[1] - freq.get(t2)[1];
			}

			return t2.compareTo(t1);
		});

		for (String toy : freq.keySet()) {
			System.out.println(toy + " : "+ Arrays.toString(freq.get(toy)));
			if (freq.get(toy)[0] > 0) {
				pq.add(toy);

				System.out.println("Size: " + pq.size() + " Peek: " + pq.peek());

				if (pq.size() > topToys)
					pq.poll();
			}
		}

		List<String> output = new ArrayList<>();
		while (!pq.isEmpty()) {
			// System.out.println(pq.peek());
			output.add(pq.poll());
		}

		Collections.reverse(output);

		return output;
	}

}
