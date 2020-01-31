import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class optimalUti {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	List<List<Integer>> optimalUtilization(final int deviceCapacity, final List<List<Integer>> foregroundAppList,
		final List<List<Integer>> backgroundAppList) {
		final List<List<Integer>> optimumRoute = new ArrayList<>();
		int optimalCapacity = 0;

		for (final List<Integer> foregroundApp : foregroundAppList) {
			for (final List<Integer> backgroundApp : backgroundAppList) {
				final int sum = foregroundApp.get(1) + backgroundApp.get(1);
				if (sum <= deviceCapacity) {
					if (sum > optimalCapacity) {
						optimalCapacity = sum;
						optimumRoute.clear();
						optimumRoute.add(Arrays.asList(foregroundApp.get(0), backgroundApp.get(0)));
					} else if (sum == optimalCapacity) {
						optimumRoute.add(Arrays.asList(foregroundApp.get(0), backgroundApp.get(0)));
					}
				}
			}
		}
		return optimumRoute;
	}

}
