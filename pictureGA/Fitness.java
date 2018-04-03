package pictureGA;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Fitness {
	
	public static BufferedImage img;
	
	
	
	public static int calcFitness(Individual indiv)
	{
		int fitness = 0;
		int totalRed = 0;
		int totalBlue = 0;
		int totalGreen = 0;
		
		
		int totalSubtract = 0;
		int totalAdd = 0;
		int total = 0;
		
		
		for (int y = 0; y < img.getHeight(); y++) {
		    for (int x = 0; x < img.getWidth(); x++) {
		          int  clr   = img.getRGB(x, y); 
		          int  red   = (clr & 0x00ff0000) >> 16;
		          int  green = (clr & 0x0000ff00) >> 8;
		          int  blue  =  clr & 0x000000ff;
		          
		          int count = 0;
		          
		          
		          //if the color values are the same at a pixel then add 2 to the subtract varable which will be used to 
		          //subtract from the fitness. This is an incentive 
		          if(red == indiv.getRed(x, y))
		          {
		        	//totalSubtract += 200;
		        	count++;
		          }
		          if(red == indiv.getRed(x, y))
		          {
		        	//totalSubtract += 200;
		        	count++;
		          }
		          if(green == indiv.getGreen(x, y))
		          {
		        	//totalSubtract += 200;
		        	count++;
		          }
		          
		         if(count == 3)
		         {
		        	 totalSubtract += 600;
		         }
		        
		          
		          int tempRed = red - indiv.getRed(x, y);
		          int tempGreen = green - indiv.getGreen(x, y);
		          int tempBlue = blue - indiv.getBlue(x,y);
		           if(tempRed > 100)
		           {
		        	   totalAdd += 50;
		           }
		           
		           if(tempGreen > 100)
		           {
		        	   totalAdd += 50;
		           }
		           
		           if(tempBlue > 100)
		           {
		        	   totalAdd += 50;
		           }
		           
		          if(tempRed < 0)
		          {
		        	  tempRed *= -1;
		          
		          }
		          if(tempGreen < 0)
		          {
		        	  tempGreen *= -1;
		          }
		          if(tempBlue < 0)
		          {
		        	  tempBlue *= -1;
		          }
		          
		          total += tempRed + tempBlue + tempGreen; 
		          //totalRed += tempRed;
		          //totalGreen += tempGreen;
		          //totalBlue += tempBlue;
		          
		          
		          
		          
		          
		          
		          
		          
		          
		          
		        /*  
		          int counter = 0;
		  		int alpha = 0;
		  		int indivRed = 0;
		  		int indivGreen = 0;
		  		int indivBlue = 0;
		  		int indivX = 0;
		  		int indivY = 0;
		  		int width = 0;
		  		int height = 0;
		  		
		  		for(int i = 0;i<indiv.size();i++)
		  		{
		  			double value = indiv.getGenes()[i];
		  			switch(counter)
		  			{
		  			case 0:
		  				red = indiv.getRGB(value);
		  				counter++;
		  				break;
		  			case 1:
		  				green =  indiv.getRGB(value);
		  				counter++;
		  				break;
		  			case 2:
		  				blue = indiv.getRGB(value);
		  				counter++;
		  				break;
		  			case 3:
		  				alpha = indiv.getAlpha(value);
		  				counter++;
		  				break;
		  			case 4:
		  				x = indiv.getX(value);
		  				counter++;
		  				break;
		  			case 5:
		  				y = indiv.getY(value);
		  				counter++;
		  				break;
		  			case 6:
		  				width = indiv.getWidth(value);
		  				counter++;
		  				break;
		  			case 7:
		  				height = indiv.getHeight(value);
		  				Color c = new Color(red, green, blue, alpha);
		  				
		  				counter = 0;
		  				break;
		  			}
		  		}*/
		    }
		}
		//add the penalties and subtract the rewards 
		fitness = (total + totalAdd) - totalSubtract;
		
		return fitness;
	}
}
