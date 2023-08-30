import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.color.*;
import javax.swing.border.*;
import java.awt.image.*;
import java.awt.Graphics.*;
import javax.swing.event.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.File;
class lp extends JFrame implements MouseListener,MouseMotionListener 
{
	JFrame f;
	JLabel l;
	JPanel panel;
	Container c;
	ImageIcon ii;
	Image img;
	int pixels[];
	PixelGrabber pg;
	ColorModel cm;
	Graphics2D gg;
	lp()
	{
		f=new JFrame("Drawing on an image");
		f.setSize(1024,738);
		ii=new ImageIcon("habra.jpg");
		img=ii.getImage();
		pixels=new int[ii.getIconWidth()*ii.getIconHeight()];
		pg=new PixelGrabber(img,0,0,ii.getIconWidth(),ii.getIconHeight(),pixels,0,ii.getIconWidth());
		try
		{
			pg.grabPixels();
		}
		catch(InterruptedException k)
		{
		}	
		l=new JLabel(ii,JLabel.CENTER);
		l.addMouseListener(this);
		l.addMouseMotionListener(this);
		l.setBorder(BorderFactory.createLineBorder(Color.blue,5));
		panel=new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(l);
		
		
		
		c=f.getContentPane();
		c.add(panel);
		f.setVisible(true);		
	}

public void mouseClicked(MouseEvent me)
{
}
public void mouseEntered(MouseEvent me)
{
	
}
public void mouseExited(MouseEvent me)
{
 
}
	
public void mousePressed(MouseEvent me)
{
	 	
}
public void mouseReleased(MouseEvent me)
{
	   	
}
	

public void mouseMoved(MouseEvent me)	

{
	ColorModel cm=pg.getColorModel();
	gg=(Graphics2D)l.getGraphics();
  	    //Drawing line

  	gg.setColor(Color.red);
  	gg.drawLine(300,200,260,108);
	gg.setColor(Color.green);
  	gg.drawLine(350,310,541,370);
	gg.setColor(Color.blue);
  	gg.drawLine(410,238,342,530);   

}
public void mouseDragged(MouseEvent me)
{
}

	public static void main(String aa[])
	{
		new lp();
	}
}