import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AircraftOptimiser {

	static List<List<Integer>> routeOptimiser(final int maxTravelDistance, final List<List<Integer>> forwardRouteList, final List<List<Integer>> returnRouteList) 
	{
		final List<List<Integer>> optimumRoute = new ArrayList<>();
		int max = 0;
		
		for (final List<Integer> forwardStation : forwardRouteList) {
			for (final List<Integer> returnStation : returnRouteList) {
				final int sum = forwardStation.get(1) + returnStation.get(1);
				if (sum <= maxTravelDistance){
					if (sum > max) {
						max = sum;
						optimumRoute.clear();
						optimumRoute.add(Arrays.asList(forwardStation.get(0), returnStation.get(0)));
					}
					else if (sum == max)
						optimumRoute.add(Arrays.asList(forwardStation.get(0), returnStation.get(0)));
				}
			}	 
		}
		return optimumRoute; 
	} 
	  
	// Driver Code 
	public static void main(final String args[]) 
	{ 
	    final List<List<Integer>> forwardRouteList1 = new ArrayList<>();
	    forwardRouteList1.add(Arrays.asList(1,2000));
	    forwardRouteList1.add(Arrays.asList(2,4000));
	    forwardRouteList1.add(Arrays.asList(3,6000));
	    
	    final List<List<Integer>> forwardRouteList2 = new ArrayList<>();
	    forwardRouteList2.add(Arrays.asList(1,3000));
	    forwardRouteList2.add(Arrays.asList(2,5000));
	    forwardRouteList2.add(Arrays.asList(3,7000));
	    forwardRouteList2.add(Arrays.asList(4,10000));
	    
	    final List<List<Integer>> returnRouteList1 = new ArrayList<>();
	    returnRouteList1.add(Arrays.asList(1,2000));
	    
	    final List<List<Integer>> returnRouteList2 = new ArrayList<>();
	    returnRouteList2.add(Arrays.asList(1,2000));
	    returnRouteList2.add(Arrays.asList(2,3000));
	    returnRouteList2.add(Arrays.asList(3,4000));
	    returnRouteList2.add(Arrays.asList(4,5000));
	    
	    final List<List<Integer>> forwardRouteList3 = new ArrayList<>();
	    final List<List<Integer>> returnRouteList3 = new ArrayList<>();
	    
	    final int maxTravelDist1 = 7000;
	    final int maxTravelDist2 = 10000;
	    final int maxTravelDist3 = 0;
	    
	    System.out.println("result1: " + routeOptimiser(maxTravelDist1, forwardRouteList1, returnRouteList1));
	    System.out.println("result2: " + routeOptimiser(maxTravelDist2, forwardRouteList2, returnRouteList2));
	    System.out.println("result3: " + routeOptimiser(maxTravelDist3, forwardRouteList3, returnRouteList3));
	} 
} 