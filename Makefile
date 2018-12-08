#!/bin/sh

# Paths
SRC_PATH="./src/"
OUT_PATH="./out/"
LIB_PATH="./lib/"

# Library files
LIB1="json-simple-1.1.jar"

# Main Files
JAR_FILE="App.jar"                 # Final Jar name
MAIN_CLASS="JsonSimpleWriteExample" # Class with method main()

all: run

compile:

	clear

	@echo "Project directory: "`pwd`
	@echo "";
	
	@# Compile --------------------------------

		@echo "> Compiling..."
		@echo "All source code"
		@echo "From: [$(SRC_PATH)] to: [$(OUT_PATH)]"

			javac -classpath $(LIB_PATH)$(LIB1) $(SRC_PATH)*.java -d $(OUT_PATH);
		
			wc -c $(OUT_PATH)*.class

		@echo "DONE Compiled!"

	@# ----------------------------------------
	@echo "";

compact: 
	@# Compact

		@echo "> Compacting..."

			jar -cvf $(OUT_PATH)$(JAR_FILE) $(OUT_PATH)*.class

		@echo "DONE Compactated!"

	@# ----------------------------------------
	@echo "";

test:
	@# Test

		jar tf $(OUT_PATH)$(JAR_FILE)

	@# ----------------------------------------
	@echo "";

run: compile compact
	@# Run

		@echo "> Starting..."
		@echo "";
			
			java -cp $(OUT_PATH) $(MAIN_CLASS)

	@# ----------------------------------------
	@echo "";

clean:
	@# Remove files

		@echo "> Cleaning..."
		@echo "All binary code from [$(OUT_PATH)]"

			@rm -f $(OUT_PATH)*.class $(OUT_PATH)*.jar 
			
		@echo "DONE Clean!"

	@# ----------------------------------------
	@echo "";