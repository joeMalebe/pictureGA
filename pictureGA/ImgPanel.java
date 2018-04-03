package pictureGA;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImgPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Painter painter;
	Individual i;
	Population pop;
	private boolean pause = false;
	public static final int WIDTH = Fitness.img.getWidth();
	public static final int HEIGHT = Fitness.img.getHeight();
	public ImgPanel()
	{
		i = new Individual();
		this.setSize(WIDTH, HEIGHT);
		//this.setLayout(new FlowLayout());
		//this.setFocusable(true);
		this.setVisible(true);
		//pop = new Population(150);
		//run();
	}
	
	
	public void run(Individual individual)
	{
		/*int gen = 1;
		while(true){
			//
			pop.drawPopulation();
			i = pop.getFittest();
			 if(pause)
			 {
				 System.out.println("pause");
			 }
			
			
			System.out.println("generation : "+ gen + " Total Fitness : " + pop.getTotalFitness());
			
			repaint();
			pop = Evolution.evolve(pop);
			gen++;
		}*/
		i = individual;
		repaint();
	}
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Painter.g = g;
		//painter = new Painter(g);
		//pop.drawPopulation(painter);
		//i.accept(painter);
		//System.out.println(i);
		//BufferedImage i = Painter.getImage();
		g.drawImage(i.img, 0, 0, this);
		
		
	}


	
	
}
