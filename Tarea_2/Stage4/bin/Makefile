JC = javac
JM = java
MAIN = start
RM = rm
CLASES = *.class

CLASSES = \
Stage4.java \
ShadeControlView.java \
ShadeControl.java \
RollerShadeView.java \
RollerShade.java \
LampView.java \
LampState.java \
LampControlView.java \
LampControl.java \
Lamp.java \
DomoticDeviceControl.java \
DomoticDevice.java \
Cloud.java \
ButtonIcon.java 

default: compile

compile:
	$(JC) $(CLASSES) --module-path C:/Users/iwaya/Desktop/Code/javafx-sdk-18.0.1/lib --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.web

run:
	$(JM) $(MAIN)

clean:
	$(RM) $(CLASES)