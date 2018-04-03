package pictureGA;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Painter implements IPainter {
	//Color c;
	static Graphics g;
	static BufferedImage image;
	public Painter(Graphics g)
	{
		this.g= g;
		
	}
	
	public static BufferedImage getImage()
	{
		return image;
	}
	
	@Override
	public void paint(Individual individual) {
		
		image = new BufferedImage(ImgPanel.WIDTH, ImgPanel.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g = image.createGraphics();
        
		//Color c = new Color(individual.getRed(), individual.getGreen(), individual.getBlue(), individual.getAlpha());
		int counter = 0;
		int alpha = 0;
		int red = 0;
		int green = 0;
		int blue = 0;
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		
        
		for(int i = 0;i<individual.size();i++)
		{
			double value = individual.getGenes()[i];
			switch(counter)
			{
			case 0:
				red = individual.getRGB(value);
				counter++;
				break;
			case 1:
				green =  individual.getRGB(value);
				counter++;
				break;
			case 2:
				blue = individual.getRGB(value);
				counter++;
				break;
			case 3:
				alpha = individual.getAlpha(value);
				counter++;
				break;
			case 4:
				x = individual.getX(value);
				counter++;
				break;
			case 5:
				y = individual.getY(value);
				counter++;
				break;
			case 6:
				width = individual.getWidth(value);
				counter++;
				break;
			case 7:
				height = individual.getHeight(value);
				//graphics2D.setBackground(Color.WHITE);
				Color c = new Color(red, green, blue, alpha);
				g.setColor(c);
				g.fillOval(x, y, width, height);
				//g.setPaint (c);
		        //graphics2D.fillRect ( 0,0,1000,1000 );
		       // graphics2D.fillOval(x, y, width, height);
		        // graphics2D.dispose ();
				counter = 0;
				break;
			}
		}
		
		individual.setImage(image);
		
	}
	
public static void paintIndiv(Individual individual) {
		 
		image = new BufferedImage(ImgPanel.WIDTH, ImgPanel.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g = image.createGraphics();
        
		//Color c = new Color(individual.getRed(), individual.getGreen(), individual.getBlue(), individual.getAlpha());
		int counter = 0;
		int alpha = 0;
		int red = 0;
		int green = 0;
		int blue = 0;
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		
        
		for(int i = 0;i<individual.size();i++)
		{
			double value = individual.getGenes()[i];
			switch(counter)
			{
			case 0:
				red = individual.getRGB(value);
				counter++;
				break;
			case 1:
				green =  individual.getRGB(value);
				counter++;
				break;
			case 2:
				blue = individual.getRGB(value);
				counter++;
				break;
			case 3:
				alpha = individual.getAlpha(value);
				counter++;
				break;
			case 4:
				x = individual.getX(value);
				counter++;
				break;
			case 5:
				y = individual.getY(value);
				counter++;
				break;
			case 6:
				width = individual.getWidth(value);
				counter++;
				break;
			case 7:
				height = individual.getHeight(value);
				//graphics2D.setBackground(Color.WHITE);
				Color c = new Color(red, green, blue, alpha);
				g.setColor(c);
				g.fillOval(x, y, width, height);
				//g.setPaint (c);
		        //graphics2D.fillRect ( 0,0,1000,1000 );
		       // graphics2D.fillOval(x, y, width, height);
		        // graphics2D.dispose ();
				counter = 0;
				break;
			}
		}
		
		individual.setImage(image);
		
	}
}
