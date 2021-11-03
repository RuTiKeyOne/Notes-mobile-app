# Description files

Here is a detailed description of the project files, this will help you better understand the architecture.

Name            | Description
:-------------------------:|:-------------------------:
build.grable  | Contains all the libraries connected to the project and necessary for correct operation.
Activity  | Contains all the activity class of the application. All the logic of interaction between view and viewmodel is implemented here.
Adapter | This package contains adapters. The folder includes parent and child. The folder contains classes that implement the generalized logic of adapters. The parent folder contains the DataAdapter heir, which only transmits the necessary data.
Command | This folder contains command classes that implement highly specialized actions required for generalized logic.
Dao | Contains the interface of interaction between the Room Database and the application.
Database | Contains the Database class that implements the database initialization logic.
Interfaces | This folder contains interfaces that implement callback logic in the application.
Model | Contains the class required to get and add record data to the database and use this data in the application.
Repository | Contains a class that implements the logic of intermediate data retrieval (ViewModel-notesrepository-NotesDatabase) from the database.
Utilities  | Contains classes containing general data and logic for a particular part of the application. 
ViewModel | Contains the viewmodel classes needed to implement the mvvm pattern.
notes(androidTest) | Contains test classes that test the logic of the application, there are more than 100 of them in total and they all give a positive result.
drawable | Contains resources used in the markup and application.
font | Contains fonts used in application.
layout | Contains view layout used in application.
strings | Contains text variables, which are selected depending on the language installed on the device.
