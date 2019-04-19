# ISTE 422 Group Project

## Building and Testing the project:

To Build and Test the code please run the following command from the root of this repository:
*Note: While running the JUnit tests a GUI will display. Click CANCEL in the first GUI and OK on the 2nd GUI to pass the test successfully."*

If on windows run:
```
gradlew clean build
```

If on Linux/Mac run:
```
gradle clean build -x validateTaskProperties
```

If you are unable to run the command please make sure that the gradlew file is executable by running:
```
chmod +x gradlew
```

After the application is built go to the build/libs directory and run the following command:
```
chmod +x ISTE-422_group-project.jar
```

To run the application double click the jar located in the build/libs directory

or you can run the following command from the build/libs directory
```
java -jar ISTE-422_group-project.jar
```

The test results can be viewed here:
```
build\reports\tests\test\index.html
```