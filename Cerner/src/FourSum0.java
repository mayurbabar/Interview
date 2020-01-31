import java.util.*;

public class FourSum0 {

	public static void main(String[] args) {
		int A[] = {1, 0, -1, 0, -2, 2};
		int B[] = {1,4,-1,2,-4};
		int C[] = {2,3,1,0,-4,-1};
		int D[] = {0,-1,3,-2};
		
		System.out.println(D);
		System.out.println(find4Numbers(A, 0));  //3
		System.out.println(find4Numbers(B, 0));  //1
		System.out.println(find4Numbers(C, 0));  //2
		System.out.println(find4Numbers(D, 0));  //1
	}

	public static int find4Numbers(int[] numbers, int target) 
    {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int count = 0;

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 3; i++) {
            for (int j = i + 1; j < numbers.length - 2; j++) {
                int left = j + 1;
                int right = numbers.length - 1;

                while (left < right) {
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (sum == target) {
                        ArrayList<Integer> tuple = new ArrayList<>();
                        tuple.add(numbers[i]);
                        tuple.add(numbers[j]);
                        tuple.add(numbers[left]);
                        tuple.add(numbers[right]);
                        if (!result.contains(tuple)) {
                            result.add(tuple);
                            count++;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return count;
    }
}
