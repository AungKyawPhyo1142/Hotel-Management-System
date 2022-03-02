import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Loading_TT1 extends JFrame { 

JProgressBar pro;

int num=0;

public Loading_TT1( ) { 

setBounds(200,200,300,100);

JPanel pane = new JPanel ( );
BorderLayout bl = new BorderLayout( );
pane.setLayout(bl);

ImageIcon i1 = new ImageIcon("cal.GIF");
JLabel l1 = new JLabel(i1);

//pane.add("Center",l1);

pro = new JProgressBar(0,4000);
pro.setStringPainted(true);
pro.setValue(0);
pane.add("Center",pro);

setContentPane(pane);

setVisible(true);

}

public void iterate( ) { 

while(num<4000) { 

pro.setValue(num);
try { Thread.sleep(1000); } catch (Exception e) { }

num+=1000;

}

}

}

//--------------------------------------------------------------------------------------------

class showData extends JFrame implements ActionListener { 

JTextArea t1 = new JTextArea( );

JButton b1 = new JButton("Go Back");

String name="",nrc,phone,room_type,in_date,out_date;

String s3="";

JMenuItem mi1 = new JMenuItem("Delete Customer Data");

JMenu m1 = new JMenu("Option");


public showData( ) { 
 
super("Customer Data");
setSize(1366,730);

JPanel pane = new JPanel ( );
FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
//BorderLayout bl = new BorderLayout();
pane.setBackground(Color.WHITE);
pane.setLayout(fl);


try { Class.forName("sun.jdbc.odbc.JdbcOdbcDriverManager"); }  catch (java.lang.ClassNotFoundException e) { }

try { 

	Connection c = DriverManager.getConnection("jdbc:odbc:Database4");
	Statement  s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	ResultSet  r = s.executeQuery("SELECT * FROM Customer");

	r.last( );
	r.beforeFirst( );

	while(r.next( )) { 

		name      = r.getString(1);
		nrc       = r.getString(2);
		phone     = r.getString(3);
		room_type = r.getString(4);
		in_date   = r.getString(5);
		out_date  = r.getString(6);

	s3 += name+"\t\t"+nrc+"\t"+phone+"\t\t"+room_type+"\t\t"+in_date+"\t\t"+out_date+"\n";

	} // while

	r.close( );
	s.close( );
	c.close( );

    } catch (SQLException se) { }

String s2 = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
String s1 = "Name\t\tNRC\t\tPhone\t\tRoomType\t\tCheck In Date\t\tCheck Out Date\n"+s2+"\n\n"+s3;

t1.setEditable(false);
t1.setText(s1);

JScrollPane scroller = new JScrollPane(t1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
pane.add("Center",scroller);

mi1.setBackground(Color.WHITE);
mi1.addActionListener(this);

m1.setBackground(Color.WHITE);
m1.add(mi1);
pane.add(m1);

//b1.setBackground(Color.WHITE);
//b1.addActionListener(this);
//pane.add(b1);

JMenuBar bar = new JMenuBar( );
bar.setBackground(Color.WHITE);
bar.add(m1);
setJMenuBar(bar);

setContentPane(pane);
setVisible(true);

}


public void actionPerformed(ActionEvent ae) { 

if (ae.getActionCommand().equals("Delete Customer Data")) { 

String s; int row;

s = JOptionPane.showInputDialog(null,"Enter Row Number Do You Want To Delete","Delete",JOptionPane.PLAIN_MESSAGE);
row = Integer.parseInt(s);


//int res = JOptionPane.showConfrimDialog(null,"Are You Sure Do You Want To Delete Customer Data ?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

int res = JOptionPane.showConfirmDialog(null,"Are You Sure Do You Want To Delete?");

if (res==0) { 

try { 

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

}catch (java.lang.ClassNotFoundException e) { }

try { 

	Connection obj = DriverManager.getConnection("jdbc:odbc:Database4");

	Statement st = obj.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

	ResultSet r = st.executeQuery("SELECT * FROM Customer");

	r.absolute(row);
	r.deleteRow( ); 

	JOptionPane.showMessageDialog(null,"Customer Data of Row Number "+row+" is deleted successfully!","Deleted Successfully",JOptionPane.INFORMATION_MESSAGE);

//	int resp = JOptionPane.showConfrimDialog(null,"Do You Want To Refresh?","Refresh",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

int resp = JOptionPane.showConfirmDialog(null,"Do You Want To Refresh?");

	if (resp==0) { t1.setText("");
		      
                      String sname = "";
                      String snrc = "";
                      String sphone = "";
                      String sroom_type = "";
                      String sin_date = "";
                      String sout_date = "";
		      String ss3 = "";
  
try { Class.forName("sun.jdbc.odbc.JdbcOdbcDriverManager"); }  catch (java.lang.ClassNotFoundException e) { }

try { 

	Connection cc = DriverManager.getConnection("jdbc:odbc:Database4");
	Statement  ss = cc.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	ResultSet  rr = ss.executeQuery("SELECT * FROM Customer");

	rr.last( );
	rr.beforeFirst( );

	while(rr.next( )) { 

		sname      = rr.getString(1);
		snrc       = rr.getString(2);
		sphone     = rr.getString(3);
		sroom_type = rr.getString(4);
		sin_date   = rr.getString(5);
		sout_date  = rr.getString(6);

	ss3 += sname+"\t\t"+snrc+"\t"+sphone+"\t\t"+sroom_type+"\t\t"+sin_date+"\t\t"+sout_date+"\n";

	} // while

	rr.close( );
	ss.close( );
	cc.close( );

    } catch (SQLException se) { }

String s2 = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
String s1 = "Name\t\tNRC\t\tPhone\t\tRoomType\t\tCheck In Date\t\tCheck Out Date\n"+s2+"\n\n"+ss3;

t1.setEditable(false);
t1.setText(s1);




                                                       } // Yes

	if (resp==1) { setVisible(false);
                      MainFrame mf = new MainFrame( ); } // No

	r.close();
	st.close();
	obj.close();

     } catch (SQLException se) { }
	

					} // if (confirm)

else { setVisible(false);
       setVisible(true); }
							} // first if

}



}

class Manager extends JFrame implements ActionListener {

JTextField us = new JTextField( );

JPasswordField ps = new JPasswordField( );

JButton log = new JButton ("Log in");

public Manager( ) { 

super("Hotel Manager");

setBounds(400,100,600,500);
//setResizable(false);
JPanel pane = new JPanel( );
//pane.setBackground(new Color(225,225,128));
pane.setBackground(Color.WHITE);
pane.setLayout(null);

//Font f = new Font("Calligrapher",Font.PLAIN,33);

ImageIcon i1 = new ImageIcon("Hotel1.png");
JLabel title = new JLabel (i1);
title.setBounds(98,10,400,188);
pane.add(title);

JLabel lb1 = new JLabel ("Username : ");
lb1.setBounds(190,200,250,30);
pane.add(lb1);

us.setBounds(290,200,100,30);
pane.add(us);

JLabel lb2 = new JLabel ("Password : ");
lb2.setBounds(190,260,250,30);
pane.add(lb2);

ps.setBounds(290,260,100,30);
pane.add(ps);

log.addActionListener(this);
log.setBounds(230,350,100,30);
log.setBackground(Color.WHITE);
pane.add(log);

setContentPane(pane);
setVisible(true);

}

public void actionPerformed (ActionEvent ae) { 

Object source = ae.getSource( );

String user = us.getText( );

String pass = new String(ps.getPassword( ));

if (source==log) { 

if ( user.equals("Manager") && pass.equals("12345") ) { //setVisible(false);

setVisible(false);

Main_Frame f = new Main_Frame( );

showData obj = new showData( );

 } // close if

else  { 
setVisible(false);
JOptionPane.showMessageDialog(null,"Sorry! Please Try Again!","Wrong Username or Password",JOptionPane.ERROR_MESSAGE);
Main_Frame f = new Main_Frame( );

 }

                 } // close of log

}

} // close Manager



class Rooms extends JFrame { 

public Rooms( ) { 

super("Room Informations");
//setSize(1366,730);
setBounds(300,100,780,580);

//------------------------------------ deluxe room ------------------------------------------

JPanel deluxe = new JPanel ( );
deluxe.setBackground(Color.WHITE);
deluxe.setLayout(null);

ImageIcon i1 = new ImageIcon("Deluxe.JPG");
JLabel l1 = new JLabel (i1);
l1.setBounds(10,10,400,224);
deluxe.add(l1);

ImageIcon i2 = new ImageIcon("D_Details.png");
JLabel l2 = new JLabel (i2);
l2.setBounds(430,70,300,106);
deluxe.add(l2);

ImageIcon i3 = new ImageIcon("Deluxe_Price.png");
JLabel l3 = new JLabel(i3);
l3.setBounds(250,350,252,43);
deluxe.add(l3);


//------------------------------------ deluxe room ------------------------------------------

//------------------------------------ Premier Room -----------------------------------------

JPanel premier = new JPanel( );
premier.setBackground(Color.WHITE);
premier.setLayout(null);

ImageIcon ii1 = new ImageIcon("Premier Lake.jpg");
JLabel ll1 = new JLabel (ii1);
ll1.setBounds(10,10,400,224);
premier.add(ll1);

ImageIcon ii2 = new ImageIcon("L_Details.png");
JLabel ll2 = new JLabel (ii2);
ll2.setBounds(430,70,300,106);
premier.add(ll2);

ImageIcon ii3 = new ImageIcon("Premier_Price.png");
JLabel ll3 = new JLabel(ii3);
ll3.setBounds(250,350,252,43);
premier.add(ll3);


//------------------------------------ Premier Room -----------------------------------------

//------------------------------------ Junior Room  -----------------------------------------

JPanel junior = new JPanel( );
junior.setBackground(Color.WHITE);
junior.setLayout(null);

ImageIcon ic1 = new ImageIcon("Junior Suite Room.jpg");
JLabel lb1 = new JLabel (ic1);
lb1.setBounds(10,10,400,224);
junior.add(lb1);

ImageIcon ic2 = new ImageIcon("D_Details.png");
JLabel lb2 = new JLabel (ic2);
lb2.setBounds(430,70,300,106);
junior.add(lb2);

ImageIcon ic3 = new ImageIcon("Junior_Price.png");
JLabel lb3 = new JLabel(ic3);
lb3.setBounds(250,350,252,43);
junior.add(lb3);


//------------------------------------ Junior Room  -----------------------------------------

//------------------------------------ Single Room  -----------------------------------------

JPanel single = new JPanel( );
single.setBackground(Color.WHITE);
single.setLayout(null);

ImageIcon ig1 = new ImageIcon("Single.jpg");
JLabel le1 = new JLabel (ig1);
le1.setBounds(10,10,400,224);
single.add(le1);

ImageIcon ig2 = new ImageIcon("S_Details.png");
JLabel le2 = new JLabel (ig2);
le2.setBounds(430,70,300,119);
single.add(le2);

ImageIcon ig3 = new ImageIcon("Single_Price.png");
JLabel le3 = new JLabel(ig3);
le3.setBounds(250,350,252,43);
single.add(le3);


//------------------------------------ Single Room  -----------------------------------------

//------------------------------------ Special Features -------------------------------------

JPanel sp_f = new JPanel( );
sp_f.setBackground(Color.WHITE);
BorderLayout bl = new BorderLayout();
sp_f.setLayout(bl);

ImageIcon iii = new ImageIcon("Special.png");
JLabel lll = new JLabel(iii);

sp_f.add("Center",lll);

//-------------------------------------------------------------------------------------------

JTabbedPane tab = new JTabbedPane( );

tab.add("Deluxe Room",deluxe);
tab.add("Premier Lake View",premier);
tab.add("Junior Suite Room",junior);
tab.add("Single Room",single);
tab.add("Special Features",sp_f);

setContentPane(tab);
setVisible(true);

} // constr

} // Room



//------------------------------- User Manual ---------------------------


class UserManual extends JFrame { 

public UserManual( ) { 

super("User Manual");
setSize(1366,730);

//---------------------------------- Booking Process ----------------------

JPanel book = new JPanel( );
book.setBackground(Color.WHITE);
book.setLayout(null);

ImageIcon mf = new ImageIcon("MainFrame2.png");
JLabel l1 = new JLabel(mf);

l1.setBounds(20,20,700,374);
book.add(l1);

JTextArea t1 = new JTextArea( );
t1.setText("Booking Process\n------------------------\n\n1.For the first step, fill all the require data (NAME,NRC,PHONE,ROOMTYPE,CheckInDate,CheckOutDate).\n  *All the Data are Necessary.\n\n2.After filling all the data, click the \'Book\' Button.\n\n3.Clicking this Button will fill all this data into the Database (i.e The Manager can see these Data.).");
//t1.setLineWrap(true);
//t1.setWrapStyleWord(true);


JScrollPane scroll1 = new JScrollPane(t1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll1.setBounds(750,20,500,600);
book.add(scroll1);

//-------------------------------------------------------------------------



JTabbedPane tab = new JTabbedPane();
tab.setBackground(Color.WHITE);
tab.addTab("Booking Process",book);

setContentPane(tab);
setVisible(true);

}

}


//-----------------------------------------------------------------------

class Main_Frame extends JFrame implements ActionListener { 

JButton manual = new JButton("User Manual");

ImageIcon i1 = new ImageIcon("Hotel1.png");
JLabel l1 = new JLabel(i1);

JLabel na = new JLabel("Name");
JTextField t1 = new JTextField();

JLabel nrc = new JLabel("NRC");
JTextField t2 = new JTextField( );

JLabel ph = new JLabel("Phone");
JTextField t3 = new JTextField( );

JLabel room = new JLabel("Room Type");

JComboBox r_type;

JLabel c_in = new JLabel("Check In");
JTextField d1 = new JTextField("D");
JTextField m1 = new JTextField("M");
JTextField y1 = new JTextField("Y");

JLabel c_out = new JLabel("Check Out");
JTextField d2 = new JTextField("D");
JTextField m2 = new JTextField("M");
JTextField y2 = new JTextField("Y");

ImageIcon i2 = new ImageIcon ("H_Time.png");
JLabel tt = new JLabel(i2);

JLabel tot = new JLabel("Total");
JTextField t6 = new JTextField( );

JButton OK = new JButton("BOOK");

JButton r_i = new JButton ("Room Informations");

JButton manager = new JButton ("Manager");

JButton exit = new JButton ("Exit");

public Main_Frame( ) { 

super("Hotel Lone");
setSize(1366,730);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel pane = new JPanel( );
pane.setBackground(Color.WHITE);
pane.setLayout(null);

/*---------------------------- Action Listener ---------------------------*/

exit.addActionListener(this);
r_i.addActionListener(this);
OK.addActionListener(this);
manual.addActionListener(this);
manager.addActionListener(this);

/*------------------------------------------------------------------------*/

l1.setBounds(395,0,500,235);
pane.add(l1);


na.setBounds(200,230,150,30);
pane.add(na);

t1.setBounds(285,230,150,30);
pane.add(t1);

nrc.setBounds(200,280,150,30);
pane.add(nrc);

t2.setBounds(285,280,150,30);
pane.add(t2);

ph.setBounds(200,330,150,30);
pane.add(ph);

t3.setBounds(285,330,150,30);
pane.add(t3);

//room.setFont(f);
room.setBounds(200,380,150,30);
pane.add(room);

String ro_t [ ] = { "Deluxe Room","Premier Lake Room","Single Room","Junior Suite Room" };

r_type = new JComboBox(ro_t);
r_type.setBackground(Color.WHITE);
r_type.setBounds(285,380,150,30);
pane.add(r_type);

c_in.setBounds(200,430,150,30);
pane.add(c_in);

d1.setBounds(285,430,40,30);
pane.add(d1);

m1.setBounds(340,430,40,30);
pane.add(m1);

y1.setBounds(395,430,40,30);
pane.add(y1);

c_out.setBounds(200,480,150,30);
pane.add(c_out);

d2.setBounds(285,480,40,30);
pane.add(d2);

m2.setBounds(340,480,40,30);
pane.add(m2);

y2.setBounds(395,480,40,30);
pane.add(y2);


tt.setBounds(650,280,400,132);
pane.add(tt);


tot.setBounds(200,530,150,30);
pane.add(tot);

t6.setBounds(285,530,150,30);
pane.add(t6);

OK.setBounds(240,585,100,30);
OK.setBackground(Color.WHITE);
pane.add(OK);

manager.setBounds(676,450,150,30);
manager.setBackground(Color.WHITE);
pane.add(manager);

r_i.setBounds(880,450,150,30);
r_i.setBackground(Color.WHITE);
pane.add(r_i);

manual.setBounds(675,500,150,30);
manual.setBackground(Color.WHITE);
//pane.add(manual);

exit.setBounds(800,500,100,30);  //(880,500,150,30);  //
exit.setBackground(Color.WHITE);
pane.add(exit);

setContentPane(pane);
setVisible(true);

}

public void actionPerformed(ActionEvent ae) { 

if (ae.getActionCommand().equals("BOOK")) { 

String name = t1.getText( );
String NRC = t2.getText( );
String Phone = t3.getText( );

String rt = (String)r_type.getSelectedItem( ); // getting Room type

String in_date = d1.getText( );
String in_month = m1.getText( );
String in_year = y1.getText( );

String out_date = d2.getText( );
String out_month = m2.getText( );
String out_year = y2.getText( );

long total_c=0;

int dd3;

String di1 = d1.getText( );
int dd1 = Integer.parseInt(di1);

String di2 = d2.getText( );
int dd2 = Integer.parseInt(di2);

dd3 = dd2 - dd1;


if (rt.equals("Deluxe Room")) {

total_c = dd3 * 150000;

t6.setText(""+total_c+" Kyats");

 } // dr 

if (rt.equals("Premier Lake Room")) {

total_c = dd3 * 200000;

t6.setText(""+total_c+" Kyats");

 } // pr 

if (rt.equals("Single Room")) {

total_c = dd3 * 80000;

t6.setText(""+total_c+" Kyats");

 } // single 

if (rt.equals("Junior Suite Room")) {

total_c = dd3 * 100000;

t6.setText(""+total_c+" Kyats");

 } // jr

String c_total = ""+total_c+" Kyats";

String Check_in_Date = ""+in_date+" / "+in_month+" / "+in_year;
String Check_out_Date = ""+out_date+" / "+out_month+" / "+out_year;

try { 

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

}catch (java.lang.ClassNotFoundException e) { }

try { 

	Connection obj = DriverManager.getConnection("jdbc:odbc:Database4");

	Statement st = obj.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

	ResultSet r = st.executeQuery("SELECT * FROM Customer");

	r.moveToInsertRow( );

	r.updateString(1,name);
	r.updateString(2,NRC);
	r.updateString(3,Phone);
	r.updateString(4,rt);
	r.updateString(5,Check_in_Date);
	r.updateString(6,Check_out_Date);
	r.updateString(7,c_total);

	r.insertRow( );

JOptionPane.showMessageDialog(null,"Customer Data Are Updated","Update",JOptionPane.PLAIN_MESSAGE);

	r.close( );
	st.close( );
	obj.close( );

    } catch (SQLException se) { }


t1.setText("");
t2.setText("");
t3.setText("");

d1.setText("");
m1.setText("");
y1.setText("");

d2.setText("");
m2.setText("");
y2.setText("");

t6.setText("");


                                           } // if

if (ae.getActionCommand().equals("User Manual")) { 

UserManual um = new UserManual ();

					   } // if


if (ae.getActionCommand().equals("Exit")) { 

int res = JOptionPane.showConfirmDialog(null,"Are You Sure Do You Want To EXIT?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);

if (res==0) { System.exit(0); }

if (res==1) { setVisible(false);
              setVisible(true); }

                                           } // if

if (ae.getActionCommand().equals("Room Informations")) { 

//ysetVisible(false);
Rooms r = new Rooms( );

                                                           } // if


if (ae.getActionCommand().equals("Manager")) { 

setVisible(false);
Manager m = new Manager();

							   } // if 


} // action function

} // close class

public class Hotel_Management {

public static void main (String args[ ]) { 

Main_Frame mf = new Main_Frame( );

}

}