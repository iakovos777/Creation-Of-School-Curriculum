//IAKOVOS EVDAIMON 3130059
package ergasia1;




import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Genetic {

	//ArrayList that contains the current population of chromosomes
		private ArrayList<Chromosome> population;
	    
		private ArrayList<Integer> fitnessBounds;

	private ArrayList<Lessons> lessons;
	private ArrayList<SchoolDepartments> sdpms;
	private ArrayList<Teachers> teachers;
	

	
	public Genetic(ArrayList<Lessons> less,ArrayList<SchoolDepartments> sDepartments,
				   ArrayList<Teachers> teach) {
		
		this.lessons = new ArrayList<Lessons>(less);
		this.sdpms = new ArrayList<SchoolDepartments>(sDepartments);
		this.teachers = new ArrayList<Teachers>(teach);
		this.population = null;
		this.fitnessBounds = null;
		
	}

	
	

	
	public Chromosome geneticAlgorithm(int populationSize,double mutationProbability, int minimumFitness, int maximumSteps) {
		initializePopulation(populationSize);
		Random r = new Random(System.currentTimeMillis());
		
		for(int step=0;step<maximumSteps;step++){
			
			ArrayList<Chromosome> newPopulation = new ArrayList<Chromosome>();
			//check
			//System.out.println(newPopulation.size());
			
			for(int i=0;i<populationSize;i++){
				//System.out.println(this.fitnessBounds.size());
				int xIndex = this.fitnessBounds.get(r.nextInt(this.fitnessBounds.size()));
				
				
				
				Chromosome x = this.population.get(xIndex);
				
				int yIndex = this.fitnessBounds.get(r.nextInt(this.fitnessBounds.size()));
				while(yIndex == xIndex)
				{
					yIndex = this.fitnessBounds.get(r.nextInt(this.fitnessBounds.size()));
				}
				Chromosome y = this.population.get(yIndex);
				
				Chromosome child = this.reproduce(x, y);
				
				if(r.nextDouble() < mutationProbability)
				{
					child.mutate(UsefulMethods.initializeDayTimeArray());
				}
				
				newPopulation.add(child);	
			}
			this.population = new ArrayList<Chromosome>(newPopulation);
			//System.out.println(this.population.size());
			Collections.sort(this.population, Collections.reverseOrder());
            
			
			if(this.population.get(0).getFitness() >= minimumFitness)
			{
                System.out.println("Finished after " + step + " steps...");
				return this.population.get(0);
			}
			
            //We update the fitnessBounds arrayList
			this.updateFitnessBounds();
		}

        System.out.println("Finished after " + maximumSteps + " steps...");
		return this.population.get(0);
	}

	/**
	 *  Initialize population 
	 *  @param populationSize The size of the population we need.
	 *  */
	public void initializePopulation(int populationSize) {
			this.population= new ArrayList<Chromosome>();
		
		for (int i = 0; i < populationSize; i++) {
			this.population.add(new Chromosome(this.lessons, this.sdpms, this.teachers));
		}
		this.updateFitnessBounds();
	}

	
	public void updateFitnessBounds() {
		this.fitnessBounds = new ArrayList<Integer>();
		
		for (int i = 0; i < this.population.size(); i++) {
			//System.out.println(this.population.get(i).getFitness());
			for (int j = 0; j < this.population.get(i).getFitness(); j++) {				
				this.fitnessBounds.add(i);
			}
		}
	}
	
	public Chromosome reproduce(Chromosome x, Chromosome y) {		
		Random r = new Random();
		Collection childGenes=new Collection();
		
		/*check
		System.out.println(x.getSize());*/
		
		// Randomly choose the intersection point
		int intersectionPoint = r.nextInt(x.getSize());
		
		for(int i=0;i<intersectionPoint;i++){
			childGenes.addLesson(x.getCollectionLesson(i));
			childGenes.addDayTime(x.getCollectionDayTime(i));
		}
		
		for(int i=intersectionPoint; i<x.getSize(); i++)
		{
			childGenes.addLesson(y.getCollectionLesson(i));
			childGenes.addDayTime(y.getCollectionDayTime(i));
		}
		return new Chromosome(childGenes,teachers,sdpms);
	}

}