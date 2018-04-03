package pictureGA;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
	public static int IMAGE_WiDTH;
	public static int IMAGE_HEIGHT;
	public static boolean pause = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedImage img = ImageIO.read(new File("./comic2.png"));
			Fitness.img = img;
			//Individual i = new Individual();
			//i.img = ImageIO.read(new File("./hello.png"));;
			//System.out.println(Fitness.calcFitness(i));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainFrame frame = new MainFrame();
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_P)
				{
					pause = !pause ;
				}
				
				
			}
		});
		
		Individual i = new Individual();
		Population pop = new Population(50);
		int gen = 1;
		while(true){
			//
			pop.drawPopulation();
			i = pop.getFittest();
			 if(pause)
			 {
				 System.out.println("pause");
			 }
			
			
			System.out.println("generation : "+ gen + "\t Total Fitness : " + pop.getTotalFitness() + "\t Fittest individual : " + pop.getFittest().getFitness());
			
			frame.imgPanel.run(i);
			pop = Evolution.evolve(pop);
			gen++;
		}
	}
	

}
