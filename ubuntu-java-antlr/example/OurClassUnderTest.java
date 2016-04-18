import java.util.HashMap;

//Our reference implementation
//the participants' tests have to be run against our implementation not theirs 
public class OurClassUnderTest implements OurInterface {

	private static HashMap<String, Boolean> called;
	
	public static HashMap<String, Boolean> getCalled() {
		return called;
	}
	
	public OurClassUnderTest() {
		called = new HashMap<String, Boolean>();
		called.put("add", false);
		called.put("multiply", false);
	}
	
	public int add(int a, int b) {
		called.put("add", true);
		return a + b;
	}
	
	public int multiply(int a, int b) {
		called.put("multiply", true);
		return a * b;
	}
	
	
}
