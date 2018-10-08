@ECHO "run > make.bat"
javac .\src\*.java -d .\out\
jar -cvf .\out\App.jar .\out\*.class
java -cp .\out\ App