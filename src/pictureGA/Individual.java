package pictureGA;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Individual implements IPaintable{
	public final int GENE_SIZE = 8;
	public final int ALPHA_SIZE = 100;
	public final int OVAL_SIZE = 50;
	public final int RGB_SIZE = 255;
	public final int NUM_CIRCLES = 100;
	private int alpha;
	private int red;
	private int green;
	private int blue;
	private int x;
	private int y;
	private int width;
	private int height;
	public BufferedImage img;
	public double[] genes;
	private int fitness;
	
	public int getFitness()
	{
		return fitness;
	}
	
	public int size()
	{
		int arraySize = GENE_SIZE * NUM_CIRCLES;
		return arraySize;
	}
	public Individual()
	{
		
		int counter = 0;
		genes = new double[size()];
		for(int i = 0;i< size(); i++)
		{
			genes[i] = Math.random();
		}
		
		
		
	}
	
	
	
	
	/**
	 * @param alpha
	 * @param red
	 * @param green
	 * @param blue
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Individual(int alpha, int red, int green, int blue, int x, int y, int width, int height) {
		super();
		this.alpha = alpha;
		this.red = red;
		this.green = green;
		this.blue = blue;
		//this.x = x;
		//this.y = y;
		this.width = width;
		this.height = height;
		
	}



	public Individual(double[] tempGenes) {
		// TODO Auto-generated constructor stub
		this.genes = tempGenes;
	}

	/**
	 * Random number generator in range [min, max]
	 * @param min The min value 
	 * @param max The max value
	 * @return 
	 */
	public int randomNumber(int min,int max)
	{
		int rand = min + (int) (Math.random() * (max - min));
		return rand;
	}
	
	public int getAlpha(double normalizedValue) {
		return (int)(normalizedValue * ALPHA_SIZE);
	}

	public int getRGB(double normalizedValue) {
		return (int)(normalizedValue * RGB_SIZE);
	}
	
	public int getX(double normalizedValue) {
		return (int)(normalizedValue * ImgPanel.WIDTH  );
	}
	public int getY(double normalizedValue) {
		return (int)(normalizedValue * ImgPanel.HEIGHT );
	}
	
	public int getWidth(double normalizedValue) {
		return (int)(normalizedValue * ImgPanel.WIDTH );
	}
	
	public int getHeight(double normalizedValue) {
		return (int)(normalizedValue * ImgPanel.HEIGHT );
	}
	
	
	
	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	public int getRed(int x,int y) {
		int  clr   = img.getRGB(x, y); 
        int  red   = (clr & 0x00ff0000) >> 16;
        return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen(int x,int y) {
		int  clr   = img.getRGB(x, y); 
        int  green = (clr & 0x0000ff00) >> 8;
        
		
		return green;
	}

	public int getBlue(int x,int y) {
		int  clr   = img.getRGB(x, y); 
        int  blue  =  clr & 0x000000ff;
		
		return blue;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double[] getGenes() {
		return genes;
	}

	public void setGenes(double[] genes) {
		this.genes = genes;
	}

	public int getGENE_SIZE() {
		return GENE_SIZE;
	}

	public void setImage(BufferedImage img)
	{
		this.img = img;
		fitness = Fitness.calcFitness(this);
	}

	
	@Override
	public void accept(IPainter painter) {
		// TODO Auto-generated method stub
		painter.paint(this);
	}
	
	public String toString()
	{
		int counter = 0;
		int alpha = 0;
		int red = 0;
		int green = 0;
		int blue = 0;
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		int circleCount = 1;
		String display = "";
		display += this.fitness;
		/*	for(int i = 0;i<size();i++)
		{
			double value = genes[i];
			switch(counter)
			{
			case 0:
				red = getRGB(value);
				counter++;
				display +="[Circle "+circleCount+ " r : " + red + ",	";
				break;
			case 1:
				green =  getRGB(value);
				counter++;
				display += " g : " + green + ", \t";
				break;
			case 2:
				blue = getRGB(value);
				counter++;
				display += " b : " + blue + ", \t";
				break;
			case 3:
				alpha = getAlpha(value);
				counter++;
				display += " a : " + alpha + ", \t";
				break;
			case 4:
				x = getX(value);
				counter++;
				display += " x : " + x + ", \t";
				break;
			case 5:
				y = getY(value);
				display += " y : " + y + ", \t";
				counter++;
				break;
			case 6:
				width = getWidth(value);
				counter++;
				display += " width : " + width + ", \t";
				break;
			case 7:
				height = getHeight(value);
				display += " height : " + height + ", \t Fitness : " + this.fitness + " ]; \n";
				circleCount++;
				counter = 0;
				break;
			}
		}*/
		
		return display;
	}
	
	
	
}
