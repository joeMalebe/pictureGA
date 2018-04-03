package pictureGA;


public class Evolution {
	public static Population evolve(Population population)
	{
		Population newPopulation = new Population(population.size());
		for(int i = 0; i < population.size(); i++)
		{
			/*int index1 = Selection.rouletteWheelSelection(population);
			int index2 = Selection.rouletteWheelSelection(population);
			Individual parent1 = population.individuals[index1];
			Individual parent2 = population.individuals[index2];
			*/
			
			
			Individual parent1 = Selection.tournamentSelection(population);
			Individual parent2 = Selection.tournamentSelection(population);
			Individual child1 = Crossover.twoPointCrossover(parent1, parent2);
			//Individual child2 = Crossover.crossover(parent2, parent1);
			/*if(population.size() % 2 > 0)
			{
				Crossover.mutate(child1);
				Crossover.mutate(child2);
				newPopulation.individuals[i] = child1;
				newPopulation.individuals[i + 1] = child2;
			}
			else{
				if(i == population.size() - 1)
				{
					Crossover.mutate(child1);
					//Crossover.mutate(child2);
					newPopulation.individuals[i] = child1;
					
				}
			}*/
			Crossover.mutate(child1);
			/*Crossover.mutate(child2);
			Individual[] family = {
				parent1,
				parent2,
				child1,
				child2
			};
			Selection.tournamentSelection(family);
			*///Crossover.mutate(child2);
			//newPopulation.saveIndividual(i, child1);
			//Painter.paintIndiv(child1);
			newPopulation.saveIndividual(i, child1);
			
			
			
		}
		Individual elitism = population.getFittest();
		//Individual elitismMutated = elitism;
		
		//Crossover.mutate(elitismMutated);
				//newPopulation.individuals[newPopulation.size() - 1] = elitism;
				newPopulation.setIndividual(0, elitism);
		return newPopulation;
	}
}

