JFLAGS = -g
JC = javac

default:
	$(JC) $(JFLAGS) *.java

clean:
	$(RM) *.class
