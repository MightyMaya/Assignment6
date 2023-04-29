@echo off
javac *.java
echo We will run the 3 cases
echo 1st is normal case and file name is example.arxml
java Main example.arxml
echo 2nd is Not valid Autosar file case and file name is test.c
java Main test.c
echo 3rd is Empty file case and file name is test.arxml
java Main test.arxml
pause