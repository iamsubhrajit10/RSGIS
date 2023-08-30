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
class poly extends JFrame implements MouseListener,MouseMotionListener 
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
	poly()
	{
		f=new JFrame("Drawing on an image");
		f.setSize(1024,738);
		ii=new ImageIcon("subhr.jpg");
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
  	   
    //Drawing Polygons
	Polygon pp1=new Polygon();
	pp1.addPoint(300,300);
	pp1.addPoint(300,380);
	pp1.addPoint(350,410);
	pp1.addPoint(430,320);
	gg.setColor(new Color(200,13,40) );
	gg.fillPolygon(pp1);

	Polygon pp2=new Polygon();
	pp2.addPoint(200,300);
	pp2.addPoint(200,450);
	pp2.addPoint(250,500);
	pp2.addPoint(230,320);
	gg.setColor(new Color(100,13,40) );
	gg.fillPolygon(pp2);

	
	Polygon pp3=new Polygon();
	pp3.addPoint(400,100);
	pp3.addPoint(400,200);
	pp3.addPoint(450,300);
	pp3.addPoint(430,120);
	gg.setColor(new Color(40,100,40) );
	gg.fillPolygon(pp3);
        
	Polygon pp4=new Polygon();
	pp4.addPoint(100,100);
	pp4.addPoint(100,350);
	pp4.addPoint(150,500);
	pp4.addPoint(200,320);
	gg.setColor(new Color(80,10,130) );
	gg.fillPolygon(pp4);
       
}
public void mouseDragged(MouseEvent me)
{
}

	public static void main(String aa[])
	{
		new poly();
	}
}