package design;

import java.util.List;

class Test2 {
	int id;
	static int idn = 0;
	String name;
	
	Test2()
	{
		System.out.println("Test2 constructor called.");
	}
	
	Test2(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public void display()
	{
		System.out.println("From class Test2");
		System.out.println("Id: " + id + " Name: " + name);
	}

	public static void main(String[] args) {
		Test2 test = new Test2(3, "Sam");
		double db = 0.00;
		
		test.display();
		
	}

}

//class Test extends Test2{
class Test extends abs{
	
	Test()
	{
		System.out.println("Test constructor called.");
	}
	
	/*
	public void display()
	{
		System.out.println("From class Test");
		System.out.println("Id: " + this.id + " Name: " + this.name);
	}
	
	public static void main(String[] args)
	{
		Test objs = new Test();
		objs.id = 1;
		objs.name = "Daniel";
		objs.display();
		
	}
	*/
	
	public static void main(String[] args){
		Test t1 = new Test();
		
		t1.testing();
		String str1 = "123";
		String str2 = "456";
		String res = str1+str2;
		
		System.out.println(res.equals("123456"));
		
		str2 = str2.concat("789");
		//System.out.println(str2.contains("79"));
	}
}

abstract class abs{
	private List<String> address;
	
	abs(){
		System.out.println("abs constructor initiated");
	}
	
	void testing()
	{
		System.out.println("Testing function initiated");
		this.address.add("1");
	}
}