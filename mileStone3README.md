# ISTE 422 Group Project


*The following steps work for both Windows and Linux*

## Building and getting the application ready for deployment 
To prepare the application for deployment to the customer first run one of the following commands:
*Note: While running the JUnit tests a GUI will display. Click CANCEL in the first GUI and OK on the 2nd GUI to pass the test successfully."*

If on windows run:
```
gradlew clean build
```

If on Linux/Mac run:
```
./gradlew clean build
```

If you are unable to run the command please make sure that the gradlew file is executable by running:
```
chmod +x gradlew
```

After the application is build go to the build/libs directory and run the following command:
```
chmod +x ISTE-422_group-project.jar
```

The application is now ready for deployment to the customer. Upload the jar to the deployment server so the customer may download it from our website

## Running the application as a customer

As a customer consuming the application, first download our application from the company website.

After downloading the application (.jar file) simply double click the application to start the application which will now be ready for use.