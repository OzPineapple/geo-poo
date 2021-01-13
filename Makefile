d:
	rm -f *.class;
	javac *.java && clear && java main

c:
	rm -f *.class

b:
	rm -f *.class;
	javac *.java -g && jdb main
