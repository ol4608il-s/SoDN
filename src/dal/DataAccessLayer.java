/*package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAccessLayer {

	public String HasStudied;
	public String Course;
	public String Student;
	static String url = "jdbc:sqlserver://localhost:1433;database=test";
	static String user = "fri";
	static String password = "oli";

/*	public static void Connect() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, user, password);

			System.out.println("Successfully Connected to the database");

		} catch (ClassNotFoundException e) {

			System.out.println("Catch1 " + e.getMessage());

		} catch (SQLException e1) {

			System.out.println("Catch2 " + e1.getMessage());

		}

	}

	public void findStudent(String studentID) {

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String query = "SELECT * FROM Student WHERE StudentID = ?";
			try (PreparedStatement ps = con.prepareStatement(query);) {

				ps.setString(1, studentID);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2));
				}
			} catch (SQLException e1) {

				System.out.println("CatchFindStudent: " + e1.getMessage());

			}

		} catch (SQLException e1) {

			System.out.println("CatchFindStudent: " + e1.getMessage());

		}

	}
	
	public void findCourse(String courseID) {
		ArrayList<>tmp = new ArrayList<>(); 
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String query = "SELECT * FROM HasStudied WHERE courseID = ?";
			try (PreparedStatement ps = con.prepareStatement(query);) {

				ps.setString(1, courseID);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				}
			} catch (SQLException e1) {

				System.out.println("CatchFindCourse: " + e1.getMessage());

			}

		} catch (SQLException e1) {

			System.out.println("CatchFindCourse: " + e1.getMessage());

		}

	}

	public void addStudent(String studentID, String name) {

		try {

			Connection con = DriverManager.getConnection(url, user, password);
			String query = "INSERT INTO Student (studentID, name) VALUES(?,?);"
				+ "SELECT * FROM Student WHERE studentID =?" ;

			try (PreparedStatement ps = con.prepareStatement(query)) {

				ps.setString(1, studentID);
				ps.setString(2, name);
				ps.setString(3, studentID);
				ResultSet rs = ps.executeQuery();

				while (rs.next())	{
					System.out.println("Student: " + rs.getString(2) + " with student ID: " + rs.getString(1) + " has been added");
				}
			} catch (SQLException e1) {

				System.out.println("Catch2 " + e1.getMessage());

			}
			
		} catch (SQLException e1) {

			System.out.println("Catch2 " + e1.getMessage());

		}

	}
	
	public void addCourse(String courseID, String courseName) {

		try {

			Connection con = DriverManager.getConnection(url, user, password);
			String query = "INSERT INTO Course (courseID, courseName) VALUES(?,?);"
					+ "SELECT * FROM Course WHERE courseID =?" ;

			try (PreparedStatement ps = con.prepareStatement(query)) {

				ps.setString(1, courseID);
				ps.setString(2, courseName);
				ps.setString(3, courseID);
				ResultSet rs = ps.executeQuery();

				while (rs.next())	{
					System.out.println("Course: " + rs.getString(2) + " with course ID: " + rs.getString(1) + " has been added");
				}
			} catch (SQLException e1) {

				System.out.println("Catch2 " + e1.getMessage());

			}
			
		} catch (SQLException e1) {

			System.out.println("Catch2 " + e1.getMessage());

		}

	}
	
	public void addStudies(String courseID, String studentID) {

		try {

			Connection con = DriverManager.getConnection(url, user, password);
			String query = "INSERT INTO Studies (courseID, studentID) VALUES(?,?);"
					+ "SELECT * FROM Studies WHERE courseID = ? AND studentID = ?" ;

			try (PreparedStatement ps = con.prepareStatement(query)) {

				ps.setString(1, courseID);
				ps.setString(2, studentID);
				ps.setString(3, courseID);
				ps.setString(4, studentID);
				ResultSet rs = ps.executeQuery();

				while (rs.next())	{
					System.out.println("Course-ID: " + rs.getString(1) + " with Student-ID: " + rs.getString(2) + " has been added");
				}
			} catch (SQLException e1) {

				System.out.println("Catch2 " + e1.getMessage());

			}
			
		} catch (SQLException e1) {

			System.out.println("Catch2 " + e1.getMessage());

		}

	}
	public void addGrade(String courseID, String studentID, String grade) {

		try {

			Connection con = DriverManager.getConnection(url, user, password);
			String query = "INSERT INTO HasStudied (courseID, studentID, grade) VALUES(?,?,?);"
					+ "SELECT * FROM HasStudied WHERE courseID = ? AND studentID = ?" ;

			try (PreparedStatement ps = con.prepareStatement(query)) {

				ps.setString(1, courseID);
				ps.setString(2, studentID);
				ps.setString(3, grade);
				ps.setString(4, courseID);
				ps.setString(5, studentID);
				ResultSet rs = ps.executeQuery();

				while (rs.next())	{
					System.out.println("Course-ID: " + rs.getString(1) + " with Student-ID: " + rs.getString(2) + " has been given grade " + rs.getString(3));
				}
			} catch (SQLException e1) {

				System.out.println("Catch2 " + e1.getMessage());

			}
			
		} catch (SQLException e1) {

			System.out.println("Catch2 " + e1.getMessage());

		}

	}
}
*/
