//IAKOVOS EVDAIMON 3130059
package ergasia1;

import java.util.ArrayList;
import java.util.Random;

public class Collection {
	private ArrayList<ConcreteLesson> cLessons;
	private ArrayList<DayTime> dayTimeArray;
	

	/*Main Constructor*/
	public Collection(ArrayList<Teachers> teachers, ArrayList<Lessons> less, ArrayList<SchoolDepartments> departments) {
		
		this.cLessons = new ArrayList<ConcreteLesson>();
		
		this.dayTimeArray = new ArrayList<DayTime>();
		
		Random r = new Random(System.currentTimeMillis());

		ArrayList<ConcreteLesson> lessons = new ArrayList<ConcreteLesson>();
		
		lessons = UsefulMethods.initConcretLessonArrayCorrectTeacher(less, teachers,departments);
		
		
		
		
		
		ArrayList<DayTime> dayTime = new ArrayList<DayTime>();
		dayTime = UsefulMethods.initializeDayTimeArray();
		
		for (int i = 0; i < lessons.size(); i++) {
			this.cLessons.add(lessons.get(i));
			
			
			int rand = r.nextInt(dayTime.size());
			if((cLessons.size()>0)&&(dayTimeArray.size()>0)){
				for(int j=0;j< cLessons.size()-1;j++){
					boolean dep=cLessons.get(j).getDepartment().equals(lessons.get(i).getDepartment());
					boolean t = dayTimeArray.get(j).getTime().equals(dayTime.get(rand).getTime());
					boolean da = dayTimeArray.get(j).getDay().equals(dayTime.get(rand).getDay());
					
					while((dep==true)&&(t==true)&&(da==true)){
						int k=0;
						rand = r.nextInt(dayTime.size());
						
						while(k< cLessons.size()-1){
							dep=cLessons.get(k).getDepartment().equals(lessons.get(i).getDepartment());
						
							t = dayTimeArray.get(k).getTime().equals(dayTime.get(rand).getTime());
							da = dayTimeArray.get(k).getDay().equals(dayTime.get(rand).getDay());
						     
							k++;
							if((dep==true)&&(t==true)&&(da==true))
								break;
						}
					}
					
					
				}
			}
			this.dayTimeArray.add(dayTime.get(rand));
		}
	}
	
	/*Copy Constructor*/
	public Collection(Collection collector) {
		this.cLessons = new ArrayList<ConcreteLesson>();
		this.dayTimeArray = new ArrayList<DayTime>();

		for (int i = 0; i < collector.getSize(); i++) {
			this.cLessons.add(collector.getLesson(i));
			this.dayTimeArray.add(collector.getDayTime(i));
		}
	}
	
	/*Empty Constructor*/
	public Collection() {
		this.cLessons = new ArrayList<ConcreteLesson>();
		this.dayTimeArray = new ArrayList<DayTime>();
	}


	public void addLesson(ConcreteLesson obj) {
		this.cLessons.add(obj);
	}

	
	public void addDayTime(DayTime obj) {
		this.dayTimeArray.add(obj);
	}
	
	
	public void setLesson(int index, ConcreteLesson obj) {
		this.cLessons.set(index, obj);
	}

	
	public void setDayTime(int index, DayTime obj) {
		this.dayTimeArray.set(index, obj);
	}


	public int getSize() {
		return this.cLessons.size();
	}

	
	public ConcreteLesson getLesson(int i) {
		return this.cLessons.get(i);
	}

	
	public DayTime getDayTime(int i) {
		return this.dayTimeArray.get(i);
	}

	
	public void print() {
		for (int i = 0; i < cLessons.size(); i++) {
			System.out.println(cLessons.get(i) + " --> "
					+ this.dayTimeArray.get(i));
		}
	}

	@Override
	public String toString() {
		return "Collection [Concrete lesson=" + cLessons
				+ ", dayTimeArray=" + this.dayTimeArray + "]";
	}

}
