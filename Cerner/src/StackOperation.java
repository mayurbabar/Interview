import java.util.ArrayList;
import java.util.List;

public class StackOperation {

	public static void main(String[] args) {
		stacks stk = new stacks();

		stk.push(0);
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		System.out.println("POP in progress");
		
		stk.pop();
		stk.pop();
		stk.pop();
		
	}

}

class stacks{
	private List<Integer> stacks1 = new ArrayList<Integer>();
	
	public void push(int num)
	{
		stacks1.add(num);
		System.out.println(stacks1);
	}
	
	public void pop()
	{
		stacks1.remove(stacks1.size()-1);
		System.out.println(stacks1);
	}
}


