import java.util.HashSet;

//Our reference implementation
//the participants' tests have to be run against our implementation not theirs 
public class OurClassUnderTest implements OurInterface {

	private static HashSet<String> called = new HashSet<String>();
	
	public static HashSet<String> getCalled() {
		return called;
	}
	
	public int add(int a, int b) {
		called.add("add");
		return a + b;
	}
	
	public int multiply(int a, int b) {
		called.add("multiply");
		return a * b;
	}
}

