Dockerfile for testing using ANTLR generated parser

For use:

1. Add "AntlrMain.java" (like AntlrMain.java.template) file to the workspace. This sets up iterators for the parse-tree of the submitted codes that need to be analyzed. Change <SubjectFileToTest> in this file to the corresponding path to the source file to be tested.
2. Provide Java8Rules class (like Java8Rules.java.template) containing all the rules to check using Java8Listener interface (or the Java8BaseListener class).
