package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Course;
import model.HasStudied;
import java.util.ArrayList;
import dal.DataAccessLayer;
import dal.DatabaseConnect;

public class ApplicationController {
	@FXML
	private Button addStudentButton;
	@FXML
	private Button findStudentButton;
	@FXML
	private TextField studentIDTextField;
	@FXML
	private TextField studentNameTextField;
	@FXML
	private ComboBox combo1idk;
	@FXML
	private Label responseLableStudent;
	@FXML
	private Label lblStatusStudent;
	@FXML
	private Label lblStatusCourse;
	@FXML
	private TextField txtCourseName;
	@FXML
	private TextField txtCourseID;
	@FXML
	private Button btnAddCourse;
	@FXML
	private Button findCourseButton;
	@FXML
	private TextField txtStudiesCourseID;
	@FXML
	private TextField txtStudiesStudentID;
	@FXML
	private TextField txtGrade;
	@FXML
	private TextArea txtArea;
	@FXML
	private TextArea txtResponses;
	@FXML
	private Button btnFindStudentCourse;
	@FXML
	private Button btnDeleteStudent;
	@FXML
	private Button btnDeleteCourse;
	@FXML
	private Button btnDeleteStudentFromCourse;
	@FXML
	private TextField txtCredits;
	@FXML
	private Button btnPercentA;
	@FXML
	private Button btnFindStudentsOnCourse;
	DataAccessLayer dal = new DataAccessLayer();

	public String HasStudied;
	public String Course;
	public String Student;
	static String url = "jdbc:sqlserver://localhost:1433;database=test";
	static String user = "fri";
	static String password = "oli";

	public static int primaryKeyViolation = 2627;
	public static int dataBaseOffline = 17142;

	@FXML
	public void btnAddStudent_Click(ActionEvent event) {
		try {
			String studentID = studentIDTextField.getText();
			String name = studentNameTextField.getText();

			if (studentIDTextField.getText().isEmpty() && studentNameTextField.getText().isEmpty()) {
				lblStatusStudent.setText("You didn't set a Student ID and name");
			} else if (studentIDTextField.getText().isEmpty()) {
				lblStatusStudent.setText("You didn't set students unique ID");
			} else if (studentNameTextField.getText().isEmpty()) {
				lblStatusStudent.setText("You didn't set students name");
			} else if (!name.matches("[a-z A-Z]+")) {
				System.out.print("Invalid name, please only use letters.");
			}
			if (!studentID.matches("[S0-9]+")) {
				System.out.print("please only use capital ¨S¨ + a number/s.");
			}

			else {

				name = name.substring(0, 1).toUpperCase() + name.substring(1);
				studentID = studentID.substring(0, 1).toUpperCase() + studentID.substring(1);

				lblStatusStudent.setText("Student " + dal.addStudent(studentID, name) + " has been added.");
				studentIDTextField.clear();
				studentNameTextField.clear();
			}
		} catch (SQLException e2) {
			if (e2.getErrorCode() == primaryKeyViolation)
				lblStatusStudent.setText("This studentID is already in use, please try another one");
			System.out.println(e2.getMessage() + " SQL");
			if (e2.getErrorCode() == dataBaseOffline)
				lblStatusStudent.setText("The database is offline.");
		} catch (NullPointerException e) {
			lblStatusStudent.setText(e.getMessage() + " NullPointer");

		} catch (Exception e1) {
			lblStatusStudent.setText(e1.getMessage() + " Exception");

		}

	}

	public void btnAddCourse_Click(ActionEvent event2) {
		try {
			String courseID = txtCourseID.getText();
			String courseName = txtCourseName.getText();
			String credits = txtCredits.getText();

			if (txtCourseID.getText().isEmpty() && txtCourseName.getText().isEmpty()) {
				lblStatusCourse.setText("You didn't set a Course ID and name");
			} else if (txtCourseID.getText().isEmpty()) {
				lblStatusCourse.setText("You didn't set course unique ID");
			} else if (txtCourseName.getText().isEmpty()) {
				lblStatusCourse.setText("You didn't set course name");
			} else if (!courseName.matches("[a-z A-Z]+")) {
				System.out.print("Invalid name, please only use letters.");
			} else if (!credits.matches("[0-9]+")) {
				System.out.print("Invalid credit, please only use numbers.");
			}

			else {

				courseName = courseName.substring(0, 1).toUpperCase() + courseName.substring(1);
				courseID = courseID.substring(0, 1).toUpperCase() + courseID.substring(1);

				lblStatusStudent
						.setText("Course " + dal.addCourse(courseID, courseName, credits) + " has been added.");
				studentIDTextField.clear();
				studentNameTextField.clear();

			}
		} catch (SQLException e2) {
			if (e2.getErrorCode() == primaryKeyViolation)
				lblStatusCourse.setText("This courseID is already in use, please try another one");
			System.out.println(e2.getMessage() + " SQL");
			if (e2.getErrorCode() == dataBaseOffline)
				lblStatusStudent.setText("The database is offline.");
		} catch (NullPointerException e) {
			lblStatusStudent.setText(e.getMessage() + " NullPointer");

		} catch (Exception e1) {
			lblStatusStudent.setText(e1.getMessage() + " Exception");

		}

	}

	public String btnFindStudent_Click(ActionEvent event1) {

		txtResponses.clear();

		String studentID = studentIDTextField.getText();

		if (studentIDTextField.getText().equals("")) {
			System.out.print("Please enter a studentID");
		}

		else {

			try {
				txtResponses.setText(dal.findStudent(studentID));

			} catch (SQLException e2) {
				if (e2.getErrorCode() == dataBaseOffline)
					lblStatusStudent.setText("The database is offline.");
			} catch (NullPointerException e) {
				System.out.println("Catch1 " + e.getMessage());
			} catch (Exception e1) {
				lblStatusStudent.setText(e1.getMessage() + " Exception");
			}

		}
		return null;
	}

	public String btnFindCourse_Click(ActionEvent event3) {

		txtResponses.clear();

		String courseID = txtCourseID.getText();

		if (txtCourseID.getText().equals("")) {
			System.out.print("Please enter a courseID");
		}

		else {

			try {
				txtResponses.setText("CourseID: " + dal.findCourse(courseID) + " credits.");

			}

			catch (SQLException e2) {
				if (e2.getErrorCode() == dataBaseOffline)
					lblStatusStudent.setText("The database is offline.");
			} catch (NullPointerException e) {
				System.out.println("Catch1 " + e.getMessage());
			} catch (Exception e1) {
				lblStatusStudent.setText(e1.getMessage() + " Exception");
			}
		}
		return null;
	}

	public void btnFindStudentsOnCourse_Click(ActionEvent event8) throws SQLException {

		String courseID = txtCourseID.getText();

		try {
			// System.out.println(dal.findStudentsOnCourse(courseID));

			String[] SOC = dal.findStudentsOnCourse(courseID).toArray(new String[0]);
			txtResponses.clear();
			for (int i = 0; i < SOC.length; i += 3) {
				String[] hasStudiedRow = new String[3];
				hasStudiedRow[0] = SOC[i];
				hasStudiedRow[1] = SOC[i + 1];
				hasStudiedRow[2] = SOC[i + 2];

				txtResponses.appendText(hasStudiedRow[0] + " " + hasStudiedRow[1] + " " + hasStudiedRow[2] + "\n");

			}
		}

		catch (SQLException e2) {
			if (e2.getErrorCode() == dataBaseOffline)
				lblStatusStudent.setText("The database is offline.");
		} catch (NullPointerException e) {
			System.out.println("Catch1 " + e.getMessage());
		} catch (Exception e1) {
			lblStatusStudent.setText(e1.getMessage() + " Exception");
		}

	}

	public void btnAddStudentToCourse_Click(ActionEvent event4) {
		try {
			String courseID = txtStudiesCourseID.getText();
			String studentID = txtStudiesStudentID.getText();

			if (txtStudiesCourseID.getText().isEmpty() && txtStudiesStudentID.getText().isEmpty()) {
				lblStatusStudent.setText("You didn't set a Student ID and name");
			} else if (txtStudiesCourseID.getText().isEmpty()) {
				lblStatusStudent.setText("You didn't set students unique ID");
			} else if (txtStudiesStudentID.getText().isEmpty()) {
				lblStatusStudent.setText("You didn't set students name");
			}
			// if (!studentID.matches("[0-9]+")) {
			// System.out.print("please only use numbers.");
			// }

			else {
				courseID = courseID.substring(0, 1).toUpperCase() + courseID.substring(1);
				studentID = studentID.substring(0, 1).toUpperCase() + studentID.substring(1);
				txtResponses.setText(dal.addStudies(courseID, studentID));

			}

			lblStatusStudent.setText("Course-ID: " + courseID + " with studentID: " + studentID + " has been added");
			txtCourseID.clear();
			txtCourseName.clear();
		} catch (SQLException e2) {
			if (e2.getErrorCode() == dataBaseOffline)
				lblStatusStudent.setText("The database is offline.");
		} catch (NullPointerException e) {
			System.out.println("Catch1 " + e.getMessage());
		} catch (Exception e1) {
			lblStatusStudent.setText(e1.getMessage() + " Exception");
		}

	}

	public void btnAddGrade_Click(ActionEvent event5) {
		try {
			String courseID = txtStudiesCourseID.getText();
			String studentID = txtStudiesStudentID.getText();
			String grade = txtGrade.getText();

			if (txtStudiesCourseID.getText().isEmpty() && txtStudiesStudentID.getText().isEmpty()
					&& txtGrade.getText().isEmpty()) {
				lblStatusStudent.setText("You didn't set a Student ID, name and grade");
			} else if (txtStudiesCourseID.getText().isEmpty()) {
				lblStatusStudent.setText("You didn't set students unique ID");
			} else if (txtStudiesStudentID.getText().isEmpty()) {
				lblStatusStudent.setText("You didn't set students name");
			} else if (txtGrade.getText().isEmpty()) {
				lblStatusStudent.setText("You didn't set a grade");
			}
			// if (!studentID.matches("[0-9]+")) {
			// System.out.print("please only use numbers.");
			// }

			else {
				courseID = courseID.substring(0, 1).toUpperCase() + courseID.substring(1);
				studentID = studentID.substring(0, 1).toUpperCase() + studentID.substring(1);
				txtResponses.setText(dal.addGrade(courseID, studentID, grade));
			}
		}

		catch (SQLException e2) {
			if (e2.getErrorCode() == dataBaseOffline)
				lblStatusStudent.setText("The database is offline.");
		} catch (NullPointerException e) {
			System.out.println("Catch1 " + e.getMessage());
		} catch (Exception e1) {
			lblStatusStudent.setText(e1.getMessage() + " Exception");
		}

		txtCourseID.clear();
		txtCourseName.clear();
		txtGrade.clear();

	}

	public void btnFindStudentCourse_Click(ActionEvent event3) {

		txtResponses.clear();

		try {
			String courseID = txtCourseID.getText();
			String studentID = studentIDTextField.getText();

			if (txtCourseID.getText().equals("") && studentIDTextField.getText().contentEquals("")) {
				System.out.print("Please enter a courseID and studentID");
			}

			else {

				txtResponses.setText(dal.FindStudentCourse(courseID, studentID));

			}
		} catch (SQLException e2) {
			if (e2.getErrorCode() == dataBaseOffline)
				lblStatusStudent.setText("The database is offline.");
		} catch (NullPointerException e) {
			System.out.println("Catch1 " + e.getMessage());
		} catch (Exception e1) {
			lblStatusStudent.setText(e1.getMessage() + " Exception");
		}
	}

	public void btnDeleteStudent_Click(ActionEvent Event4) {
		txtResponses.clear();

		try {

			String studentID = studentIDTextField.getText();

			if (studentIDTextField.getText().contentEquals("")) {
				System.out.print("Please enter a studentID");
			}

			else {

				dal.DeleteStudent(studentID);
				
			}
		} catch (SQLException e1) {
			if (e1.getErrorCode() == dataBaseOffline)
				lblStatusStudent.setText("The database is offline.");
		} catch (NullPointerException e) {
			System.out.println("Catch1 " + e.getMessage());
		} catch (Exception e2) {
			lblStatusStudent.setText(e2.getMessage() + " Exception");
		}

	}

	public void btnDeleteCourse_Click(ActionEvent Event5) {
		txtResponses.clear();
	
		try	{
		
		String courseID = txtCourseID.getText();

		if (txtCourseID.getText().contentEquals("")) {
			System.out.print("Please enter a courseID");
		} 
		
		else {
			
			dal.DeleteCourse(courseID);
			
			}
			} catch (SQLException e1) {
					if (e1.getErrorCode() == dataBaseOffline)
						lblStatusStudent.setText("The database is offline.");
			} catch (Exception e2) {
					lblStatusStudent.setText(e2.getMessage() + " Exception");
			} 
	}	

		
	

	public void btnDeleteStudentFromCourse_Click(ActionEvent Event6) {
		txtResponses.clear();
		
		try	{
		
		String courseID = txtStudiesCourseID.getText();
		String studentID = txtStudiesStudentID.getText();

		if (txtStudiesCourseID.getText().equals("") && txtStudiesStudentID.getText().contentEquals("")) {
			System.out.print("Please enter a courseID and studentID");
		} else {
			
			txtResponses.setText(dal.DeleteStudentFromCourse(studentID, courseID));
			
			} 
		} catch (SQLException e1) {
				if (e1.getErrorCode() == dataBaseOffline)
					lblStatusStudent.setText("The database is offline.");
		} catch (Exception e2) {
				lblStatusStudent.setText(e2.getMessage() + " Exception");
		}
				
	}
	

	public void btnCountPercentA_Click(ActionEvent event7) {

		txtResponses.clear();

		try {
			String courseID = txtCourseID.getText();

			if (txtCourseID.getText().equals("")) {
				System.out.print("Please enter a courseID");
			}

			else {

				txtResponses.setText(dal.CountPercentA(courseID));
						
	}	} catch (SQLException e1) {
		if (e1.getErrorCode() == dataBaseOffline)
			lblStatusStudent.setText("The database is offline.");
}	}
}