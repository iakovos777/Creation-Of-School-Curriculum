//IAKOVOS EVDAIMON 3130059
package ergasia1;


public class Teachers {
	private String teacherName;
	private String teacherCode;
	private int[] hoursDay;
	private int hoursWeek;
	private String[] lessonCode;

	public Teachers(){}
	
	public Teachers(String teacherName, String teacherCode, String[] lessonCode, int[] hoursDay, int hoursWeek){
		this.teacherName = teacherName;
		this.teacherCode = teacherCode;
		this.lessonCode = new String[lessonCode.length];
		this.lessonCode = lessonCode;
		this.hoursDay = new int[hoursDay.length];
		this.hoursDay = hoursDay;
		this.hoursWeek = hoursWeek;
	}

	public void setTeacherName(String teacherName){
		this.teacherName = teacherName;
	}
	
	public void setTeacherCode(String teacherCode){
		this.teacherCode = teacherCode;
	}
	
	public void setLessonCode(String[] lessonCode){
		this.lessonCode = new String[lessonCode.length];
		this.lessonCode = lessonCode;
	}
	
	public void setHoursDay(int[] hoursDay){
		this.hoursDay = new int[hoursDay.length];
		this.hoursDay = hoursDay;
	}
	
	public void setHoursWeek(int hoursWeek){
		this.hoursWeek = hoursWeek;
	}
	
	public String getTeacherName(){
		return this.teacherName;
	}
	
	public String getTeacherCode(){
		return this.teacherCode;
	}
	
	public String[] getLessonCode(){
		return this.lessonCode;
	}
	
	public int[] getHoursDay(){
		return this.hoursDay;
	}
	
	public int getHoursWeek(){
		return this.hoursWeek;
	}

}
