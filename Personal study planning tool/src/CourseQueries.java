
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CourseQueries {
	
	private static final String URL = "jdbc:mysql://localhost:3306/jdbcexample";
	private static final String USERNAME = "javaoo";
	private static final String PASSWORD = "qwerty";

	private Connection connection = null;
	private PreparedStatement selectAllCars = null;
	private PreparedStatement insertCar = null;

}
