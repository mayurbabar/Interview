import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NearestDelivery {

	static ArrayList<int[]> routeOptimiser(final int numDestination, final ArrayList<int[]> destinationList, final int numDeliveries) 
	{
		final HashMap<int[], Double> destinationDistanceMap = new HashMap<>();
		final HashMap<int[], Integer> sameDestinationDistanceMap = new HashMap<>();
		final ArrayList<int[]> optimumDestinations = new ArrayList<int[]>();
		double distance = 0;
		
		for (final int[] destination : destinationList) {
			distance = Math.sqrt((destination[0]*destination[0]) + (destination[1]*destination[1]));
			
			if(destinationDistanceMap.containsKey(destination)){
				if(sameDestinationDistanceMap.containsKey(destination))
					sameDestinationDistanceMap.put(destination, sameDestinationDistanceMap.get(destination)+1);
				else
					sameDestinationDistanceMap.put(destination, 1);
			}
			else
				destinationDistanceMap.put(destination, distance);
		}
		
		final Map<int[], Double> sortedDestinationMap = destinationDistanceMap
		        .entrySet()
		        .stream()
		        .sorted(comparingByValue())
		        .collect(
		            toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
		                LinkedHashMap::new));
		
		for (final int[] key : sortedDestinationMap.keySet()){
			if(optimumDestinations.size()<numDeliveries){
				if(sameDestinationDistanceMap.containsKey(key))
				{
					for (int i = 0; i < sameDestinationDistanceMap.get(key); i++) {
						optimumDestinations.add(key);
					}
				}
				else
					optimumDestinations.add(key);
			}
	    }
		return optimumDestinations; 
	} 
	  
	// Driver Code 
	public static void main(final String args[]) 
	{ 
	    final ArrayList<int[]> destinationList1 = new ArrayList<>();
	    destinationList1.add(new int[]{1,2});
	    destinationList1.add(new int[]{3,4});
	    destinationList1.add(new int[]{1,-1});
	    
	    final ArrayList<int[]> destinationList2 = new ArrayList<>();
	    destinationList2.add(new int[]{1,2});
	    destinationList2.add(new int[]{0,4});
	    destinationList2.add(new int[]{4,0});
	    
	    final ArrayList<int[]> destinationList3 = new ArrayList<>();
	    destinationList3.add(new int[]{1,2});
	    destinationList3.add(new int[]{0,4});
	    destinationList3.add(new int[]{0,4});
	    destinationList3.add(new int[]{4,5});
	    
	    final int numDestination1 = 3;
	    final int numDestination2 = 3;
	    final int numDestination3 = 4;
	    
	    final int numDeliveries1 = 2;
	    final int numDeliveries2 = 2;
	    final int numDeliveries3 = 3;
	    
	    final ArrayList<int[]> result1 = routeOptimiser(numDestination1, destinationList1, numDeliveries1);
	    final ArrayList<int[]> result2 = routeOptimiser(numDestination2, destinationList2, numDeliveries2);
	    final ArrayList<int[]> result3 = routeOptimiser(numDestination3, destinationList3, numDeliveries3);
	    
	    System.out.println("Result for Example 1");
	    for (final int[] route : result1) {
			System.out.print("["+route[0]+","+route[1]+"] ");
		}
	    System.out.println();
	    
	    System.out.println("Result for Example 2");
	    for (final int[] route : result2) {
			System.out.print("["+route[0]+","+route[1]+"] ");
		}
	    System.out.println();
	    
	    System.out.println("Result for Example 3");
	    for (final int[] route : result3) {
			System.out.print("["+route[0]+","+route[1]+"] ");
		}
	} 
} 