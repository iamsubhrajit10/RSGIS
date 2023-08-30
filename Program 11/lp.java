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
		ii=new ImageIcon("subhrajit.jpg");
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

  	//draw oval
	gg.setColor(Color.red);
  	gg.drawOval(300,200,260,108);
	//draw line
	gg.setColor(Color.green);
  	
	int x1=150;
	int x2=340;
	int y2=370;
	int y1=210;
	gg.drawLine(x1,y1,x2,y2);
	
	//draw gradient
	int k=0,l=0;
	for(int i=480;i>=50;i=i-2) {
		gg.setColor(new Color(k,l,255));
		gg.drawRect(50,i,70,1);	
		k=k+1;
		l=l+1;
	}
	
	
	//draw text
	gg.setColor(Color.black);
	gg.drawString("Hi!", 300, 300);
	//Draw Polygons
	Polygon pp1=new Polygon();
	pp1.addPoint(150,300);
	pp1.addPoint(150,380);
	pp1.addPoint(250,410);
	pp1.addPoint(220,320);
	gg.setColor(new Color(200,13,40) );
	gg.fillPolygon(pp1);   

	//Drawing line

  	gg.setColor(Color.red);
  	gg.drawLine(300,300,200,300);
	gg.setColor(Color.green);
  	gg.drawLine(200,300,200,500);
	gg.setColor(Color.blue);
  	gg.drawLine(300,300,200,500);   

}
public void mouseDragged(MouseEvent me)
{
}

	public static void main(String aa[])
	{
		new lp();
	}
}