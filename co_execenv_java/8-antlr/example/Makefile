run:
	@javac -encoding utf8 Main.java
	@java Main
	exit

test:
	javac -encoding utf8 -cp ".:/usr/java/lib/hamcrest-core-1.3.jar:/usr/java/lib/junit-4.11.jar:/usr/local/lib/antlr-4.5-complete.jar:/usr/java/lib/antlr-java8.jar:$CLASSPATH" *.java

	java -cp ".:/usr/java/lib/hamcrest-core-1.3.jar:/usr/java/lib/junit-4.11.jar:/usr/java/lib/antlr-java8.jar:/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH" org.junit.runner.JUnitCore AntlrMain