# ISTE 422 Group Project. EX07

## Building and Testing Ex07:

To Run Ex 07 run the following command:
```
./gradlew clean object test
```
This will use the default test objects but you can pass in different ones with the following options below

optional flags:
- -P-h : This displays the help messages in the console.

Example:
```
./gradlew clean object test -P-h
```
- -P-f : This allows you to insert a file with comma separted values where each line is a object and the first value is the name of the test which the object applies to:

Example:
```
./gradlew clean object test -P-f=test.txt
```
- -P-n : This allows you to insert a comma separated object into the command line. Each object must have the test name as the first value of the object. You can also define multiple objects by seperating them with the ^ symbol:

Example:
```
./gradlew clean object test -P-n=EdgeTableTest,1|test4, 1, 2
```