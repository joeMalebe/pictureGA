package pictureGA;


public class Population {
	private Individual[] individuals;
	public boolean done;
	public static int POPULATION_SIZE = 50;
	
	public Population(Individual[] indiv)
	{
		this.individuals = indiv;
	}
	
	public Population(int size)
	{
		individuals = new Individual[size];
		POPULATION_SIZE = size;
		for(int i = 0; i < size; i++)
		{
			individuals[i] = new Individual();
		}
	}
	
	public Individual getFittest()
	{
		Individual min = individuals[0];
		for(int i = 0; i < POPULATION_SIZE; i ++)
		{
			if(individuals[i].getFitness() < min.getFitness())
			{
				min = individuals[i] ;
			}
		}
		return min;
	}
	
	/**
	 * @return the individuals
	 */
	public Individual[] getIndividuals() {
		return individuals;
	}
	/**
	 * @param individuals the individuals to set
	 */
	public void setIndividuals(Individual[] individuals) {
		this.individuals = individuals;
	}
	
	public long getTotalFitness()
	{
		long totalFitnessSum = 0;
		for(int i = 0; i < size(); i++)
		{
			totalFitnessSum += individuals[i].getFitness();
		}
		return totalFitnessSum;
	}

	public void saveIndividual(int index, Individual temp) {
		// TODO Auto-generated method stub
		this.individuals[index] = temp;
	}
	
	public void drawPopulation()
	{
		//start a new thread to draw each individual
		Painter.done = false;
		Painter p = new Painter(this);
		Thread d = new Thread(p);
		d.start();
		
		//done = false;
		while(d.isAlive())
		{
			//block the app while its drawing
			//System.out.println("not done");
		}
		
	}
	
	public void setIndividual(int index, Individual indiv)
	{
		this.individuals[index] = indiv;
	}
	public int size()
	{
		return individuals.length;
	}
	
 
}
