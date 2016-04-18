import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import antlrstuff.*;
//import work.*;

//Teaching Team tests the participants' implementation and the participants' tests
public class AntlrMain {
	
	private static Java8Listener jbl = new Java8Rules();
	
	//the participants' implementation can be accessed in a regular way as it has to implement our interface
	MyClassUnderTest mcut;
	//the participants' Tests are accessed via Reflection to allow more freedom
	Class<?> c;
	Object t;
	
	private static ANTLRInputStream input;
	private static Java8Lexer lexer;
	private static CommonTokenStream tokens;
	private static Java8Parser parser;
	private static ParserRuleContext tree;
	private static ParseTreeWalker walker;
	
	@BeforeClass
	public static void setupClass() {
		
		try {
			input = new ANTLRInputStream(new FileInputStream("<SubjectFileToTest>"));
			lexer = new Java8Lexer(input);
			tokens = new CommonTokenStream(lexer);
			parser = new Java8Parser(tokens);
			tree = parser.compilationUnit();
			walker = new ParseTreeWalker();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Test
	public void testTheirMethodsContainAssertions() {
		walker.walk(jbl, tree);
	}
	



}

