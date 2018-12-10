
# Project Name
Java-Personal-study-planning-tool
## Description
The project has been made for the Object-Oriented Programming with Java course from Laurea University of Applied sciences.
## Installation
- access to a database on a MySQL server is needed
- create a database and  give any name to this database
- also needed: the hostname/URL of the database server, a database name,  a username to access the
database, and its password. 
- create a java project in your IDE and configure the project so it can use the jdbc driver
- download the source code and add it to the project
- configure the CourseQueries.java file so it will connect to your database on your selected MySQL server. Changes need to be made in the lines  11,12,13
- via your SQL Client, connect to your database and run the sql script to create the database table (file name is courses.sql)                 
## Usage
The purpose of this tool is to create a study plan and save it into a database. With the tool you can
add courses into the personal study plan, mark them completed and print out courses to be studied
in a given semester.
The tool includes the following functionality:
1. Adding a course - press "Add a course" button, insert the information to the field and press "OK"
2. Marking the course completed - click on the row and press "Mark selected as completed/not completed" button
3. Updating the planned semester for a given course - click on the cell of the semester you wish to change and cshoose the new one from the pop up panel dropdown menu and press "OK"
4. Removing a course - click on the row and press "Remove selected" button
5. Printing out courses based on: 
* a. name of the course - incert the name of the course to the search field, press "Search by name" button and then "Print" button, choose printing options and press "OK"
* b. the planned semester - pick the semester from the dropdown menu and press "Print" button...
* c. the status (completed/not completed) of the course - pick the status from the dropdown menu and press "Print" button
6. By pressing "Show all" button you can see all the courses planned
