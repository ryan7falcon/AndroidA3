/**
 * Class: Student
 * This class represents a student in a database
 * @author Ryan
 */
package com.example.a3;
public class Student extends Person{

	boolean _feesPaid; /**True if the student paid the tuition fee*/
	double _gpa; /**Student's GPA*/
	
	  /**
     * Constructor.
     * @param name - The student's first and last name
     * @param address - The student's address
     * @param gpa - student GPA
     * @param feesPaid - True if the student paid the tuition fee
     */
	public Student(String name, String address, double gpa, boolean feesPaid) {
		super(name, address);
		_feesPaid = feesPaid;
		_gpa = gpa;
	}
	
	@Override
	/**returns a line messaging a status of a person (Student) 
	and whether fees have been paid or not
	@return The status string
	*/
	public String currentStatus(){
		return _feesPaid ? "Student - fees paid" : "Student - fees not paid";
	}
	
	@Override
	public String toString(){
		return super.toString() + 
				"GPA: " +  _gpa + "\n";
	}

	//Getters and setters
	public double getGpa(){
		return _gpa;
	}
	

	public void setGpa(double gpa){
		_gpa = gpa;
	}
	
	public boolean getFeesPaid(){
		return _feesPaid;
	}
	
	public void setFeesPaid(boolean feesPaid){
		_feesPaid = feesPaid;
	}
}
