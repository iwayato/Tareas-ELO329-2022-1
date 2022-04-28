JC = javac
JM = java
MAIN = Stage1
INPUTFILE = configuration.txt
OUTPUT = > output.csv
RM = rm
CLASES = *.class

CLASSES = \
Stage1.java \
Cloud.java \
Lamp.java \
LampControl.java \
LampState.java \
Operator.java

default: compile

compile:
	$(JC) $(CLASSES)

run:
	$(JM) $(MAIN) $(INPUTFILE) $(OUTPUT)

clean:
	$(RM) $(CLASES)