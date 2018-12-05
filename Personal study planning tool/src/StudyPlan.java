import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class StudyPlan extends JFrame {
	//Private variables
	private static CourseQueries CourseQueries; //instance of the CourseQueries class
	private static ArrayList<Course> allCourses;  //array to store all courses
	private JTextField txtSearchField;
	static JTable tableCourses;
	
	static DefaultTableModel tableModel;
	
	//Constants for table columns
	private static final int ID_COL = 0;
	private static final int NAME_COL = 1;
	private static final int STATUS_STRING_COL = 3;
	private static final int STATUS_COL = 2;
	private static final int SEMESTER_COL = 4;
	private static final int COL_COUNT = 5;
	
	public StudyPlan () {
		super("Personal study planner");
		CourseQueries = new CourseQueries();// Initializes a CourseQueries object to handle db operations in this session
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null); 
		setBounds(0,0,700,400); 
		setLocationRelativeTo(null); 
		tableModel = new DefaultTableModel(
				new Object[1][COL_COUNT],  
				new String[] {"ID", "Name","Status","Completion","Planned Semester"} // Set the column names
			);
		
		
		// button for removing course from the study plan
		JButton btnRemoveCourse = new JButton("Remove selected");
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveCourse.setBounds(512, 302, 114, 21);
		getContentPane().add(btnRemoveCourse);
		
		// button for adding course to the study plan
		JButton btnAddCourse = new JButton("Add a course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCourse();
				populateTable();
			}
		});
		btnAddCourse.setBounds(502, 32, 124, 21);
		getContentPane().add(btnAddCourse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 81, 590, 200);
		getContentPane().add(scrollPane);
		
		// table for showing planned courses and manipulating them
		tableCourses = new JTable();
		scrollPane.setViewportView(tableCourses);
		tableCourses.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableCourses.setModel(tableModel);
		
		//Makes ID and Status columns hidden
		tableCourses.removeColumn(tableCourses.getColumnModel().getColumn(STATUS_COL));
		tableCourses.removeColumn(tableCourses.getColumnModel().getColumn(ID_COL));
	}

	public static void main(String[] args) {
		JFrame frame = new StudyPlan();
		frame.setVisible(true);
		populateTable();
	}
	private void getCourse(){
		JPanel myPanel = new JPanel();
		
		JTextField name = new JTextField(15);
		
		String semesterChoise[]= {"Autumn 2018","Spring 2019","Summer2019", "Autumn2019"}; 
		JComboBox  semester= new JComboBox (semesterChoise);

		myPanel.add(new JLabel("Course name:"));
		myPanel.add(name);
		
	    myPanel.add(new JLabel("Planned semester:"));
	    myPanel.add(semester);
	    
	    int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter course information", JOptionPane.OK_CANCEL_OPTION);
	    
	    if (result == JOptionPane.OK_OPTION) {	    	

	    	CourseQueries.addCourse(name.getText(), (String)semester.getSelectedItem());
	    }
	}
	/************
	 * searchAlbums
	 * Queries the database for albums and lists them in a table
	 * Parameters: -
	 * Returns: -
	 */
	public static void populateTable() {
		Course currentCourse;
		allCourses= CourseQueries.getAllCourses();
		 
		tableModel.setRowCount(allCourses.size());
		
		for (int row=0; row<allCourses.size(); row++){ //allCourses.size() returns the amount of items in the allCourses list
			currentCourse = allCourses.get(row); // get an course from the ArrayList allAlbums
			
			tableCourses.getModel().setValueAt(currentCourse.getID(), row, ID_COL);
			tableCourses.getModel().setValueAt(currentCourse.getName(), row, NAME_COL);
			tableCourses.getModel().setValueAt(currentCourse.getStatus(), row, STATUS_COL);
			tableCourses.getModel().setValueAt(currentCourse.getStatusString(), row, STATUS_STRING_COL);
			tableCourses.getModel().setValueAt(currentCourse.getSemester(), row, SEMESTER_COL);
		}
	}
}
