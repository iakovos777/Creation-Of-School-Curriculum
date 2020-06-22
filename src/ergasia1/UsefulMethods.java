//IAKOVOS EVDAIMON 3130059
package ergasia1;

import java.util.ArrayList;
import java.util.Random;

public class UsefulMethods {
	
	public UsefulMethods(){
		
	}
	
	public static ArrayList<DayTime> initializeDayTimeArray(){
		ArrayList<DayTime> dayTime = new ArrayList<DayTime>();
		
			for(int i=0;i<5;i++){
				for(int j=0;j<7;j++){
					DayTime temp = new DayTime();
					temp.setDay(UsefulMethods.day(i));
					temp.setTime(UsefulMethods.time(j));
					dayTime.add(temp);
				}
			}
			
		
		return dayTime;
	}

	private static String day(int i) {
		switch (i) {
        case 0:  return "Monday";
		case 1:  return "Tuesday";
                 
        case 2:  return "Wednesday";
                 
        case 3:  return "Thursday";
                 
        case 4:  return "Friday";
                 
        
        default: throw new InvalidError("Invalid day");
		}
	}

	private static String time(int j) {
		switch (j) {
        case 0:  return "8:15-9:00";
		case 1:  return "9:00-9:45";
                 
        case 2:  return "10:00-10:45";
                 
        case 3:  return "10:45-11:30";
                 
        case 4:  return "11:45-12:30";
        
        case 5:  return "12:30-13:15";
        
        case 6: return "13.30-14.15";
        
        default: throw new InvalidError("Invalid ");
		}
	}
	/* mia ulopoihsh me tuxaious kathigites ana mathima pou mporei 
		na mhn kanoun kan to mathima ayto */
	public static ArrayList<ConcreteLesson> initConcretLessonArray(
			ArrayList<Lessons> less, ArrayList<Teachers> teachers,ArrayList<SchoolDepartments>dep) {
		ArrayList<ConcreteLesson> lessons = new ArrayList<ConcreteLesson>();
		Random random = new Random(System.currentTimeMillis());
		int[] countDepart = new int[3];
		 countDepart = UsefulMethods.DepartmentsOfEachClass(dep);
		
		for(int j=0;j<less.size();j++){
			
			if(less.get(j).getSchoolClass().equals("A")){
				for(int i=0;i<countDepart[0];i++){
					for(int k=0;k<less.get(j).getHours();k++){
						int randomTeacher = random.nextInt(teachers.size());
						ConcreteLesson cl = new ConcreteLesson();
						int stringI = i+1;
						String str = Integer.toString(stringI);
						cl.setLessonName(less.get(j).getLessonName());
						cl.setDepartment(less.get(j).getSchoolClass()+str);
						cl.setHours(less.get(j).getHours());
						cl.setLessonCode(less.get(j).getLessonCode());
						cl.setProperTeachers(UsefulMethods.findTeacher(teachers,less.get(j)));
						cl.setTeacher(teachers.get(randomTeacher));
						lessons.add(cl);
					}
				}
			}
			else if(less.get(j).getSchoolClass().equals("B")){
				for(int i=0;i<countDepart[1];i++){
					for(int k=0;k<less.get(j).getHours();k++){
						int randomTeacher = random.nextInt(teachers.size());
						ConcreteLesson cl = new ConcreteLesson();
						int stringI = i+1;
						String str = Integer.toString(stringI);
						cl.setLessonName(less.get(j).getLessonName());
						cl.setDepartment(less.get(j).getSchoolClass()+str);
						cl.setHours(less.get(j).getHours());
						cl.setLessonCode(less.get(j).getLessonCode());
						cl.setProperTeachers(UsefulMethods.findTeacher(teachers,less.get(j)));
						cl.setTeacher(teachers.get(randomTeacher));
						lessons.add(cl);
					}
				}
			}
			else if(less.get(j).getSchoolClass().equals("C")){
				for(int i=0;i<countDepart[2];i++){
					for(int k=0;k<less.get(j).getHours();k++){
						int randomTeacher = random.nextInt(teachers.size());
						ConcreteLesson cl = new ConcreteLesson();
						int stringI = i+1;
						String str = Integer.toString(stringI);
						cl.setLessonName(less.get(j).getLessonName());
						cl.setDepartment(less.get(j).getSchoolClass()+str);
						cl.setHours(less.get(j).getHours());
						cl.setLessonCode(less.get(j).getLessonCode());
						cl.setProperTeachers(UsefulMethods.findTeacher(teachers,less.get(j)));
						cl.setTeacher(teachers.get(randomTeacher));
						lessons.add(cl);
					}
				}
			}
		}
		
		return lessons;
	}
	
	
	private static ArrayList<String> findTeacher(ArrayList<Teachers> teach,Lessons l){
		ArrayList<String> teachers = new ArrayList<String>();
		
		
		for(int i=0; i<teach.size();i++){
			String[] t=teach.get(i).getLessonCode();			
			for(int j=0;j<t.length;j++){				
				if(l.getLessonCode().equals(t[j])){
					teachers.add(teach.get(i).getTeacherName()+" "+teach.get(i).getTeacherCode());
					
				}
			}
		}
		return teachers;
	} 
	//metraei ta tmimata ana taksi-mporei kathe taksi diaforetiko arithmo tmhmatwn
	public static int[] DepartmentsOfEachClass(ArrayList<SchoolDepartments> dep){
		int[] numberOfDepartments = new int[3];
		
		for(int i=0;i<numberOfDepartments.length;i++){
			numberOfDepartments[i]=0;
		}
		for(int i=0;i<dep.size();i++){
			
			if(dep.get(i).getSClass().equals("A")){
				numberOfDepartments[0]++;
				
			}
			else if(dep.get(i).getSClass().equals("B")){
				numberOfDepartments[1]++;
			}
			else if(dep.get(i).getSClass().equals("C")){
				numberOfDepartments[2]++;
			}
		}
		
		return numberOfDepartments;	
	}
	/* mia ulopoihsh me tuxaious kathigites ana mathima pou 
	   kanoun omws  to mathima ayto */
	
	public static ArrayList<ConcreteLesson> initConcretLessonArrayCorrectTeacher(
			ArrayList<Lessons> less, ArrayList<Teachers> teachers,ArrayList<SchoolDepartments>dep) {
		
		ArrayList<ConcreteLesson> lessons = new ArrayList<ConcreteLesson>();
		Random random = new Random(System.currentTimeMillis());
		int[] countDepart = new int[3];
		countDepart = UsefulMethods.DepartmentsOfEachClass(dep);
		
		
		for(int j=0;j<less.size();j++){
			
			if(less.get(j).getSchoolClass().equals("A")){
				
				for(int i=0;i<countDepart[0];i++){
					for(int k=0;k<less.get(j).getHours();k++){
						
						ConcreteLesson cl = new ConcreteLesson();
						
						int stringI = i+1;
						String str = Integer.toString(stringI);
						cl.setLessonName(less.get(j).getLessonName());
						cl.setDepartment(less.get(j).getSchoolClass()+str);
						cl.setHours(less.get(j).getHours());
						cl.setLessonCode(less.get(j).getLessonCode());
						cl.setProperTeachers(UsefulMethods.findTeacher(teachers,less.get(j)));
						
						ArrayList<String> proper = cl.getProperTeachers(); 
						
						int randomTeacher = random.nextInt(proper.size());
						String tc = proper.get(randomTeacher);
						Teachers t = UsefulMethods.takeTeacher(tc,teachers);
						
						cl.setTeacher(t);
						lessons.add(cl);
					}
				}
			}
			else if(less.get(j).getSchoolClass().equals("B")){
				for(int i=0;i<countDepart[1];i++){
					for(int k=0;k<less.get(j).getHours();k++){
						
						ConcreteLesson cl = new ConcreteLesson();
						int stringI = i+1;
						String str = Integer.toString(stringI);
						cl.setLessonName(less.get(j).getLessonName());
						cl.setDepartment(less.get(j).getSchoolClass()+str);
						cl.setHours(less.get(j).getHours());
						cl.setLessonCode(less.get(j).getLessonCode());
						cl.setProperTeachers(UsefulMethods.findTeacher(teachers,less.get(j)));
						ArrayList<String> proper = cl.getProperTeachers(); 
						
						int randomTeacher = random.nextInt(proper.size());
						String tc = proper.get(randomTeacher);
						Teachers t = UsefulMethods.takeTeacher(tc,teachers);
						
						cl.setTeacher(t);
						lessons.add(cl);
					}
				}
			}
			else if(less.get(j).getSchoolClass().equals("C")){
				for(int i=0;i<countDepart[2];i++){
					for(int k=0;k<less.get(j).getHours();k++){
						
						ConcreteLesson cl = new ConcreteLesson();
						int stringI = i+1;
						String str = Integer.toString(stringI);
						cl.setLessonName(less.get(j).getLessonName());
						cl.setDepartment(less.get(j).getSchoolClass()+str);
						cl.setHours(less.get(j).getHours());
						cl.setLessonCode(less.get(j).getLessonCode());
						cl.setProperTeachers(UsefulMethods.findTeacher(teachers,less.get(j)));
						ArrayList<String> proper = cl.getProperTeachers(); 
						
						int randomTeacher = random.nextInt(proper.size());
						String tc = proper.get(randomTeacher);
						Teachers t = UsefulMethods.takeTeacher(tc,teachers);
						
						cl.setTeacher(t);
						lessons.add(cl);
					}
				}
			}
		}
		
		return lessons;
	}
	
	public static Teachers takeTeacher(String tc, ArrayList<Teachers> teachers) {
		for(int i=0;i<teachers.size();i++){
			if(tc.equals(teachers.get(i).getTeacherName()+" "+teachers.get(i).getTeacherCode())){
				return teachers.get(i);
			}
		}
		return null;
	}

	/*
	private static boolean correctTeacher(String[] proper, String tc) {
		for(int i=0; i<proper.length;i++){
			if(tc.equals(proper[i])){
				return true;
			}
		}
		return false;
	}
	*/
	
	
	public static ArrayList<Schedule> finalSchedule(){
		ArrayList<Schedule> schedule = new ArrayList<Schedule>();
		for(int i=0;i<5;i++){
			for(int j=0;j<7;j++){
				Schedule temp = new Schedule(UsefulMethods.time(j),UsefulMethods.day(i));
				
				schedule.add(temp);
			}
		}
		return schedule;
	}

	

}
