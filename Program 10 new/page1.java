import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

class page1 extends JFrame implements ActionListener,ItemListener 
{
  JFrame f;
  JPanel panel,p1,p2,p3,p31,p32;
  JLabel leb1,leb2,leb3;
  JTextField tf1;
  JComboBox cb; 
  JButton b;
  Container c;
  Color c1=new Color(160,160,220,200);
  Color c2=new Color(160,100,10,100);
  Color c3=new Color(20,160,10,100);
  String ss="Select";

  page1()
  {
  	f=new JFrame("Page Design 1");
  	f.setSize(500,300);
	f.setLocation(200,150);		
	panel=new JPanel();
	panel.setLayout(new GridLayout(3,1));
	
	p1=new JPanel();
	p1.setBackground(c1);
	panel.add(p1);
	String ht1 = 
        "<html><p><font color=\"GREEN\" "+
        "size=\"6\" face=\"Verdana\">Enter Your Name</font> </p>";
		leb1=new JLabel(ht1);
		p1.add(leb1);	
	tf1=new JTextField(15);
	tf1.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,14));
	p1.add(tf1);
	
	p2=new JPanel();
	p2.setBackground(c2);
	panel.add(p2);
	String ht2 = 
        "<html><p><font color=\"BLUE\" "+
        "size=\"6\" face=\"Verdana\">Choose Your Course</font> </p>";
		leb2=new JLabel(ht2);
	p2.add(leb2);
	cb= new JComboBox();
	cb.setEditable(false);
	cb.setMaximumRowCount(3);
	cb.addItem("Select");
	cb.addItem("M. Tech");
	cb.addItem("MCA");
	cb.addItem("M.Sc");
	cb.addItem("M.A");
	cb.addItemListener(this);
	p2.add(cb);
	
	p3=new JPanel();
	panel.add(p3);
	p3.setLayout(new GridLayout(2,1));
	p31=new JPanel();
	p31.setBackground(c3);
	p3.add(p31);
	String ht3 = 
        "<html><p><font color=\"RED\" "+
        "size=\"6\" face=\"Verdana\">Press the Button for Page 2</font> </p>";
		leb3=new JLabel(ht3);
	p31.add(leb3);
	p32=new JPanel();
	p32.setBackground(c3);
	p3.add(p32);
	b=new JButton(" BUTTON ");
	b.setBackground(Color.pink);
	b.setBorder(new BevelBorder (BevelBorder.RAISED));		
	b.addActionListener(this);
	p32.add(b);	
	
	c=f.getContentPane();
	c.add(panel);
	f.setVisible(true);
  }
  public static void main(String aa[])
  {
  	new page1();
	
  }
  public void actionPerformed(ActionEvent ae)
  {
  	if(ae.getSource()==b)
  	{
  		int flag=0;
  		String st=tf1.getText();
  		if(st.length()==0)
  		{
  		JOptionPane.showMessageDialog((Component)null,"Please  Write your Name",
   	          "NOTIFICATION",JOptionPane.ERROR_MESSAGE);
   	          flag=1;	
  		}
  		if(ss.equals("Select"))
  		{
  			JOptionPane.showMessageDialog((Component)null,"Please  Select The Course",
   	          "NOTIFICATION",JOptionPane.ERROR_MESSAGE);
   	          flag=1;
  		}
  		if(flag==0)
  		{
  			//f.setVisible(false);
			new page2(st,ss);
  			
  		}
  	}
  }
  public void itemStateChanged(ItemEvent ie)
  {
  	ss =(String)cb.getSelectedItem();	
  }
  	
}