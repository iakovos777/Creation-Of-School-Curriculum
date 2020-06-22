//IAKOVOS EVDAIMON 3130059
package ergasia1;

import java.util.ArrayList;

public class ConcreteLesson {
	private Teachers teacher;
	private String department;
	private String lessonName;
	private String lessonCode;
	private ArrayList<String> properTeachers;
	private int hours;

	/**
	 * Empty Constructor
	 * */
	public ConcreteLesson() {

	}

	public ArrayList<String> getProperTeachers(){
		return properTeachers;
	}
	
	public void setProperTeachers(ArrayList<String> propteach){
		this.properTeachers = propteach;
		
	}
	
	public String getLessonName() {
		return this.lessonName;
	}

	
	public void setLessonName(String name) {
		this.lessonName = name;
	}

	
	public Teachers getTeacher() {
		return this.teacher;
	}

	
	public void setTeacher(Teachers teacher) {
		this.teacher = teacher;
	}

	

	
	public String getDepartment() {
		return department;
	}

	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getLessonCode() {
		return lessonCode;
	}

	
	public void setHours(int hours) {
		this.hours=hours;
	}
	
	public int getHours() {
		return hours;
	}

	
	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}
	
	

	@Override
	public String toString() {
		return this.lessonName;
	}
}
