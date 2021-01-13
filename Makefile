d:
	rm -f *.class;
	javac *.java && clear && java main

clear:
	rm -f *.class

b:
	rm -f *.class;
	javac *.java -g && jdb main
