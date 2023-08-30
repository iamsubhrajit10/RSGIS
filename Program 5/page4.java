import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;


class page4 extends JFrame  
{
  JFrame f;
  JPanel panel,p1,p2,p3;
  JLabel leb1,leb2,leb3;
  Container c;
  Color c1=new Color(160,160,220,200);
  Color c2=new Color(160,100,10,100);
  Color c3=new Color(20,160,10,100);
  String nam;
  String course;
  page4(String aa, String bb)
  {
  	nam=aa;
  	course=bb;
  	f=new JFrame("Page Design 4");
  	f.setSize(500,200);
	f.setLocation(200,150);		
	panel=new JPanel();
	panel.setLayout(new GridLayout(3,1));
	
	p1=new JPanel();
	p1.setBackground(c1);
	panel.add(p1);
	String ht1 = 
        "<html><p><font color=\"GREEN\" "+
        "size=\"6\" face=\"Verdana\">Address is "+nam+"</font> </p>";
		leb1=new JLabel(ht1);
		p1.add(leb1);	
	
	p2=new JPanel();
	p2.setBackground(c2);
	panel.add(p2);
	String ht2 = 
        "<html><p><font color=\"BLUE\" "+
        "size=\"6\" face=\"Verdana\">NRI? "+course+"</font> </p>";
		leb2=new JLabel(ht2);
	p2.add(leb2);
	
	p3=new JPanel();
	panel.add(p3);
	p3.setBackground(c3);
	String ht3 = 
        "<html><p><font color=\"RED\" "+
        "size=\"10\" face=\"Verdana\"> Thank  You </font> </p>";
	leb3=new JLabel(ht3);
	p3.add(leb3);

	
	c=f.getContentPane();
	c.add(panel);
	f.setVisible(true);
  }
 
  
  	
}