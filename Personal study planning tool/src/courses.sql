-- SQL script that creates the table "courses"

CREATE TABLE IF NOT EXISTS courses (
CourseID INT NOT NULL auto_increment,
Name varchar(30) NOT NULL,
Status BOOLEAN NOT NULL DEFAULT 0,
Semester varchar(16) NOT NULL,
PRIMARY KEY (CourseID)
);
