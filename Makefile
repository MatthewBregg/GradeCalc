all: CalcCalc.java
	javac CalcCalc.java
	jar cmf mainclass.txt CalcCalc.jar *.class
	rm ./*.class
