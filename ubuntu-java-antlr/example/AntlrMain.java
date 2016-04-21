import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;

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
import org.junit.After;

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
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}


	@Before
	public void setup() {
		mcut = new MyClassUnderTest();
		failedTests = new ArrayList<>();
		try {
			c = Class.forName("MyTestClass");
			t = c.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
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
	public void runTheirTests() throws TestFailedException {	
		runTheirTestsHelper(false);
		runTheirTestsHelper(true);
		
		testMethodsCalledHelper();
		
		if (! failedTests.isEmpty()) {
			throw new TestFailedException(failedTests);
		}
	}
	
	public void runTheirTestsHelper(boolean crush) {
		
		Method[] allMethods = c.getDeclaredMethods();
		ArrayList<Method> beforeClassMethods = new ArrayList<>();
		ArrayList<Method> beforeMethods = new ArrayList<>();
		HashMap<Method, Boolean> testMethods = new HashMap<>();
		ArrayList<Method> afterMethods = new ArrayList<>();
		
		for (Method m : allMethods) {
				if (m.isAnnotationPresent(BeforeClass.class)){
					beforeClassMethods.add(m);
				} else if (m.isAnnotationPresent(Before.class)){
					beforeMethods.add(m);
				} else if (m.isAnnotationPresent(Test.class)){
					testMethods.put(m, false);
				} else if (m.isAnnotationPresent(After.class)){
					afterMethods.add(m);
				} 
				
		}
		
		// call before class methods once
		for(Method bcm : beforeClassMethods){
			try {
				bcm.invoke(t);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		OurClassUnderTest.CRUSHTESTS = crush;
		
		// run all tests
		for(Method tm : testMethods.keySet()) {			
				for(Method bm : beforeMethods) {
					try {
						bm.invoke(t);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}

				try{
					tm.invoke(t);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					testMethods.put(tm, true);
				}			
					
				for(Method am : afterMethods) {
					try {
						am.invoke(t);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
				
				if (crush) {
					if (! testMethods.get(tm)) {
						failedTests.add("Method: " + tm.getName() + " succeeded when it should fail.");
					}
				} else {
					if (testMethods.get(tm)) {
						failedTests.add("Method: " + tm.getName() + " failed when it should succeed.");
					}
				}
		}
	}

	//check if they at least have called our implementation's methods
	public void testMethodsCalledHelper() {
		Method[] methodsToBeCalled = OurInterface.class.getDeclaredMethods();

		for (Method im : methodsToBeCalled) {
			if(!OurClassUnderTest.getCalled().contains(im.getName())){
				failedTests.add("Method: " + im.getName() + " was not called.");	
			}
			
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