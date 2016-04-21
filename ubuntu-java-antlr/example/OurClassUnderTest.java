import java.util.HashSet;

//Our reference implementation
//the participants' tests have to be run against our implementation not theirs 
public class OurClassUnderTest implements OurInterface {

	private static HashSet<String> called = new HashSet<String>();
	public static boolean TESTCRUSHER = false;
	
	public static HashSet<String> getCalled() {
		return called;
	}
	
	public int add(int a, int b) {
		called.add("add");
		int result;
		if (TESTCRUSHER) {
			result = a + b + 1;
		} else {
			result = a + b;
		}
		return result;
	}
	
	public int multiply(int a, int b) {
		called.add("multiply");
		int result;
		if (TESTCRUSHER) {
			result = a * b + 1;
		} else {
			result = a * b;
		}
		return result;
	}
}

