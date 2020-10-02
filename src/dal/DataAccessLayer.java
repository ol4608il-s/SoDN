package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dal.DatabaseConnect;

public class DataAccessLayer {

	public String HasStudied;
	public String Course;
	public String Student;

	public String findStudent(String studentID) throws SQLException {

		Connection con1 = DatabaseConnect.newConnection();
		String query = "SELECT * FROM Student WHERE StudentID = ?";
		try (PreparedStatement ps = con1.prepareStatement(query);) {

			ps.setString(1, studentID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2));
				String studentIDRS = rs.getString(1);
				String studentNameRS = rs.getString(2);

				return studentIDRS + " " + studentNameRS;

			}
		} catch (SQLException e1) {

			System.out.println("CatchFindStudent: " + e1.getMessage());

		}
		return null;

	}

	public String findCourse(String courseID) throws SQLException {

		Connection con1 = DatabaseConnect.newConnection();
		String query = "SELECT * FROM Course WHERE courseID = ?";
		try (PreparedStatement ps = con1.prepareStatement(query);) {

			ps.setString(1, courseID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
				String courseIDRS = rs.getString(1);
				String courseNameRS = rs.getString(2);
				String courseCreditsRS = rs.getString(3);

				return courseIDRS + " " + courseNameRS + " " + courseCreditsRS;
			}
		} catch (SQLException e1) {

			System.out.println("CatchFindCourse: " + e1.getMessage());

		}

		return null;
	}

	public <StudentsOnCourse> ArrayList<StudentsOnCourse> findStudentsOnCourse(String courseID) throws SQLException {

		ArrayList<StudentsOnCourse> SOC = new ArrayList<StudentsOnCourse>();
		Connection con1 = DatabaseConnect.newConnection();
		String query = "SELECT * FROM HasStudied WHERE courseID = ?";
		try (PreparedStatement ps = con1.prepareStatement(query);) {
			ps.setString(1, courseID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SOC.add((StudentsOnCourse) rs.getString(1));
				SOC.add((StudentsOnCourse) rs.getString(2));
				SOC.add((StudentsOnCourse) rs.getString(3));
				// System.out.println(SOC);

			}
			return SOC;
		}

	}

	public String addStudent(String studentID, String name) throws SQLException {

		Connection con1 = DatabaseConnect.newConnection();
		String query = "INSERT INTO Student (studentID, name) VALUES(?,?);"
				+ "SELECT * FROM Student WHERE studentID =?";

		try (PreparedStatement ps = con1.prepareStatement(query)) {

			ps.setString(1, studentID);
			ps.setString(2, name);
			ps.setString(3, studentID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
				String studentIDRS = rs.getString(1);
				String studentNameRS = rs.getString(2);

				return studentIDRS + " " + studentNameRS;
			}
		}
		return null;
	}

	public String addCourse(String courseID, String courseName, String credits) throws SQLException {

		Connection con1 = DatabaseConnect.newConnection();
		String query = "INSERT INTO Course (courseID, courseName, credits) VALUES(?,?,?);"
				+ "SELECT * FROM Course WHERE courseID =?";

		try (PreparedStatement ps = con1.prepareStatement(query)) {

			ps.setString(1, courseID);
			ps.setString(2, courseName);
			ps.setString(3, credits);
			ps.setString(4, courseID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
				String courseIDRS = rs.getString(1);
				String courseNameRS = rs.getString(2);
				String courseCreditsRS = rs.getString(3);

				return courseIDRS + " " + courseNameRS + " " + courseCreditsRS;
			}
		}
		return null;

	}

	public String addStudies(String courseID, String studentID) throws SQLException {

		Connection con1 = DatabaseConnect.newConnection();
		String query = "INSERT INTO Studies (courseID, studentID) VALUES(?,?);"
				+ "SELECT * FROM Studies WHERE studentID =?";

		try (PreparedStatement ps = con1.prepareStatement(query)) {

			ps.setString(1, courseID);
			ps.setString(2, studentID);
			ps.setString(3, studentID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
				String studentIDRS = rs.getString(1);
				String studentNameRS = rs.getString(2);

				return studentIDRS + " " + studentNameRS;
			}
		} catch (SQLException e1) {

			System.out.println("Catch2 " + e1.getMessage());

		}
		return null;

	}

	public String addGrade(String courseID, String studentID, String grade) throws SQLException {

		Connection con1 = DatabaseConnect.newConnection();
		String query = "INSERT INTO HasStudied (courseID, studentID, grade) VALUES(?,?,?);"
				+ "SELECT * FROM HasStudied WHERE studentID =?";

		try (PreparedStatement ps = con1.prepareStatement(query)) {

			ps.setString(1, courseID);
			ps.setString(2, studentID);
			ps.setString(3, grade);
			ps.setString(4, studentID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				String courseIDRS = rs.getString(1);
				String studentIDRS = rs.getString(2);
				String gradeRS = rs.getString(3);

				return courseIDRS + " " + studentIDRS + " " + gradeRS;
			}
		}

		return null;
	}

	public String FindStudentCourse(String courseID, String studentID) throws SQLException {

		Connection con1 = DatabaseConnect.newConnection();
		String query = "SELECT * FROM HasStudied h, Student s, Course c WHERE h.studentID = s.studentID AND h.courseID = c.courseID AND h.courseID = ? AND h.studentID = ?";

		try (PreparedStatement ps = con1.prepareStatement(query);) {

			ps.setString(1, courseID);
			ps.setString(2, studentID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2));
				String courseIDRS = rs.getString(1);
				String studentIDRS = rs.getString(2);

				return "Student " + courseIDRS + " got grade " + rs.getString(3) + " on course " + studentIDRS;

			}
		}
		return null;
	}

	public String DeleteStudent(String studentID) throws SQLException {

		Connection con1 = DatabaseConnect.newConnection();
		String query = "DELETE FROM Student WHERE studentID = ?";

		try (PreparedStatement ps = con1.prepareStatement(query);) {
			ps.setString(1, studentID);
			ResultSet rs = ps.executeQuery();

			return null;

		}

	}

	public String DeleteCourse(String courseID) throws SQLException {

		Connection con1 = DatabaseConnect.newConnection();
		String query = "DELETE FROM Course WHERE courseID = ?";

		try (PreparedStatement ps = con1.prepareStatement(query);) {
			ps.setString(1, courseID);
			ResultSet rs = ps.executeQuery();

			return null;

		}
	}

	public String DeleteStudentFromCourse(String studentID, String courseID) throws SQLException {

		Connection con1 = DatabaseConnect.newConnection();
		String query = "DELETE FROM Studies WHERE studentID = ? AND courseID = ? "
				+ "SELECT s.studentID, c.courseID FROM Student s, Course c  WHERE s.studentID = ? AND c.courseID = ?";

		try (PreparedStatement ps = con1.prepareStatement(query);) {
			ps.setString(1, studentID);
			ps.setString(2, courseID);
			ps.setString(3, studentID);
			ps.setString(4, courseID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(studentID + courseID);

				return "Student " + studentID + " has been deleted from course: " + courseID;

			}
		}
		return null;
	}

	public String CountPercentA(String courseID) throws SQLException {

		Connection con1 = DatabaseConnect.newConnection();
		String query = "SELECT COUNT(*) * 100.0 / (SELECT COUNT(*) FROM HasStudied WHERE courseID = ?) AS 'Percentage of A' FROM HasStudied WHERE grade = 'A' AND courseID = ? GROUP BY CourseID, grade";
		try (PreparedStatement ps = con1.prepareStatement(query);) {

			ps.setString(1, courseID);
			ps.setString(2, courseID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				return "The selected course " + courseID + " has: " + (rs.getString(1)) + "%" + "\n"
						+ "completion rate with the grade 'A'";

			}

		}
		return null;

	}
}