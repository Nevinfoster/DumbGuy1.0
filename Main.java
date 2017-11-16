package dumbGuy;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel implements Runnable {
	
	static final long serialVersionUID = 1L;
	public int i = 0;
	Image platform, brick;
	public Main() {
		try {
			platform = ImageIO.read(new File("C:\\Users\\nevin\\OneDrive\\Pictures\\DGpic\\DGplat.png"));
			brick = ImageIO.read(new File("C:\\Users\\nevin\\OneDrive\\Pictures\\DGpic\\DGbrick.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		Thread thread = new Thread(main);
		thread.start();
		JFrame frame = new JFrame("JFrame Example");    
        frame.setSize(300, 300);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);
        frame.add(main);
	}

	@Override
	public void run() {
		while(i < 3) {
			i++;
			System.out.println("i is " + i);
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        repaint();
		
	}

	public void paint(Graphics g) {
		g.drawImage(platform, 300, 300, 300, 300, this);
	}
	
}
