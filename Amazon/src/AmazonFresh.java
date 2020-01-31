import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class AmazonFresh {

	static List<List<Integer>> closestXdestinations(final int numDestinations, final List<List<Integer>> allLocations,
			final int numDeliveries) {
		final Map<List<Integer>, Double> nDestinations = new HashMap<>();
		final Map<List<Integer>, Integer> countDestinations = new HashMap<>();
		
		for (final List<Integer> location : allLocations) {
			final double x = location.get(0);
			final double y = location.get(1);
			
			nDestinations.put(location, Math.sqrt((x * x) + (y * y)));
			countDestinations.put(location, countDestinations.getOrDefault(location, 0) + 1);
		}

		final Map<List<Integer>, Double> sortedMap = nDestinations.entrySet().stream().sorted(comparingByValue())
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
		
		final List<List<Integer>> nearestNdestinations = new ArrayList<>();
		
		for (final List<Integer> destination : sortedMap.keySet()) {
			for (int j = 0; j < countDestinations.get(destination); j++) {
				nearestNdestinations.add(destination);
				if (nearestNdestinations.size() == numDeliveries) {
					return nearestNdestinations;
				}
			}
		}
		return nearestNdestinations;
	}

	// Driver Code
	public static void main(final String args[]) {
		final List<List<Integer>> destinationList1 = new ArrayList<List<Integer>>();
		destinationList1.add(Arrays.asList(1, 2));
		destinationList1.add(Arrays.asList(3, 4));
		destinationList1.add(Arrays.asList(1, -1));

		final List<List<Integer>> destinationList2 = new ArrayList<List<Integer>>();
		destinationList2.add(Arrays.asList(1, 2));
		destinationList2.add(Arrays.asList(0, 4));
		destinationList2.add(Arrays.asList(4, 0));

		final List<List<Integer>> destinationList3 = new ArrayList<List<Integer>>();
		destinationList3.add(Arrays.asList(1, 2));
		destinationList3.add(Arrays.asList(0, 4));
		destinationList3.add(Arrays.asList(0, 4));
		destinationList2.add(Arrays.asList(4, 5));

		final int numDestination1 = 3;
		final int numDestination2 = 3;
		final int numDestination3 = 4;

		final int numDeliveries1 = 2;
		final int numDeliveries2 = 2;
		final int numDeliveries3 = 3;

		System.out.println("Result1: " + closestXdestinations(numDestination1, destinationList1, numDeliveries1));
		System.out.println("Result2: " + closestXdestinations(numDestination2, destinationList2, numDeliveries2));
		System.out.println("Result3: " + closestXdestinations(numDestination3, destinationList3, numDeliveries3));

	}
}