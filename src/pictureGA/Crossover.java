package pictureGA;

import java.util.Random;



public class Crossover {
	public static double mutationRate = 0.15;
	public static double uniformRate = 0.5;
	
	
	public static Individual randCrossover(Individual parent1, Individual parent2)
	{
		Individual temp = new Individual();
		//temp.initIndividual();
		for(int i = 0; i < parent1.size();i++)
		{
			if(Math.random() <= uniformRate)
			{
				temp.genes[i] = parent1.genes[i];
			}
			else
			{
				temp.genes[i] = parent2.genes[i];
			}
		}
		return temp;
	}
	public static Individual crossover(Individual parent1, Individual parent2)
	{
		Individual child;
		int crossPoint1 = randomNumber(0, parent1.size());
		//int crossPoint2 = randomNumber(crossPoint1, parent1.size());
		double[] tempGenes = new double[parent1.size()];
		for(int i = 0; i < crossPoint1; i++ )
		{
			tempGenes[i] = parent1.genes[i];
		}
		for(int i = crossPoint1; i < parent1.size(); i++)
		{
			tempGenes[i] = parent2.genes[i];
		}
		
		child = new Individual(tempGenes);
		return child;
	}
	
	public static int randomNumber(int min,int max)
	{
		int rand = min + (int)(Math.random()*(max - min));
		return rand;
				
	}
	
	public static Individual twoPointCrossover(Individual parent1,Individual parent2)
	{
		int crossOverPoint1 = randomNumber(0, parent1.size());
		int crossOverPoint2 = randomNumber(crossOverPoint1, parent1.size());
		Individual child = new Individual();
		for(int i = 0; i < crossOverPoint1; i++)
		{
			child.genes[i] = parent1.genes[i];
		}
		
		for(int i = crossOverPoint1; i < crossOverPoint2; i++)
		{
			child.genes[i] = parent2.genes[i];
		}
		
		for(int i = crossOverPoint2; i < parent1.size(); i++)
		{
			child.genes[i] = parent1.genes[i];
		}
		return child;
		
	}
	public static boolean existsInArray(int[] array, int value)
	{
		for(int i = 0; i < array.length -1; i++)
		{
			if(array[i] == value)
			{
				return true;
			}
		}
		return false;
	}
	public static void mutate(Individual indiv)
	{
		int numGenesToMutate = randomNumber(0, indiv.size());
		boolean mutate = false;
		Random r = new Random();
		for(int i = 0; i < indiv.size(); i++)
		{
			if(Math.random() <= mutationRate)
			{
				double rand = Math.random();
				indiv.genes[i] = rand;
			
			}
			
				

		}
		
	}
	
}
