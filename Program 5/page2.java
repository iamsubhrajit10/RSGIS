import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

class page2 extends JFrame implements ActionListener,ItemListener 
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

  //JFrame f;
  JPanel panel1,p11,p21,p31,p311,p321;
  JLabel leb11,leb21,leb31;
  JTextField tf11;
  JComboBox cb1; 
  JButton b1;
  Container co;
  Color c11=new Color(160,160,220,200);
  Color c21=new Color(160,100,10,100);
  Color c31=new Color(20,160,10,100);
  String ss1="Select";

  page2(String aa, String bb)
  {
  	nam=aa;
  	course=bb;
  	f=new JFrame("Page Design 2");
  	f.setSize(500,400);
	f.setLocation(200,150);		
	panel=new JPanel();
	panel.setLayout(new GridLayout(3,1));
	
	p1=new JPanel();
	p1.setBackground(c1);
	panel.add(p1);
	String ht1 = 
        "<html><p><font color=\"GREEN\" "+
        "size=\"6\" face=\"Verdana\">My Name is "+nam+"</font> </p>";
		leb1=new JLabel(ht1);
		p1.add(leb1);	
	
	p2=new JPanel();
	p2.setBackground(c2);
	panel.add(p2);
	String ht2 = 
        "<html><p><font color=\"BLUE\" "+
        "size=\"6\" face=\"Verdana\">I am a Student of "+course+"</font> </p>";
		leb2=new JLabel(ht2);
	p2.add(leb2);
	f.setVisible(true);
 
 		
	panel1=new JPanel();
	panel.setLayout(new GridLayout(2,1));
	
	p11=new JPanel();
	p11.setBackground(c11);
	panel.add(p11);
	String ht11 = 
        "<html><p><font color=\"GREEN\" "+
        "size=\"6\" face=\"Verdana\">Enter Country</font> </p>";
		leb11=new JLabel(ht11);
		p11.add(leb11);	
	tf11=new JTextField(15);
	tf11.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN,14));
	p11.add(tf11);
	
	p21=new JPanel();
	p21.setBackground(c21);
	panel.add(p21);
	String ht21 = 
        "<html><p><font color=\"YELLOW\" "+
        "size=\"6\" face=\"Verdana\">Choose Gender</font> </p>";
		leb21=new JLabel(ht21);
	p21.add(leb21);
	cb1= new JComboBox();
	cb1.setEditable(false);
	cb1.setMaximumRowCount(3);
	cb1.addItem("Select");
	cb1.addItem("Male");
	cb1.addItem("Female");
	
	//cb1.addItemListener(this);
	p21.add(cb1);
	
	p31=new JPanel();
	p31.setLayout(new GridLayout(2,1));
	p31.setBackground(c31);
	p21.add(p31);
	String ht31 = 
        "<html><p><font color=\"RED\" "+
        "size=\"6\" face=\"Verdana\">Press the Button for Page 3</font> </p>";
		leb31=new JLabel(ht31);
	p31.add(leb31);
	b1=new JButton(" BUTTON ");
	b1.setBackground(Color.pink);
	b1.setBorder(new BevelBorder (BevelBorder.RAISED));
	b1.addActionListener(this);
	p21.add(b1);
	
	co=f.getContentPane();
	co.add(panel);
	f.setVisible(true);
	
  }
 
   public void actionPerformed(ActionEvent ae)
    {
		
  	if(ae.getSource()==b1)
  		{
  		int flag=0;
  		String st1=tf11.getText();
		String ss1 =(String)cb1.getSelectedItem();
  		if(st1.length()==0)
  		{
  		JOptionPane.showMessageDialog((Component)null,"Please  Write your country",
   	          "NOTIFICATION",JOptionPane.ERROR_MESSAGE);
   	          flag=1;	
  		}
  		if(ss1.equals("Select"))
  		{
  			JOptionPane.showMessageDialog((Component)null,"Please  Select The gender",
   	          "NOTIFICATION",JOptionPane.ERROR_MESSAGE);
   	          flag=1;
  		}
  		if(flag==0)
  		{
  			//f.setVisible(false);
			new page3(st1,ss1);
  			
  		}
  	}
  }

  public void itemStateChanged(ItemEvent ie)
  {
  	ss1 =(String)cb1.getSelectedItem();	
  }
}