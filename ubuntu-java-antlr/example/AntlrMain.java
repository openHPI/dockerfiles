import static org.junit.Assert.*;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import antlrstuff.Java8Lexer;
import antlrstuff.Java8Listener;
import antlrstuff.Java8Parser;

//Teaching Team tests the participants' implementation and the participants' tests
public class AntlrMain {
	
	Java8Listener jbl = new Java8Rules();
	private static ArrayList<String> failedTests;
	
	//the participants' implementation can be accessed in a regular way as it has to implement our interface
	MyClassUnderTest mcut;
	//the participants' Tests are accessed via Reflection to allow more freedom
	Class<?> c;
	Object t;
	
	private static ANTLRInputStream input;
	private static Java8Lexer lexer;
	private static CommonTokenStream tokens;
	private static Java8Parser parser;
	private static ParseTree tree;
	private static ParseTreeWalker walker;
	
	@BeforeClass
	public static void setupClass() {
		
		try {
			input = new ANTLRInputStream(new FileInputStream("/workspace/MyTestClass.java"));
			lexer = new Java8Lexer(input);
			tokens = new CommonTokenStream(lexer);
			parser = new Java8Parser(tokens);
			tree = parser.compilationUnit();
			walker = new ParseTreeWalker();
			failedTests = new ArrayList<>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	@Before
	public void setup() {
		mcut = new MyClassUnderTest();
		try {
			c = Class.forName("MyTestClass");
			t = c.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//testing the participants' implementation
	@Test
	public void testAdd() {
		assertEquals(3, mcut.add(1, 2));
		assertEquals(0, mcut.add(0, 0));
		assertEquals(-1, mcut.add(-2, 1));
		assertEquals(-1, mcut.add(1, -2));
		assertEquals(-4, mcut.add(-2, -2));
	}
	
	@Test
	public void testMultiply() {
		assertEquals(2, mcut.multiply(1, 2));
		assertEquals(0, mcut.multiply(0, 0));
		assertEquals(0, mcut.multiply(0, 2));
		assertEquals(-2, mcut.multiply(-2, 1));
		assertEquals(-2, mcut.multiply(1, -2));
		assertEquals(4, mcut.multiply(-2, -2));
	}
	
	//running the participants' tests
	@Test
	public void runTheirTests() {
		
		Method[] allMethods = c.getDeclaredMethods();
		
		for (Method m : allMethods) {
			try {
				//check if we need to call After, BeforeClass, AfterClass, etc. as well
				if (m.isAnnotationPresent(Before.class) || m.isAnnotationPresent(Test.class)){
					m.invoke(t);
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				fail("Assertion failed: " + e.getCause().getMessage());
			}
		}
	}
	
	//check if they at least have called our implementation's methods
	@Test
	public void testMethodsCalled() {
		for (String key : OurClassUnderTest.getCalled().keySet()) {
			assertTrue("Method: " + key + " was not tested", OurClassUnderTest.getCalled().get(key));
		}
	}
	
	@Test
	public void testTheirMethodsContainAssertions() throws TestFailedException {
		walker.walk(jbl, tree);
		
		for (String key : Java8Rules.getRules().keySet()) {
			try {
				assertTrue("Method: " + key + " contains no assertions", Java8Rules.getRules().get(key) > 0);
			} catch (AssertionError e) {
				failedTests.add(e.getMessage());
			}
		}
		
		if (! failedTests.isEmpty()) {
			throw new TestFailedException(failedTests);
		}
	}
}