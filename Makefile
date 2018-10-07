all: run

compile:

	clear

	@echo "Project directory: "`pwd`
	@echo "";
	
	@# Compile --------------------------------

		@echo "> Compiling..."
		@echo "All source code"
		@echo "From: [./src/] to: [./out/]"

			javac ./src/*.java -d ./out/;
		
			wc -c ./out/*.class

		@echo "DONE Compiled!"

	@# ----------------------------------------
	@echo "";

compact: 
	@# Compact

		@echo "> Compacting..."
		jar -cvf ./out/App.jar ./out/*.class
		@echo "DONE Compactated!"

	@# ----------------------------------------
	@echo "";

test:
	@# Test

		jar tf ./out/App.jar

	@# ----------------------------------------
	@echo "";

run: compile compact
	@# Run

		@echo "> Starting..."
		@echo "";
			
			java -cp ./out App

	@# ----------------------------------------
	@echo "";

clean:
	@# Remove files

		@echo "> Cleaning..."
		@echo "All binary code from [./out/]"
		@rm -f ./out/*.class ./out/*.jar 
		@echo "DONE Clean!"

	@# ----------------------------------------
	@echo "";