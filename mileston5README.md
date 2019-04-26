# ISTE 422 Group Project


To build and run the application refer to our main readme.

## Milestone 5

### Where to find output files and EDG file
You can find our main EDG file in the root directory of the project.

If you are looking for the output file definition files they are located here:
```
<rootDir>\build\classes\java\main
```

Select the build directory when prompted by the "set output file definition" or "create DDL" options

### What was changed and why

* We changed the getOutputClasses method in the EdgeConvertGui class. 
    * We set the objOutput object to a newInstance of the class used when there is no edgefile or sav file loaded
        * We did this because it was causing a null pointer exception
* We added a new property on the EdgeconvertFileParser class to know if the file is good or if its an incorrect format
    * We then used this property in the gui class to stop loading calling methods additional methods if it is not a edg or sav file
        * This was done because the program would become in a glitched state if a edge file was loaded then you tried to load bad file
* We removed a bunch of unused variables and import statments from each file
    * * It is not wise to keep unused variables and import statements for performance
* We removed a uneeded method call in the EdgeConvertGui class
    * It is not wise to keep unwanted method calls for performance
* We fixed a bunch of infered generics in each file making them the appropriate types
    * This was done because those are considered unsafe operations
* Removed variables from the MYSQL ddl class that were duplicated in the abstract class
    * We do not need the duplicate variables
* Moved the generateDatabaseName and getDatabasename methods and associated variables to the abstract class EdgeConverteCreateDDL
    * Since these methods would need to be used for all databases possibly supported it made sense to abstract the method
* Removed the Infinite loop bug that would occur if you did not set a output file format when you hit create ddl
    * This was a bad user experience which was why we removed it
* Removed the trailng ',' that would appear if you did not have a primary key or forgien key
    * Even though the case that this would actually happen is slim(since basically every table should have a primary key) we removed the trailing ',' which made the SQL invalid
* Reformatted the code since some places it had hard to read spots



### What would need to change to extend the functionality to other Databases 
To extend the functionality to create DDL's for another database they would need to create a java class for that database type which extends the EdgeConvertCreateDDL class.
Then they would need to implement the createDDL, getSQLString and getProductName classes as appropriate. They may also set the product array in the EdgeConvertCreateDDL class.


### What would need to be done to use a seperate description file
To implement a different kind of description file the user would need to create the appropriate fileParser class for that file definition. 
They would need to update the EdgeConvertGUI to check which file extension it is then create the appropriate class.
The description file would also need to have the same attributes as the edge file so that it can map each section of the definition file to the existing Edgefield, Edgetable, and Edgeconnector classes.