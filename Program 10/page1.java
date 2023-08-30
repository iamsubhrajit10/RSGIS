import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.image.*;
import java.awt.Graphics.*;
import java.util.Arrays;
class page1 extends JFrame implements MouseListener,MouseMotionListener ,ActionListener
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
	JLabel leb1,leb2,leb3,leb4;
	JComboBox cb1a;
	JTextField tf1,tf2,tf4;
	JButton fcb,cb,fs;
	Color cc=new Color(160,160,220,200);
	int x,y;
	int rgb=0;
	int frgb[]=new int[3];
	String fea[]=new String[3];	
	int count=0;
	String ss;
	int ccb=0;
	int[][] w = new int[10000][10000];
	int[] components=new int[50000];
	int[][] imageArray=new int[1000][1000];
	int[] dx = new int[] {-1,0,1,1,1,0,-1,-1};
	int[] dy = new int[] {1,1,1,0,-1,-1,-1,0};
	
	page1()
	{
		f=new JFrame("Data Association Page");
		ii=new ImageIcon("session1.gif");
		img=ii.getImage();
		height=ii.getIconHeight();
		width=ii.getIconWidth();
		pixels=new int[(ii.getIconWidth()+1)*(ii.getIconHeight()+1)];
		pg=new PixelGrabber(img,0,0,ii.getIconWidth(),ii.getIconHeight(),pixels,1,ii.getIconWidth());
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
		p.setBounds(0, 0, 740, 600);
		desk.add(p);
		p.setVisible(true);
		l.addMouseListener(this);
		l.addMouseMotionListener(this);
		
		panel=new JPanel();
		panel.setLayout(new GridLayout(4,1));
		panel.setBackground(cc);
		
		p1=new JPanel();
	    p1.setBorder(new TitledBorder(new LineBorder(Color.red,2),"Feature Selection"));
	    p1.setLayout(new GridLayout(6,1));
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
		 /*--------------------*/
		JPanel p1e=new JPanel();
		
		fs=new JButton("Find percentage");
		fs.setBackground(Color.yellow);
		fs.setBorder(new BevelBorder (BevelBorder.RAISED));		
		fs.addActionListener(this);
		fs.setBorder(new BevelBorder(BevelBorder.RAISED));
		p1e.add(fs);
		
				
		tf4=new JTextField(15);
	    tf4.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
	    tf4.setEditable(false);
	    tf4.setBackground(Color.white); 
	    p1e.add(tf4);
		
		tf4.setVisible(false);
		fs.setVisible(false);
		p1.add(p1e);
		/*--------------------*/
		c.add(desk, BorderLayout.CENTER);
		c.add(panel,BorderLayout.EAST);
	    f.setSize(1024,738);
		f.setVisible(true);	
	
	}
	
	public static void main(String args[])
	{
		new page1();
	}

	public void mouseClicked(MouseEvent me)
	{
	  ColorModel md=pg.getColorModel();
	  x=me.getX();
	  y=me.getY();
	  int a1=(y-1)*ii.getIconWidth()+x;
	  System.out.println(x+"    "+y+"  "+ii.getIconWidth()+"  "+a1+pixels[a1]);
	 // System.out.println(a1);
	  rgb=(md.getRGB(pixels[a1]));
	  System.out.print(rgb);
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
		
	}
	public void mouseDragged(MouseEvent me)
	{ 
			  
	}

	public void actionPerformed(ActionEvent ae)
	{
		ColorModel md=pg.getColorModel();
		int rgb1;
		double temp,temp1;
		if(ae.getSource()==fcb)
		{
			int flag=0;
			if(count>=3)
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
		   if(count==3)
		   {
				fcb.setVisible(false);
		   } 
		}
   
	   if(ae.getSource()==cb)
	   {
		if(count==3&& ccb==0)
		{
		  for(int i=0;i<3;i++)
		  {
			cb1a.addItem(fea[i]);
			System.out.print("\n"+frgb[i]+"   is for the feature "+fea[i]);
		  }
		  System.out.print("\n\n");
		  ccb=1;
		}
		tf4.setVisible(true);
		fs.setVisible(true);
		rgb=0;
	   } 


		if(ae.getSource()==fs)
		{
			int a1,i,j;
			int count1=0;			
			if(rgb==0)
			{
				JOptionPane.showMessageDialog((Component)null,"Please Click on Feature to Find Percentage","NOTIFICATION",JOptionPane.ERROR_MESSAGE);
			}
			else
			{				
				int count=0;
				for(i=1;i<=height;i++)
				{
					for(j=1;j<=width;j++)
					{
						a1=(i-1)*width+j;   
						rgb1=(md.getRGB(pixels[a1]));
						if(rgb1==rgb)
						{
							count++;
						}
					}
				}
				
				System.out.print("\n\n\ncount="+count+"\n\n\n");
				//calculate percentage
				temp=count;
				temp1=height*width;
				temp=count*100/temp1;
				tf4.setText(Double.toString(temp));
				System.out.print("\n\n\nPercentage="+temp+"\n\n\n");
				
			}
	   }
	}	
}