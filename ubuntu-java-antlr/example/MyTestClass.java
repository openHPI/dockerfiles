import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

//The participants' test class
//tests our reference implementation not their own
public class MyTestClass {
	
	OurClassUnderTest ocut;
	
	@Before
	public void setup() {
		ocut = new OurClassUnderTest();
	}
	
	private void helper() {
		
	}

	@Test
	public void testAdd() {
		assertEquals(3, ocut.add(1, 2));
		assertEquals(0, ocut.add(0, 0));
		assertEquals(-1, ocut.add(-2, 1));
		assertEquals(-1, ocut.add(1, -2));
		assertEquals(-4, ocut.add(-2, -2));
		helper();
	}
	
	@Test
	public void testShouldFail() {
		
	}
	
	@Test
	public void testMultiply() {
		ocut.multiply(1, 2);
		assertEquals(2, ocut.multiply(1, 2));
	}
	
	@Test
	public void testShouldFailAsWell() {
		
	}
	
	@Test
	public void testShouldPass() {
		assertEquals(3, ocut.add(1, 2));
	}
	
	
}