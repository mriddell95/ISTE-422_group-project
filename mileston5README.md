# ISTE 422 Group Project


To build and run the application refer to our main readme.

## Milestone 5


### What was changed and why

* We changed the getOutputClasses method in the EdgeConvertGui class. 
    * We set the objOutput object to a newInstance of the class used when there is no edgefile or sav file loaded
        * We did this because it was causing a null pointer exception
* We added a new property on the EdgeconvertFileParser class to know if the file is good or if its an incorrect format
    * We then used this property in the gui class to stop loading calling methods additional methods if it is not a edg or sav file
        * This was done because the program would become in a glitched state if a edge file was loaded then you tried to load bad file
* We removed a bunch of unused variables and import statments from each file
* We removed a uneeded method call in the EdgeConvertGui class
* We fixed a bunch of infered generics in each file making them the appropriate types
    * This was done because those are considered unsafe operations


### What would need to change to extend the functionality to other Databases 

To extend the functionality to create DDL's for another database they would need to create a java class for that database type which extends the EdgeConvertCreateDDL class.
TODO

### What would need to be done to use a seperate description file
TODO