package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Student {

	
	private String studentID;
	private String name;
	private static int studentNbr = 10000;
	
	// Constructor plus add auto studentID
	public Student(String name)	{
		this.studentID = studentID;
		this.name = name;
		StringBuilder sb = new StringBuilder("S");
		String studentNbrString = Integer.toString(studentNbr);
		sb.append(Integer.toString(studentNbr));
		this.studentID = (sb.toString());
		studentNbr++;
		
		
		
		/* 
		// Instance variables
		private String studentID;
		private String firstName;
		private String lastName;
		private static int studentNbr = 10000;

		private ObservableList<Result> resultsList = FXCollections.observableArrayList();

		// Constructors and adding automated studentID-generator
		public Student(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.studentID = studentID;
			StringBuilder sb = new StringBuilder("S");
			String studentNbrString = Integer.toString(studentNbr);
			sb.append(Integer.toString(studentNbr));
			this.studentID = (sb.toString());
			studentNbr++;
		*/
	}
	
	public ArrayList<Student>studies = new ArrayList<Student>(); 
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Student> getStudies() {
		return studies;
	}
	public void setStudies(ArrayList<Student> studies) {
		this.studies = studies;
	}
	
	
}

