package pictureGA;



public class Selection {
	public static int tournamentSize = 12;
	/**
	 *  1.[Sum] Calculate sum of all chromosome fitnesses in population - sum S.
		2.[Select] Generate random number from interval (0,S) - r.
		3.[Loop] Go through the population and sum fitnesses from 0 - sum s. 
		When the sum s is greater then r, stop and return the chromosome where you are.
	 * @param population
	 */
/*	public static int rouletteWheelSelection(Population population)
	{
		int totalFitnessSum = 0;
		int randomValue = 0;
		//[sum]
		totalFitnessSum = population.getTotalFitness();
		
		//[select]
		randomValue = randomNumber(0,totalFitnessSum);
		
		int sum = 0;
		//[loop]
		for(int i = 0; i < population.size(); i++)
		{
			sum += population.getIndividuals()[i].getFitness();
			if(sum >= randomValue)
			{
				return i;
			}
		}
		return -1;
	}*/
	
	public static int randomNumber(int min,int max)
	{
		int rand = min + (int)(Math.random()*(max - min));
		return rand;
	}
	
	public static int randomSelection(Population pop)
	{
		int index = randomNumber(0, pop.size());
		return index;
	}
	
	public static Individual tournamentSelection(Population pop)
	{
		Population tournament = new Population(tournamentSize);
		for(int i = 0; i < tournamentSize; i++)
		{
			int index = Selection.randomSelection(pop);
			Individual temp = pop.getIndividuals()[index];
			tournament.saveIndividual(i, temp);
		}
		return tournament.getFittest();
	}
	
	public static Individual tournamentSelection(Individual[] individuals)
	{
		Population tournament = new Population(individuals);
		
		return tournament.getFittest();
	}
}
