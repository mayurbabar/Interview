// A sequence of n numbers (n < 3000) is called Jolly Jumper if the absolute values of the differences 
// between the successive elements take on all possible values from 1 through n-1. 
// The definition implies that any sequence of a single integer is a jolly jumper.

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class Jolly {

	public static void main(String[] args) {
		int[] arr1 = {1,4,2,3};
		int[] arr2 = {1,4,2,-1,6};
		int[] arr3 = {11,7,4,2,1,6};
		int[] arr4 = {5,1,4,2,-1,6};
		int[] arr5 = {4,1,4,2,3};
		
		System.out.println(isJolly(arr1));  //true
		System.out.println(isJolly(arr2));  //false
		System.out.println(isJolly(arr3));  //true
		System.out.println(isJolly(arr4));  //false
		System.out.println(isJolly(arr5));  //false
	}
	
	public static boolean isJolly(int arr[])
	{
		List<Integer> listResults = new ArrayList<Integer>();
        for (int i = 0; i < arr.length - 1; i++) {
            int result = Math.abs(arr[i] - arr[i + 1]);
            if (result == 0) {
                return false;
            }
            if (result >= arr.length) {
                return false;
            }
            if (listResults.contains(result)) {
                return false;
            }
            listResults.add(result);
        }
        return true;
		/*
		boolean result = false;
		int diff = 0;
		int[] Arrdiff = new int[arr.length-1];
		
		for (int i = 0; i < arr.length-1; i++) {
			diff = Math.abs(arr[i] - arr[i+1]);
			//System.out.println(diff);
			if(diff > arr.length-1 || diff ==0)
			{
				result = false;
				break;
			}
			
			Arrdiff[i]=diff;
		}
		
		Arrays.sort(Arrdiff);
		
		/*
		System.out.println("Diff Array is :");
		for (int i = 0; i < Arrdiff.length; i++) {
			System.out.print(Arrdiff[i]);
		}
		///
		
		for (int i = 0; i < Arrdiff.length; i++) {
			if(i+1 == Arrdiff[i])
			{
				result = true;
			}
			else
			{
				result = false;
				break;
			}
		}
		
		return result;
		*/
	}

}
