package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	// DataAccessLayer dal = new DataAccessLayer();

	public String HasStudied;
	public String Course;
	public String Student;
	static String url = "jdbc:sqlserver://localhost:1433;database=test";
	static String user = "fri";
	static String password = "oli";

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
			 System.out.print("please only use capital ¨S¨ + studentnumber.");
			 }

			else {

				name = name.substring(0, 1).toUpperCase() + name.substring(1);
				studentID = studentID.substring(0, 1).toUpperCase() + studentID.substring(1);

				try {

					Connection con = DriverManager.getConnection(url, user, password);
					String query = "INSERT INTO Student (studentID, name) VALUES(?,?);"
							+ "SELECT * FROM Student WHERE studentID =?";

					try (PreparedStatement ps = con.prepareStatement(query)) {

						ps.setString(1, studentID);
						ps.setString(2, name);
						ps.setString(3, studentID);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {
							lblStatusStudent.setText("Student: " + rs.getString(2) + " with student ID: "
									+ rs.getString(1) + " has been added");
						}
					} catch (SQLException e1) {

						System.out.println("Catch2 " + e1.getMessage());

					}

				} catch (SQLException e1) {

					System.out.println("Catch2 " + e1.getMessage());

				}
				studentIDTextField.clear();
				studentNameTextField.clear();
				
			}

		} catch (NullPointerException e) {
			// System.out.print(e.getMessage() + " An Error occurred");
		}
	}

	public void btnAddCourse_Click(ActionEvent event2) {
		try {
			String courseID = txtCourseID.getText();
			String courseName = txtCourseName.getText();

			if (txtCourseID.getText().isEmpty() && txtCourseName.getText().isEmpty()) {
				lblStatusCourse.setText("You didn't set a Student ID and name");
			} else if (txtCourseID.getText().isEmpty()) {
				lblStatusCourse.setText("You didn't set students unique ID");
			} else if (txtCourseName.getText().isEmpty()) {
				lblStatusCourse.setText("You didn't set students name");
			} else if (!courseName.matches("[a-z A-Z]+")) {
				System.out.print("Invalid name, please only use letters.");
			}
			// if (!studentID.matches("[0-9]+")) {
			// System.out.print("please only use numbers.");
			// }

			else {

				courseName = courseName.substring(0, 1).toUpperCase() + courseName.substring(1);
				courseID = courseID.substring(0, 1).toUpperCase() + courseID.substring(1);
				try {

					Connection con = DriverManager.getConnection(url, user, password);
					String query = "INSERT INTO Course (courseID, courseName) VALUES(?,?);"
							+ "SELECT * FROM Course WHERE courseID =?";

					try (PreparedStatement ps = con.prepareStatement(query)) {

						ps.setString(1, courseID);
						ps.setString(2, courseName);
						ps.setString(3, courseID);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {
							lblStatusCourse.setText("Course: " + rs.getString(2) + " with course ID: "
									+ rs.getString(1) + " has been added");
						}
					} catch (SQLException e1) {

						System.out.println("Catch2 " + e1.getMessage());

					}

				} catch (SQLException e1) {

					System.out.println("Catch2 " + e1.getMessage());

				}
				txtCourseID.clear();
				txtCourseName.clear();
			}

		} catch (NullPointerException e) {
			System.out.print(e.getMessage() + " An Error occurred");
		}
	}

	public void btnFindStudent_Click(ActionEvent event1) {

		txtResponses.clear();

		try {
			String studentID = studentIDTextField.getText();

			if (studentIDTextField.getText().equals("")) {
				System.out.print("Please enter a studentID");
			}

			else {

				try {
					Connection con = DriverManager.getConnection(url, user, password);
					String query = "SELECT * FROM Student WHERE StudentID = ?";
					try (PreparedStatement ps = con.prepareStatement(query);) {

						ps.setString(1, studentID);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {
							txtResponses.setText(rs.getString(1) + " " + rs.getString(2));
						}
					} catch (SQLException e1) {

						System.out.println("CatchFindStudent: " + e1.getMessage());

					}

				} catch (SQLException e1) {

					System.out.println("CatchFindStudent: " + e1.getMessage());

				}
			}
		} catch (NullPointerException e) {
			System.out.print("An Error occurred");
		}
	}

	public void btnFindCourse_Click(ActionEvent event3) {

		txtResponses.clear();

		try {
			String courseID = txtCourseID.getText();

			if (txtCourseID.getText().equals("")) {
				System.out.print("Please enter a courseID");
			}

			else {

				try {
					Connection con = DriverManager.getConnection(url, user, password);
					String query = "SELECT * FROM HasStudied WHERE courseID = ?";
					try (PreparedStatement ps = con.prepareStatement(query);) {

						ps.setString(1, courseID);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {

							String[] response = { rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) };
							for (String i : response) {
								txtResponses.appendText(i + "\n");
								System.out.println(i);
							}

						}
					} catch (SQLException e1) {

						System.out.println("CatchFindCourse: " + e1.getMessage());

					}

				} catch (SQLException e1) {

					System.out.println("CatchFindCourse: " + e1.getMessage());

				}

			}
		} catch (NullPointerException e) {
			System.out.print("An Error occurred");
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

				try {

					Connection con = DriverManager.getConnection(url, user, password);
					String query = "INSERT INTO Studies (courseID, studentID) VALUES(?,?);"
							+ "SELECT * FROM Studies WHERE courseID = ? AND studentID = ?";

					try (PreparedStatement ps = con.prepareStatement(query)) {

						ps.setString(1, courseID);
						ps.setString(2, studentID);
						ps.setString(3, courseID);
						ps.setString(4, studentID);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {
							lblStatusStudent.setText("Course-ID: " + rs.getString(1) + " with Student-ID: "
									+ rs.getString(2) + " has been added");
						}
					} catch (SQLException e1) {

						System.out.println("Catch2 " + e1.getMessage());

					}

				} catch (SQLException e1) {

					System.out.println("Catch2 " + e1.getMessage());

				}

				lblStatusStudent
						.setText("Course-ID: " + courseID + " with studentID: " + studentID + " has been added");
				txtCourseID.clear();
				txtCourseName.clear();
			}

		} catch (NullPointerException e) {
			System.out.print(e.getMessage() + " An Error occurred");
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
				grade = grade.substring(0, 1).toUpperCase() + grade.substring(1);

				try {

					Connection con = DriverManager.getConnection(url, user, password);
					String query = "INSERT INTO HasStudied (courseID, studentID, grade) VALUES(?,?,?);"
							+ "SELECT * FROM HasStudied WHERE courseID = ? AND studentID = ?";

					try (PreparedStatement ps = con.prepareStatement(query)) {

						ps.setString(1, courseID);
						ps.setString(2, studentID);
						ps.setString(3, grade);
						ps.setString(4, courseID);
						ps.setString(5, studentID);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {
							lblStatusStudent.setText("Course-ID: " + rs.getString(1) + " with Student-ID: "
									+ rs.getString(2) + " has been given grade " + rs.getString(3));
						}
					} catch (SQLException e1) {

						System.out.println("Catch2 " + e1.getMessage());

					}

				} catch (SQLException e1) {

					System.out.println("Catch2 " + e1.getMessage());

				}

				lblStatusStudent.setText(
						"Course-ID: " + courseID + " with studentID: " + studentID + " has been given grade " + grade);
				txtCourseID.clear();
				txtCourseName.clear();
				txtGrade.clear();
			}

		} catch (NullPointerException e) {
			System.out.print(e.getMessage() + " An Error occurred");
		}
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

				try {
					Connection con = DriverManager.getConnection(url, user, password);
					String query = "SELECT * FROM HasStudied h, Student s, Course c WHERE h.studentID = s.studentID AND h.courseID = c.courseID AND h.courseID = ? AND h.studentID = ?";
					try (PreparedStatement ps = con.prepareStatement(query);) {

						ps.setString(1, courseID);
						ps.setString(2,  studentID);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {

							String[] response = { "Student " + rs.getString(5) + " got grade " + " '" + rs.getString(3) + "' " + " on course " + rs.getString(7) };
							for (String i : response) {
								txtResponses.appendText(i + "\n");
								System.out.println(i);
							}

						}
					} catch (SQLException e1) {

						System.out.println("CatchFindCourse: " + e1.getMessage());

					}

				} catch (SQLException e1) {

					System.out.println("CatchFindCourse: " + e1.getMessage());

				}

			}
		} catch (NullPointerException e) {
			System.out.print("An Error occurred");
		}
	}

}