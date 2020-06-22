
//IAKOVOS EVDAIMON 3130059
package ergasia1;

import java.util.ArrayList;

public class Schedule {
	/*ArrayLists Declaration*/
	private ArrayList<int[]> hoursDayTeacher;
	private ArrayList<String> lesson;
	private ArrayList<Integer> hoursWeekTeacher;
	private ArrayList<String> department;
	private ArrayList<String> teacher;
	private ArrayList<ArrayList<String>> availableTeachers;
	

	/*Strings Declaration*/
	private String time;
	private String day;
	

	
	public Schedule(String time, String day){
		
		hoursDayTeacher = new ArrayList<int[]>();
		lesson = new ArrayList<String>();
		hoursWeekTeacher = new ArrayList<Integer>();
		department = new ArrayList<String>();
		availableTeachers =  new ArrayList<ArrayList<String>>();
		
		teacher = new ArrayList<String>();
		
		
		this.time = time;
		this.day = day;
	}
	
	
	public Schedule(){
		
	}
	
	
	public void setTime(String time) {
		this.time = time;
	}
	
	
	public void setDay(String day) {
		this.day = day;
	}
	

	
	
	public void setLesson(String lesson) {
		this.lesson.add(lesson);
	}
	
	
	public void setAllLessons(ArrayList<String> lessons){
		this.lesson.addAll(lessons);
	}
	
	
	
	public void setTeacher(String teacher) {
		this.teacher.add(teacher);
	}
	
	public void setAllTeachers(ArrayList<String> teachers){
		this.teacher.addAll(teachers);
	}
	
	
	
	
	public void setHoursDayTeacher(int[] hours) {
		this.hoursDayTeacher.add(hours);
	}
	
	public void setAllHoursDayTeacher(ArrayList<int[]> hoursDayTeacher){
		this.hoursDayTeacher.addAll(hoursDayTeacher);
	}
	
	public void setHoursWeekTeacher(int hours) {
		this.hoursWeekTeacher.add(hours);
	}
	
	public void setAllHoursWeekTeacher(ArrayList<Integer> hoursWeekTeacher){
		this.hoursWeekTeacher.addAll(hoursWeekTeacher);
	}
	
	public void setAvailableTeachers(ArrayList<String> teachers) {
		this.availableTeachers.add(teachers);
	}
	
	public void setAllAvailableTeachers(ArrayList<ArrayList<String>> availableTeachers){
		this.availableTeachers.addAll(availableTeachers);
	}
	
	public void setDepartment(String department) {
		this.department.add(department);
	}
	
	public void setAllDepartment(ArrayList<String> department){
		this.department.addAll(department);
	}

	
	
	
	
	public String getLesson(int position) {
		return this.lesson.get(position);
	}
	
	
	public int[] getHoursDayTeacher(int position) {
		return this.hoursDayTeacher.get(position);
	}

	
	public String getDepartment(int position) {
		return this.department.get(position);
	}
	
	
	public int getHoursWeekTeacher(int position) {
		return this.hoursWeekTeacher.get(position);
	}
	
	
	public ArrayList<String> getAvailableTeachers(int position) {
		return this.availableTeachers.get(position);
	}
	
	
	
	
	public String getTeacher(int position) {
		return this.teacher.get(position);
	}
	
	
	public ArrayList<String> getDepartmentList() {
		return this.department;
	}
	
	
	public ArrayList<int[]> getHoursDayTeacherList() {
		return this.hoursDayTeacher;
	}
	
	
	public ArrayList<String> getLessonsList(){
		return this.lesson;
	}
	
	
	public ArrayList<String> getTeachersList(){
		return this.teacher;
	}
	
	
	public ArrayList<Integer> getHoursWeekTeacherList() {
		return this.hoursWeekTeacher;
	}
	
	
	public ArrayList<ArrayList<String>> getAvailableTeachersList(){
		return this.availableTeachers;
	}
	
	
	

	public String getDay() {
		return this.day;
	}
	

	public String getTime() {
		return this.time;
	}
	
	
	
	
	public int  getDepartmentsSize(){
		return this.department.size();
	}
	
	public int  getAvailableTeachersSize(){
		return this.availableTeachers.size();
	}
	
	
	public int getLessonSize(){
		return this.lesson.size();
	}
	
	
	public int getHoursDayTeacherSize(){
		return this.hoursDayTeacher.size();
	}
	
	
	public int getHoursWeekTeacher(){
		return this.hoursWeekTeacher.size();
	}
	
	
	
	
	public int getTeacherSize(){
		return this.teacher.size();
	}
	
	
	
	
	@Override
	public String toString(){
		return this.day+" "+this.time;
	}

}
