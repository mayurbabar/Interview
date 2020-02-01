// https://leetcode.com/discuss/interview-question/436073/


//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

//CLASS BEGINS, THIS CLASS IS REQUIRED
public class CriticalRouters {

	public static void main(String[] args) {
	    CriticalRouters obj = new CriticalRouters();

	    int numRouters1 = 7;
	    int numLinks1 = 7;
	    ArrayList<ArrayList<Integer>> links1 = new ArrayList<>();
	    links1.add(new ArrayList<Integer>() {{add(0); add(1);}});
	    links1.add(new ArrayList<Integer>() {{add(0); add(2);}});
	    links1.add(new ArrayList<Integer>() {{add(1); add(3);}});
	    links1.add(new ArrayList<Integer>() {{add(2); add(3);}});
	    links1.add(new ArrayList<Integer>() {{add(2); add(5);}});
	    links1.add(new ArrayList<Integer>() {{add(5); add(6);}});
	    links1.add(new ArrayList<Integer>() {{add(3); add(4);}});


	    List<Integer> res = obj.criticalRouters(numRouters1, numLinks1, links1);

	    for(int i: res) System.out.print(i + " ");
	    System.out.println();

	    int numRouters2 = 5;
	    int numLinks2 = 5;
	    ArrayList<ArrayList<Integer>> links2 = new ArrayList<>();
	    links2.add(new ArrayList<Integer>() {{add(1); add(2);}});
	    links2.add(new ArrayList<Integer>() {{add(0); add(1);}});
	    links2.add(new ArrayList<Integer>() {{add(2); add(0);}});
	    links2.add(new ArrayList<Integer>() {{add(0); add(3);}});
	    links2.add(new ArrayList<Integer>() {{add(3); add(4);}});

	    List<Integer> res2 = obj.criticalRouters(numRouters2, numLinks2, links2);
	    for(int i: res2) System.out.print(i + " ");
	    System.out.println();

	    int numRouters3 = 4;
	    int numLinks3 = 4;
	    ArrayList<ArrayList<Integer>> links3 = new ArrayList<>();
	    links3.add(new ArrayList<Integer>() {{add(0); add(1);}});
	    links3.add(new ArrayList<Integer>() {{add(1); add(2);}});
	    links3.add(new ArrayList<Integer>() {{add(+2); add(3);}});

	    List<Integer> res3 = obj.criticalRouters(numRouters3, numLinks3, links3);
	    for(int i: res3) System.out.print(i + " ");
	    System.out.println();

	    int numRouters4 = 7;
	    int numLinks4 = 8;
	    ArrayList<ArrayList<Integer>> links4 = new ArrayList<>();
	    links4.add(new ArrayList<Integer>() {{add(0); add(1);}});
	    links4.add(new ArrayList<Integer>() {{add(0); add(2);}});
	    links4.add(new ArrayList<Integer>() {{add(1); add(2);}});
	    links4.add(new ArrayList<Integer>() {{add(1); add(3);}});
	    links4.add(new ArrayList<Integer>() {{add(1); add(4);}});
	    links4.add(new ArrayList<Integer>() {{add(1); add(6);}});
	    links4.add(new ArrayList<Integer>() {{add(3); add(5);}});
	    links4.add(new ArrayList<Integer>() {{add(4); add(5);}});

	    List<Integer> res4 = obj.criticalRouters(numRouters4, numLinks4, links4);
	    for(int i: res4) System.out.print(i + " ");
	    System.out.println();
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	List<Integer> criticalRouters(int numRouters, int numLinks, ArrayList<ArrayList<Integer>> links) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		List<Integer> criticalRouters = new ArrayList<>();
		
		if (numRouters == 0 || links == null)
			return criticalRouters;

		for (int i = 0; i < numRouters; i++) {
			adjList.add(new ArrayList<>());
		}

		formAdjListFromEdges(links, adjList);

		for (int i = 0; i < numRouters; i++) {

			ArrayList<Integer> tempList = new ArrayList<Integer>(adjList.get(i));

			if (tempList.size() == 0)
				continue;

			int startNode = tempList.get(0);

			removeNodeConnectionsFromGraph(i, adjList);
			HashSet<Integer> visitedNodes = new HashSet<>();

			dfs(startNode, adjList, new ArrayList<Integer>(), visitedNodes);

			if (visitedNodes.size() < numRouters - 1) {
				criticalRouters.add(i + 1);
			}

			addNodeConnectionsToGraph(i, tempList, adjList);
		}

		return criticalRouters;
	}

	void addNodeConnectionsToGraph(int node, ArrayList<Integer> neighbourNodes, ArrayList<ArrayList<Integer>> adjList) {
		for (int adjNode : neighbourNodes) {
			adjList.get(adjNode).add(node);
		}

		adjList.get(node).addAll(neighbourNodes);
	}

	void formAdjListFromEdges(ArrayList<ArrayList<Integer>> links, ArrayList<ArrayList<Integer>> adjList) {
		for (List<Integer> list : links) {
			int u = list.get(0);
			int v = list.get(1);

//			adjList.get(u - 1).add(v - 1);
//			adjList.get(v - 1).add(u - 1);
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
	}

	void removeNodeConnectionsFromGraph(int node, ArrayList<ArrayList<Integer>> adjList) {
		for (int adjNode : adjList.get(node)) {
			adjList.get(adjNode).remove(Integer.valueOf(node));
		}

		adjList.get(node).clear();
	}

	void dfs(int node, ArrayList<ArrayList<Integer>> adjList, List<Integer> visited, HashSet<Integer> visitedOrder) {

		if (visited.contains(node)) {
			return;
		}

		visitedOrder.add(node);
		visited.add(node);

		for (Integer adjNode : adjList.get(node)) {
			dfs(adjNode, adjList, visited, visitedOrder);
		}

		visited.remove(Integer.valueOf(node));
	}
	// METHOD SIGNATURE ENDS
}
