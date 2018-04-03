package pictureGA;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	public ImgPanel imgPanel;
	public GridBagLayout cb;
	public MainFrame()
	{
		cb = new GridBagLayout();
		imgPanel = new ImgPanel();
		int width = ImgPanel.WIDTH * 2 + 50;
		int height = ImgPanel.HEIGHT + 50; 
		//this.setLayout(new GridBagLayout());
		this.setSize(width, height);
		this.add(imgPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		
		
		this.setVisible(true);
		
	}
	public GridBagConstraints position( int x, int y)
	{
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = x;
		c.gridy = y;
		return c;
	}
}
 
