package model;

import java.util.ArrayList;

public class HasStudied {

	String grade; 
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public ArrayList<Student> getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(ArrayList<Student> studentGrade) {
		this.studentGrade = studentGrade;
	}
	public ArrayList<Course> getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(ArrayList<Course> courseGrade) {
		this.courseGrade = courseGrade;
	}
	public ArrayList<Student>studentGrade = new ArrayList<Student>(); 
	public ArrayList<Course>courseGrade = new ArrayList<Course>(); 
}
