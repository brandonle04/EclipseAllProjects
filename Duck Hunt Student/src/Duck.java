import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Duck implements MouseListener{
	private int x = 0,y = 180;
	private int vx, vy;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
	Music soundBang = new Music("bang.wav", false);
	Music soundHaha = new Music("haha.wav", false);
	
	

	public Duck() {
		img = getImage("duck.png"); //load the image for Tree
		init(x, y); 				//initialize the location of the image
		
		vx = (int)(Math.random()*(4-3+1))+3;
		vy = (int)(Math.random()*(4-3+1))+3;
		
		if(Math.random()<.50) {
			vx *= -1;
		}
		
		
		
		
	}
	
	public void paint(Graphics g) {
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		/* get the bird to move randomly up from the bottom of the screen
		 * it should start at the bottom
		 * make it bounce off of the top and side borders
		 */
		y -= vy;
		x += vx;
		
		if(y<=0) {
			y = 300;
		}
		
		if(x<=-1 || x>=775) {
			vx *= -1;
		}
		
		
	
		tx.setToTranslation(x, y);  //must call this anytime you update x and y		
		g2.drawImage(img, tx, null);   
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Duck.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public boolean collided(int mX, int mY) {
		System.out.print(mX+":"+mY);
		
		//represent the duck as a rectangle
		
		Rectangle example = new Rectangle(x,y,100,100);
		
		if(example.contains(mX, mY)) {
			System.out.println("ouch");
			
			//what happens to the duck if hit?!
			//have the duck fall from the sky
			//after a hit
			//play the "bang" sound
			soundBang.play();
		}
		
		//can you have it say "haha" if it misses
		//only by a little
		
		if(Math.abs(mX-x) < 150 && Math.abs(mY-y) < 150) {
			soundHaha.play();
			System.out.println("close miss");
		}
		return false;

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ouch");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
