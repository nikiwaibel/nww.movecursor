JAVAC = javac
JAVACFLAGS = -source 1.6 -target 1.6

MoveCursor.class: MoveCursor.java
	$(JAVAC) $(JAVACFLAGS) $<

.PHONY: clean

clean:
	rm -rf MoveCursor.class
