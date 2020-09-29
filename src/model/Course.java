 package model;

import java.util.ArrayList;

public class Course {

	
	String courseID;
	String courseName; 
	
	public ArrayList<Course>studies = new ArrayList<Course>(); 

	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getName() {
		return courseName;
	}
	public void setName(String courseName) {
		this.courseName = courseName;
	}
	public ArrayList<Course> getStudies() {
		return studies;
	}
	public void setStudies(ArrayList<Course> studies) {
		this.studies = studies;
	}
	
	
	
}
	