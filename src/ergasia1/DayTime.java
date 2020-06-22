//IAKOVOS EVDAIMON 3130059
package ergasia1;

public class DayTime {
	
	private String day;
	private String time;
	

	
	public DayTime() {

	}

	
	public DayTime(String day, String time) {
		this.day = day;
		this.time = time;
		
	}

	
	public DayTime(DayTime dayTime) {
		this.day = dayTime.getDay();
		this.time = dayTime.getTime();
	}


	public String getDay() {
		return day;
	}

	
	public void setDay(String day) {
		this.day = day;
	}
	
	
	public String getTime() {
		return time;
	}

	
	public void setTime(String time) {
		this.time = time;
	}

	

	@Override
	public String toString() {
		return this.day + " -- "  + this.time;
	}
}
