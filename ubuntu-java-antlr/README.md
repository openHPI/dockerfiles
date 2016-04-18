Dockerfile for testing using ANTLR generated parser

For use:
1. Remember to add "AntlrMain.java" file to the workspace. This sets up iterators for the parse-tree of the submitted codes that need to be analyzed. Change <SubjectFileToTest> in this file to the corresponding path to the source file to be tested.

2. Provide Java8Rules class which needs to be an implementation of Java8Listener interface or an extension of Java8BaseListener.
