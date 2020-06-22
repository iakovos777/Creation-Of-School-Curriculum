//IAKOVOS EVDAIMON 3130059
package ergasia1;



import java.util.ArrayList;
import java.util.Random;



public class State implements Comparable<State> {

	/* String array [Days][Hours] */
	private Schedule[] schedule;

	/* Random int for Day and Hour Slots */
	
	private int randomTeacher;
	
	private int[] departments;

	/* Random variable */
	private Random r;

	/* Fitness Variable */
	public int fitness;

	/* Lessons Size */
	public int lessonsSize;
	
	private ArrayList<Teachers> teachers;

	
	
	public State(ArrayList<Schedule> scheduleList,Collection collect,ArrayList<Teachers> teachers,ArrayList<SchoolDepartments> dp){
		
		this.r = new Random(System.currentTimeMillis());
		this.schedule = new Schedule[scheduleList.size()];
		this.departments = UsefulMethods.DepartmentsOfEachClass(dp);
		this.teachers = teachers;
		for (int i = 0; i < scheduleList.size(); i++) {
			this.schedule[i] = scheduleList.get(i);
		}
		
		ConcreteLesson cl=null;//key
		DayTime dt=null;//value
				
		for (int j=0;j<collect.getSize();j++) {
			for (int i = 0; i < schedule.length; i++) {
				
				
				
				cl=collect.getLesson(j);
				dt=collect.getDayTime(j);
				
				if (dt.getDay().equals(schedule[i].getDay())&& dt.getTime().equals(schedule[i].getTime())) {
					
					
					ArrayList<String> proper = cl.getProperTeachers();	
					this.randomTeacher = r.nextInt(proper.size());
					String tc = proper.get(randomTeacher);
					Teachers t = UsefulMethods.takeTeacher(tc,teachers);
					
					
					schedule[i].setLesson(cl.getLessonName()+" "+cl.getLessonCode());
					if(t!=null){
						schedule[i].setTeacher(t.getTeacherName()+" "+t.getTeacherCode());
					
						schedule[i].setHoursDayTeacher(t.getHoursDay());					
						schedule[i].setHoursWeekTeacher(t.getHoursWeek());
					}
					schedule[i].setDepartment(cl.getDepartment());
					
					schedule[i].setAvailableTeachers(cl.getProperTeachers());
					
					
				}
			}
		}
		
		this.calculateHeuristic();	
	}

	
	
	
	


	
	public Schedule[] getSlots() {
		return this.schedule;
	}

	
	public int getFitness() {
		return this.fitness;
	}

	
	public int getScheduleArraySize() {
		return this.schedule.length;
	}

	/* Calculate Heuristic */
	private void calculateHeuristic() {
		this.fitness +=this.constraint0(false);
		this.fitness += this.constraint1(false);
		this.fitness += this.constraint2(false);
		this.fitness += this.constraint3(false);
		
		this.fitness += this.constraint5(false);
		this.fitness += this.constraint6(false);
		this.fitness += this.constraint7(false);
		this.fitness += this.constraint8(false);
		this.fitness += this.constraint9(false);
		if(this.fitness<=0){
			this.fitness = 1;
		}
		
		
		
	}
	
	
	// idio tmhma exei 2+ mathimata  idia  wra-mera
		
		private int constraint0(boolean b) {
			int counter = 100;
			
			for (int i = 0; i < schedule.length; i++) {
				if (schedule[i].getLessonSize() > 1) {
					for(int j=0;j<schedule[i].getLessonSize();j++){
						for(int k=j+1;k<schedule[i].getLessonSize();k++){	
							if(schedule[i].getDepartment(j).equals(schedule[i].getDepartment(k))){
							
														
									if (b)//for check
										System.out.println("Constrain 0 Broken at Day"
											+ schedule[i].getDay() + " "
											+ schedule[i].getTime()+ " "										
											+ schedule[i].getDepartment(k) );
									counter -= 1;
							}
						}	
					}
				}
			}
			
			if (b)// for check 
				System.out.println("0--" + counter);
			return counter;
		}

	

	

	//swstoi kathigites sto swsto mathima
	private int constraint1(boolean b) {
		int counter = 100;
		for (int i = 0; i < schedule.length; i++) {
			if (schedule[i].getLessonSize() > 1) {
				for (int j = 0; j < schedule[i].getLessonSize(); j++) {
					ArrayList<String> proper = schedule[i].getAvailableTeachers(j);
					for(int k=0;k<proper.size();k++){
						if(!(proper.get(k).equals(schedule[i].getTeacher(j)))){
						
							if (b)//for check
								System.out.println("Constrain 1 Broken at Day"
										+ schedule[i].getDay() + " "
										+ schedule[i].getTime()+ " "
										+ schedule[i].getDepartment(j));
							counter -= 1 ;
						}
						
					}
				}
			}
		}
		if (b)// for check 
			System.out.println("1--" + counter);
		return counter;
	}
	
	
	
	//kathigiths exei mathima thn idia wra se duo takseis
	private int constraint2(boolean b) {
		int counter = 100;
		for (int i = 0; i < schedule.length; i++) {
			if (schedule[i].getLessonSize() > 1) {
				for (int j = 0; j < schedule[i].getLessonSize(); j++) {
					for (int k = j + 1; k < schedule[i].getLessonSize(); k++){
						if(schedule[i].getTeacher(j).equals(schedule[i].getTeacher(k))){
													
							if (b)//for check
								System.out.println("Constrain 2 Broken at Day"
										+ schedule[i].getDay() + " "
										+ schedule[i].getTime()+ " "
										+ schedule[i].getTeacher(j)+ " "
										+ schedule[i].getLesson(k) + " "
										+ schedule[i].getDepartment(k) );
							counter -= 2;
						}
					}	
				}
			}
		}
		
		if (b)// for check 
			System.out.println("2--" + counter);
		return counter;
	}
	
	/*kathigiths douleuei perissoteres wres/mera apo oti mporei 
	h perissoteres wres/vdomada apo oti mporei*/
	
	private int constraint3(boolean b) {
		int counter = 100;	
		
		int [][] hours = new int[this.teachers.size()][5];
		for(int i=0;i<teachers.size();i++){
			for(int j=0;j<5;j++){
				hours[i][j]=0;
			}
		}
		int d =0;
		for (int i = 0; i < schedule.length; i+=7) {
			
			if(schedule[i].getLessonSize()>0){
				for(int j=0;j<schedule[i].getLessonSize();j++){
					for(int k=0;k<teachers.size();k++){
						String name = teachers.get(k).getTeacherName();
						String code = teachers.get(k).getTeacherCode();
						String t = name+code;
						if(schedule[i].getTeacher(j).equals(t)){
							hours[k][d]++;
						}
					}
				}
			}
			d++;
		}
		int sum ;
		for(int i=0;i<teachers.size();i++){
			sum =0;
			int[] p=teachers.get(i).getHoursDay();
			
			for(int j=0;j<5;j++){
				sum += hours[i][j];
				if(p[1]<hours[i][j]){
					
					if (b)
						System.out.println("Constrain3 Broken at Day:"
						+ i +" "+"Teacher:"+teachers.get(i).getTeacherName());
			
					counter -= 1;
				}
			}
			if(sum>teachers.get(i).getHoursWeek()){
				if (b)
					System.out.println("Constrain3 Broken at Week"
					+" "+"Teacher:"+teachers.get(i).getTeacherName());
		
				counter -= 1;
			}
			
		}
								
				
		if (b)
			System.out.println("3--" + counter);
		
		return counter;	
	}
	

	
	//oxi oles oi wres tou idiou mathimatos thn idia mera 
	private int constraint5(boolean b) {
		int counter = 100;
		int c1;
		int c2;
		for (int i = 0; i < schedule.length; i+=7) {
			c1=0;
			
			if (schedule[i].getLessonSize() > 1) {
				for(int l=i;l<schedule.length;l++){
					c2 =0;
					c1++;
					if(c1>6){
						break;
					}
					for (int j = 0; j < schedule[l].getLessonSize(); j++) {
					
						for(int n=l+1;n<schedule.length;n++){
							c2++;
							if(c2>6){
								break;
							}
							for (int k = 0; k < schedule[n].getLessonSize(); k++){
								if(schedule[l].getLesson(j).equals(schedule[n].getLesson(k))){
													
									if (b)//for check
										System.out.println("Constrain 5 Broken at Day"
												+ schedule[n].getDay() + " "
												+ schedule[n].getTime()+ " "
												+ schedule[n].getTeacher(k)+ " "
												+ schedule[n].getLesson(k) + " "
												+ schedule[n].getDepartment(k) );
									counter -= 1;
								}
							
							}
					
						}
					}
				}
			}
		}
		
		if (b)// for check 
			System.out.println("5--" + counter);
		return counter;
	}
	
	//wres kathigitwn omoiomorfes
	private int constraint6(boolean b) {
		int counter = 100;	
		
		int [][] hours = new int[this.teachers.size()][5];
		for(int i=0;i<teachers.size();i++){
			for(int j=0;j<5;j++){
				hours[i][j]=0;
			}
		}
		int d =0;
		for (int i = 0; i < schedule.length; i+=7) {
			
			if(schedule[i].getLessonSize()>0){
				for(int j=0;j<schedule[i].getLessonSize();j++){
					for(int k=0;k<teachers.size();k++){
						String name = teachers.get(k).getTeacherName();
						String code = teachers.get(k).getTeacherCode();
						String t = name+code;
						if(schedule[i].getTeacher(j).equals(t)){
							hours[k][d]++;
						}
					}
				}
			}
			d++;
		}
		
		for(int i=0;i<teachers.size();i++){
			for(int j=0;j<5;j++){
				for(int l=0;i<teachers.size();i++){
					for(int m=0;j<5;j++){
						if((hours[l][m]>hours[i][j]+1)||(hours[l][m]>hours[i][j]+2)){
					
							if (b)
								System.out.println("Constrain6 Broken at Day:"
										+ l +" "+"Teacher:"+teachers.get(l).getTeacherName());
			
							counter -= 1;
						}
						else if((hours[l][m]+1<hours[i][j])||(hours[l][m]+2<hours[i][j])){
					
							if (b)
								System.out.println("Constrain6 Broken at Day:"
										+ i +" "+"Teacher:"+teachers.get(i).getTeacherName());
			
							counter -= 1;
						}
					}
			
				}
			}
		
		}
								
				
		if (b)
			System.out.println("6--" + counter);
		
		return counter;	
	}
	
	//oxi kena endiamesa sto programma kai prwth wra panta mathima
	private int constraint7(boolean b) {
		int counter = 100;
		int n;
		int cDepartments =0;
		for(int i=0;i<departments.length;i++){
			cDepartments+=departments[i];
			
		}
		//System.out.println(cDepartments);//check
		for (int i = 0; i < schedule.length; i+=7) {
			if (schedule[i].getLessonSize() == cDepartments) {
				n=0;
				for (int j = i+1; j < schedule.length; j++) {
					n++;
					if(n>5){
						break;
					}
					if(schedule[i].getLessonSize()<schedule[j].getLessonSize()){
						
							
													
								if (b)//for check
									System.out.println("Constrain 7 Broken at Day"
										+ schedule[j].getDay() + " "
										+ schedule[j].getTime() );
								counter -= 1;
							
							
						}
					}
				}
				else {
					if (b)//for check
						System.out.println("Constrain 7 Broken at Day"
							+ schedule[i].getDay() + " "
							+ schedule[i].getTime() );
					counter -= 1;
				}
			}
		
		
		if (b)// for check 
			System.out.println("7--" + counter);
		return counter;
	}
	
	//oi kathigites didaskoun mexri 2 wres sunexomenes to max
	private int constraint8(boolean b) {
		int counter = 60;
		
		for (int i = 0; i < schedule.length; i+=7) {
			if(schedule[i].getLessonSize()>0){
				for(int j=0;j<schedule[i].getLessonSize();j++){
					for(int k=0;k<schedule[i+1].getLessonSize();k++){
						for(int l=0;l<schedule[i+2].getLessonSize();l++){
							if((schedule[i].getTeacher(j).equals(schedule[i+1].getTeacher(k)))
								&&(schedule[i].getTeacher(j).equals(schedule[i+2].getTeacher(l)))
								&&(schedule[i+1].getTeacher(k).equals(schedule[i+2].getTeacher(l)))){
								if (b)
									System.out.println("Constrain8 Broken at Day:"
									+ schedule[i+2].getDay()+" "+"time"+schedule[i+2].getTime()+" "
									+"Teacher:"+schedule[i+2].getTeacher(l)+" "
									+"Lesson:"+schedule[i+2].getLesson(l)+" "
									+"Department:"+schedule[i+2].getDepartment(l));
						
								counter -= 1;
							}
						}
					}
				}		
			}
		}
		
		if (b)
			System.out.println("8--" + counter);
		
		return counter;	
 
	}
	
	/*wres mathimatos deuteras >= wres mathimatos triths >=
	 *wres mathimatos tetarths>= wres mathimatos pemptis >=
	 *wres mathimatos paraskeuhs 
	 **/
	
	private int constraint9(boolean b) {
		int counter = 100;
		
		int[][]A = new int[departments[0]][5];
		int[][]B = new int[departments[1]][5];
		int[][]C = new int[departments[2]][5];	
			  
		int c = -1;		
		for (int i = 0; i < schedule.length; i+=7) {
			c++;
			for(int k=0;k<departments[0];k++){
				String arithmos = Integer.toString(k+1);
				String a = "A"+arithmos;
				int border = i+7;
				for(int j=i; j<border;j++){
					for(int l=0;l<schedule[j].getLessonSize();l++){
						if(a.equals(schedule[j].getDepartment(l))){
							A[k][c]++;
							break;
						}
					}
				}
			}
			
			for(int k=0;k<departments[1];k++){
				String arithmos = Integer.toString(k+1);
				String a = "B"+arithmos;
				int border = i+7;
				for(int j=i; j<border;j++){
					for(int l=0;l<schedule[j].getLessonSize();l++){
						if(a.equals(schedule[j].getDepartment(l))){
							B[k][c]++;
							break;
						}
					}
				}
			}
			
			for(int k=0;k<departments[2];k++){
				String arithmos = Integer.toString(k+1);
				String a = "C"+arithmos;
				int border = i+7;
				for(int j=i; j<border;j++){
					for(int l=0;l<schedule[j].getLessonSize();l++){
						if(a.equals(schedule[j].getDepartment(l))){
							A[k][c]++;
							break;
						}
					}
				}
			}
		
		}
		
		int wrong = 0;
		for(int i=0;i<departments[0];i++){
			for(int j=0;j<5;j++){
				for(int k=j+1;k<5;k++){
					if(A[i][j]<A[i][k]){
						wrong++;
						
						if (b)
							System.out.println("Constrain 9 Broken at Day:"
									+ j+1+" "+"because day"+k+1+" has more hours"
									+"Department of A class:"+i);
					}
				}
			}
		}
		
		for(int i=0;i<departments[1];i++){
			for(int j=0;j<5;j++){
				for(int k=j+1;k<5;k++){
					if(B[i][j]<B[i][k]){
						wrong++;
						
						if (b)
							System.out.println("Constrain 9 Broken at Day:"
									+ j+1+" "+"because day"+k+1+" has more hours"
									+"Department of B class:"+i);
					}
				}
			}
		}
		
		
		for(int i=0;i<departments[2];i++){
			for(int j=0;j<5;j++){
				for(int k=j+1;k<5;k++){
					if(C[i][j]<C[i][k]){
						wrong++;
						
						if (b)
							System.out.println("Constrain 9 Broken at Day:"
									+ j+1+" "+"because day"+k+1+" has more hours"
									+"Department of C class:"+i);
					}
				}
			}
		}
		
		
		counter -= wrong;
		if (b)
			System.out.println("9--" + counter);
		
		return counter;	

	}		
			
	
	
	

	
	
	/*
	 * Transforms the current State to a custom string
	 * */
	public String toString(){
		String s="";
		
		for(int i=0;i<schedule.length;i++){
			if(schedule[i].getLessonSize()>0){
				
				s+= schedule[i].getDay()+" "+"Time : "+schedule[i].getTime()+"\n";
				
				for(int j=0;j<schedule[i].getLessonSize();j++){
					s+="\tLesson : " +schedule[i].getLesson(j)+", Department : "+schedule[i].getDepartment(j)+
						", Teacher : "+schedule[i].getTeacher(j)+"\n";
					
					
				}
				s+="\n";
			}	
		}
		
		return s;
	}

	//@Override
	public int compareTo(State x) {
		return this.fitness - x.getFitness();
	}

}