//IAKOVOS EVDAIMON 3130059
package ergasia1;

import java.util.ArrayList;
import java.util.Random;

public class Chromosome implements Comparable<Chromosome>{
	private Collection collector;
	private ArrayList<SchoolDepartments> departments;
	private ArrayList<Teachers> teachers;
	private int fitness;
	private int size;

	
	public Chromosome( ArrayList<Lessons> lessons,
			ArrayList<SchoolDepartments> dpms, ArrayList<Teachers> teachers) {

		this.collector = new Collection(teachers, lessons, dpms);
		
		this.fitness = 0;

		this.departments = new ArrayList<SchoolDepartments>(dpms);
		this.teachers = new ArrayList<Teachers>(teachers);

		this.size = this.collector.getSize();
		
		this.calculateFitness(teachers, departments);
	}

	
	public Chromosome(Collection collector, ArrayList<Teachers> teachers,
						ArrayList<SchoolDepartments> dpms) {
		
		this.departments = new ArrayList<SchoolDepartments>(dpms);
		this.teachers = new ArrayList<Teachers>(teachers);

		this.collector = new Collection(collector);

		this.size = this.collector.getSize();

		this.calculateFitness(teachers, departments);
	}

	
	private void calculateFitness(ArrayList<Teachers> teachers, ArrayList<SchoolDepartments> dp ) {
		State temp = new State(UsefulMethods.finalSchedule(), this.collector, teachers, dp);

		this.fitness = temp.getFitness();

	}
	

	
	public Collection getCollection(){
		return this.collector;
	}

	
	public ConcreteLesson getCollectionLesson(int i) {
		return this.collector.getLesson(i);
	}

	
	public DayTime getCollectionDayTime(int i) {
		return this.collector.getDayTime(i);
	}

	
	public int getSize() {
		return this.size;
	}

	
	public int getFitness() {
		return this.fitness;
	}

	
	public void mutate(ArrayList<DayTime> dt) {
		Random r = new Random(System.currentTimeMillis());

		int random1 = r.nextInt(this.collector.getSize());
		int random2 = r.nextInt(dt.size());

		DayTime randomDayTime = new DayTime(dt.get(random2));

		this.collector.setDayTime(random1, randomDayTime);

		this.calculateFitness(this.teachers,this.departments);
	}

	
	public void print() {
		this.collector.print();
	}

	@Override
	public String toString() {
		return "Chromosome [collection=" + collector + ", fitness=" + fitness + "]";
	}
	
	//@Override
	public int compareTo(Chromosome x) {
		return this.fitness - x.getFitness();
	}

	
}
