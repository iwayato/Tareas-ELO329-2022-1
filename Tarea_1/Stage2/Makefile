JC = javac
JM = java
MAIN = Stage2
INPUTFILE = configuration.txt
OUTPUT = > output.tsv
RM = rm
CLASES = *.class

CLASSES = \
Stage2.java \
ShadeControl.java \
RollerShade.java \
Operator.java \
LampControl.java \
Lamp.java \
DomoticDeviceControl.java \
DomoticDevice.java \
Cloud.java

default: compile

compile:
	$(JC) $(CLASSES)

run:
	$(JM) $(MAIN) $(INPUTFILE) $(OUTPUT)

clean:
	$(RM) $(CLASES)