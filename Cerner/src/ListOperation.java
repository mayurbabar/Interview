import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOperation {

	public static void main(String[] args) {
		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();
		
		first = Arrays.asList(10,1,2,3,4,5,6,7,8,9);
		second = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		
		findMinMax(first, second); //9 10
		
	}
	
	public static void findMinMax(List<Integer> first, List<Integer> second)
	{
		int x = first.get(0);
        int y = second.get(second.size()-1);
        
        if (x == y)
        { 
        	System.out.println(x);
        }
        else if (x < y)
        {
            System.out.println(x);
            System.out.println(y);
        }
        else
        {
        	System.out.println(y);
            System.out.println(x);
        }
	}

}
