public class Course {
	private int id;
	private String name;
	private boolean status;
	private String semester;

	//Constructor for the Course
	public Course(int id, String name, boolean status, String semester) {
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.status = status;
	}
	/**********
	 * getID
	 * Parameters: -
	 * Returns: ID as int
	 */
	public int getID() {
		return this.id;
	}
	/**********
	 * getName
	 * Parameters: -
	 * Returns: course name as string
	 */
	public String getName() {
		return this.name;
	}
	/**********
	 * getSemester
	 * Parameters: -
	 * Returns: planned semester's name as a string
	 */
	public String getSemester() {
		return this.semester;
	}
	/**********
	 * getStatus
	 * Parameters: -
	 * Returns: status as a boolean
	 */
	public boolean getStatus() {
		return this.status;
	}
	/**********
	 * getAvailable
	 * Parameters: -
	 * Returns: Availability as boolean
	 */
	public String getStatusString() {
		return this.status ? "completed" : "not completed";
	}
	
}
