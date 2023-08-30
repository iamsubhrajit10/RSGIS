import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.image.*;
import java.awt.Graphics.*;

class option2 extends JFrame implements MouseListener,MouseMotionListener ,ActionListener
{
	JFrame f;
	JLabel l;
	JPanel p1;
	ImageIcon ii;
	Image img;
	int height;
	int width;
	Container c;
	int pixels[];
	PixelGrabber pg;
	JPanel panel;
	JLabel leb1,leb2,leb3;
	JComboBox cb1a;
	JTextField tf1,tf2;
	JButton fcb,cb;
	Color cc=new Color(160,160,220,200);
	int x,y;
	int rgb;
	int frgb[]=new int[4];
	String fea[]=new String[4];	
	int count=0;
	String ss;
	int ccb=0;
	Graphics2D gg1,gg2,gg3;
	Polygon pp1=new Polygon();
	Polygon pp2=new Polygon();
	Polygon pp3=new Polygon();
	
	option2()
	{	
		f=new JFrame("Style 2 to open an image");
		ii=new ImageIcon("prasun.jpg");
		img=ii.getImage();
		height=ii.getIconHeight();
		width=ii.getIconWidth();
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
		c=f.getContentPane();
		JDesktopPane desk = new JDesktopPane();
        
        JInternalFrame p = new JInternalFrame("Image Frame",false, false, true, false);
		JScrollPane scroll = new JScrollPane(l);
		p.setContentPane(scroll);
		p.setBounds(0, 0, 600,600);
		desk.add(p);
		p.setVisible(true);
		l.addMouseListener(this);
		l.addMouseMotionListener(this);
		
		
		
		pp1.addPoint(300,300);
		pp1.addPoint(340,300);
		pp1.addPoint(340,260);
		pp1.addPoint(300,260);
		
		pp2.addPoint(130,400);
		pp2.addPoint(180,420);
		pp2.addPoint(150,380);
		
		pp3.addPoint(200,280);
		pp3.addPoint(230,280);
		pp3.addPoint(240,260);
		pp3.addPoint(230,240);
		pp3.addPoint(210,235);
		pp3.addPoint(180,250);
		
		
		
		
		
		panel=new JPanel();
		panel.setLayout(new GridLayout(4,1));
		panel.setBackground(cc);
		
		p1=new JPanel();
	    p1.setBorder(new TitledBorder(new LineBorder(Color.red,2),"Feature Selection"));
	    p1.setLayout(new GridLayout(4,1));
	    panel.add(p1);
	    /*--------------------*/
	    JPanel p1a=new JPanel();
	    String ht1 = 
        "<html><p><font color=\"GREEN\" "+
        "size=\"4\" face=\"Verdana\">Feature Selection</font> </p>";
		leb1=new JLabel(ht1);
		p1a.add(leb1);
		
		cb1a=new JComboBox();
		cb1a.setPreferredSize(new Dimension (100,20) );
	    cb1a.setEditable(false);
	    cb1a.setBackground(Color.WHITE);
	    cb1a.setFont(new Font("Dialog", Font.BOLD, 10));
	    cb1a.addItem("      ");
		

	   //cb1a.addActionListener(this);
	    p1a.add(cb1a);		
		p1.add(p1a);

		/*--------------------*/
		JPanel p1b=new JPanel();
		String ht2 = 
        "<html><p><font color=\"GREEN\" "+
        "size=\"4\" face=\"Verdana\">Color</font> </p>";
		leb2=new JLabel(ht2);
		p1b.add(leb2);		
		tf1=new JTextField(3);
	    tf1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
	    tf1.setEditable(false);
	    tf1.setBackground(Color.white); 
	    p1b.add(tf1);
	
		/*--------------------*/
    
		String ht3 = 
        "<html><p><font color=\"GREEN\" "+
        "size=\"4\" face=\"Verdana\">Feature</font> </p>";
		leb3=new JLabel(ht3);
		p1b.add(leb3);		
		tf2=new JTextField(9);
	    tf2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
	    p1b.add(tf2);
	    
	    p1.add(p1b);
	    /*--------------------*/
    
		JPanel p1c=new JPanel();
		fcb=new JButton("   G  O   ");
		fcb.setBackground(Color.pink);
		fcb.setBorder(new BevelBorder (BevelBorder.RAISED));		
		fcb.addActionListener(this);
		fcb.setBorder(new BevelBorder(BevelBorder.RAISED));
		p1c.add(fcb);
				
		p1.add(p1c);
		 /*--------------------*/		
		JPanel p1d=new JPanel();
		cb=new JButton("   COMPLETE   ");
		cb.setBackground(Color.yellow);
		cb.setBorder(new BevelBorder (BevelBorder.RAISED));		
		cb.addActionListener(this);
		cb.setBorder(new BevelBorder(BevelBorder.RAISED));
		p1d.add(cb);
				
		p1.add(p1d);
		 /*--------------------*/
		c.add(desk, BorderLayout.CENTER);
		c.add(panel,BorderLayout.EAST);
	    f.setSize(1024,738);
		f.setVisible(true);	
	
	}
	
	public static void main(String args[])
	{
		new option2();
	}

	public void mouseClicked(MouseEvent me)
	{	  
	  boolean contain1,contain2,contain3;
	  ColorModel md=pg.getColorModel();
	  x=me.getX();
	  y=me.getY();
	
	  contain1=pp1.contains(x,y);
	  contain2=pp2.contains(x,y);
	  contain3=pp3.contains(x,y);
	  System.out.print("\nPoint inside polygon:"+(contain1||contain2||contain3)+"\n");
	  int a1=(y-1)*ii.getIconWidth()+x;
	  System.out.println(x+"    "+y+"  "+ii.getIconWidth()+"  "+a1+""+pixels[a1]);

	  rgb=(md.getRGB(pixels[a1]));
	  System.out.print(rgb);
	  if(contain1==true)
	  {
		Color color = new Color(255, 0, 0);
		rgb = color.getRGB(); 
		tf1.setBackground(new Color(255,0,0));
	  }
	  else if(contain2==true)
	  {
		Color color = new Color(0, 255, 0);
		rgb = color.getRGB(); 
		tf1.setBackground(new Color(0,255,0));
	  }
	  else if(contain3==true)
	  {
		Color color = new Color(0, 0, 255);
		rgb = color.getRGB(); 
		tf1.setBackground(new Color(0,0,255));
	  }
	  else
		tf1.setBackground(new Color(rgb));
	  
	  for(int i=0;i<count;i++)
	  {
		if(rgb==frgb[i])
		{
			System.out.print("  "+fea[i]+"\n\n");
			break;
		}
	  }
	  
	  
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
		gg1=(Graphics2D)l.getGraphics();	
		gg1.setColor(new Color(255,0,0) );
		gg1.fillPolygon(pp1);
		gg2=(Graphics2D)l.getGraphics();	
		gg2.setColor(new Color(0,255,0) );
		gg2.fillPolygon(pp2);
		gg3=(Graphics2D)l.getGraphics();	
		gg3.setColor(new Color(0,0,255) );
		gg3.fillPolygon(pp3);
		   
	}
	public void mouseDragged(MouseEvent me)
	{ 
			  
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==fcb)
		{
			int flag=0;
			if(count==4)
			{
				JOptionPane.showMessageDialog((Component)null,"Assignment completed before",
				"NOTIFICATION",JOptionPane.ERROR_MESSAGE);
				flag=1;
				tf1.setBackground(Color.white);
				tf2.setText(null);
				
			}
			ss=tf2.getText();
			if(ss.length()==0&&flag==0)
			{
				JOptionPane.showMessageDialog((Component)null,"Please Assign Feature Name",
				"NOTIFICATION",JOptionPane.ERROR_MESSAGE);
				flag=1;
			}
		   if(rgb==0&&flag==0)
		   {
			JOptionPane.showMessageDialog((Component)null,"Please Select Feature",
			"NOTIFICATION",JOptionPane.ERROR_MESSAGE);
			flag=1;
		   }
		  
		   if(flag==0)
		   {
		   for(int i=0;i<count;i++)
		   {
			if(rgb==frgb[i])
			{
			 JOptionPane.showMessageDialog((Component)null,"Please Select New Feature",
			"NOTIFICATION",JOptionPane.ERROR_MESSAGE);
			flag=1;	
			}
			
			if(ss.equalsIgnoreCase(fea[i]))
			{
			  JOptionPane.showMessageDialog((Component)null,"Feature Name Used Before",
			"NOTIFICATION",JOptionPane.ERROR_MESSAGE);
			flag=1;	
			tf2.setText(null);
			}
			
		   }
		   }
   	  
		   if(flag==0)
		   {
			frgb[count]=rgb;
			//System.out.println(rgb);
			fea[count]=ss;
			count++;
			tf1.setBackground(Color.white);
			tf2.setText(null);
			rgb=0;
		   }
		   //allowing only three attribute here
		   if(count==3)
		   {
				fcb.setVisible(false);
		   }	 
		}
   
	   if(ae.getSource()==cb)
	   {
		if(count==4&& ccb==0)
		{
		  for(int i=0;i<4;i++)
		  {
			cb1a.addItem(fea[i]);
			System.out.println(frgb[i]+"   is for the feature "+fea[i]);
		  }
		  System.out.print("\n\n");
		  ccb=1;
		}
	   }   
	}	
}