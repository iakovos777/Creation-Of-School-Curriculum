//IAKOVOS EVDAIMON 3130059
package ergasia1;

public class Lessons {
	private String schoolClass;
    private String lessonName;
    private int hours;
    private String lessonCode;
    
    
	public Lessons () {
		
	}	
        
    public Lessons (String schoolClass, String lessonName, int hours, String lessonCode) {
    	
    	
        this.schoolClass = schoolClass;
        this.lessonName = lessonName;
        this.hours= hours;
        this.lessonCode = lessonCode;

    }
    
    public String getSchoolClass() {
        return this.schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getLessonName() {
        return this.lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getHours() {
        return this.hours;
    }

    public void setHours(int hours) {
        this.hours=hours;
    }

  

    public String getLessonCode() {
        return this.lessonCode;
    }

    public void setLessonCode(String lessonCode) {
        this.lessonCode = lessonCode;
    }

}
