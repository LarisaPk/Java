import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



//This Class manages database operations associated to the Course Class

public class CourseQueries {
	// DB connection details
	private static final String URL = "jdbc:mysql://localhost:3306/studyplan"; // here you need to give your URL of the database (make changes)
	private static final String USERNAME = "javaoo"; // here you need to give your username of the database (make changes)
	private static final String PASSWORD = "qwerty"; // here you need to give your password of the database (make changes)

	private Connection connection = null;
	private PreparedStatement addCourse = null; 
	private PreparedStatement selectAllCourses = null;
	private PreparedStatement markCompletion = null;
	private PreparedStatement updateSemester = null;
	private PreparedStatement removeCourse = null;
	private PreparedStatement printByName = null;
	private PreparedStatement printBySemester = null;
	private PreparedStatement printByStatus = null;
	
	public CourseQueries()// method contains SQL queries for the  prepared satatements defined above
	{
		try
		{
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); // Starts a connection to the database
			selectAllCourses = connection.prepareStatement("SELECT * FROM courses"); // Prepare the select query that gets all courses from the database
			addCourse = connection.prepareStatement("INSERT INTO courses (Name, Semester) VALUES (?,?)"); // Prepare the insert query that adds new course to the database
			markCompletion = connection.prepareStatement("UPDATE courses SET Status = ? WHERE CourseID = ?");// Prepare the update query that changes status of course completion in the database
			updateSemester = connection.prepareStatement("UPDATE courses SET Semester = ? WHERE CourseID = ?");// Prepare the update query that changes planned semester in the database
			removeCourse = connection.prepareStatement("DELETE FROM courses WHERE CourseID=?"); // Prepare the delete query that removes course from the database
			printByName = connection.prepareStatement("SELECT * FROM courses WHERE Name=?"); // Prepare the select query that gets course by name from the database
			printBySemester = connection.prepareStatement("SELECT * FROM courses WHERE Semester=?"); // Prepare the select query that gets all cars from the database
			printByStatus = connection.prepareStatement("SELECT * FROM courses WHERE Status=?"); // Prepare the select query that gets all cars from the database
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
	/*
	 * Method that inserts a new Course in the database
	 */
	public void addCourse(String name, String semester) {
		try
		{
			// Setting the values for the question marks '?' in the prepared statement
			addCourse.setString(1, name);
			addCourse.setString(2, semester);
						
			// result will contain the amount of updated rows.
			int result = addCourse.executeUpdate(); 
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}	
	}
	/*
	 * This method will execute the select query that gets all courses from the database. 
	 * It returns an ArrayList containing Course objects initialized with Course data from each row in the cars table (database)
	 */
	public ArrayList<Course> getAllCourses(){
	
		ArrayList<Course> results = null;
		ResultSet resultSet = null;
		
		try
		{
			resultSet = selectAllCourses.executeQuery(); // Here we  execute the selectAllCourses query. resultSet contains the rows returned by the query
			results = new ArrayList<Course>();
		
			while(resultSet.next()) // for each row returned by the select query...
			{
				// Initialize a new Course object with the row's data. Add the Course object to the results ArrayList
				results.add(new Course(
					resultSet.getInt("CourseID"), // get the value associated to the CourseID column
					resultSet.getString("Name"), // get the value associated to the Name column
					resultSet.getBoolean("Status"), // get the value associated to the Status column
					resultSet.getString("Semester"))); // get the value associated to the Semester column
			}
		} // end try
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		finally
		{
			try
			{
				resultSet.close();
			}
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
		} // end finally
		
		return results;
	} // end method getAllCourses
}

	