// first import dump file(given as another file in this repository) in my sql workbench and then run this project on eclipse and change username and password in this code with your mysql username and password
package java1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class OIBSIP_Task2_Online_Examination extends WindowAdapter{
	JFrame f,f2,f3,f4,f5,f6;
	int i=2;
	int bestscore=0;
	public OIBSIP_Task2_Online_Examination() {
		f=new JFrame("Online Exam");  
	    f.getContentPane().setBackground(Color.pink);
		f.addWindowListener(this);
		Button Reg,Log;
		Label l1,l2,l3,l4,l5,l6,l7;
		TextField t1,t2,t3;
		JPasswordField t4;
		l1=new Label("Online Examination System");
		l1.setBounds(100, 100, 600, 100);
		l1.setFont(new Font("Arial", Font.PLAIN, 40));
		f.add(l1);
		l2=new Label("Name");
		l2.setBounds(100, 250, 100, 30);  
		f.add(l2);
		t1=new TextField();
		t1.setBounds(300, 250, 200, 30);
		f.add(t1);
		l3=new Label("Email id");
		l3.setBounds(100, 300, 100, 30);
		f.add(l3);
		t2=new TextField();
		t2.setBounds(300, 300, 200, 30);
		f.add(t2);
		l4=new Label("Username");
		l4.setBounds(100, 350, 100, 30);
		f.add(l4);
		t3=new TextField();
		t3.setBounds(300, 350, 200, 30);
		f.add(t3);
		l5=new Label("Password");
		l5.setBounds(100, 400, 100, 30);
		f.add(l5);
		t4=new JPasswordField();
		t4.setBounds(300, 400, 200, 30);
		f.add(t4);
		Reg = new Button("Register");
		Reg.setBounds(250,500,200,30);
		f.add(Reg);
		l7=new Label();
		l7.setBounds(250, 540, 300, 30);
		f.add(l7);
		l6=new Label("If already registered than click login");
		l6.setFont(new Font("Arial", Font.PLAIN, 15));
		l6.setBounds(230, 570, 500, 30);
		f.add(l6);
		Log = new Button("Login");
		Log.setBounds(250,600,200,30);
		f.add(Log);
		f.setLayout(null);
		f.setSize(700, 700);
		f.setVisible(true);
		Log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2=new JFrame("Login");
				f.dispose();
				f2.getContentPane().setBackground(Color.pink); 
				f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Label user,pass,res;
				TextField usertext, passtext;
				Button login;
				user=new Label("Enter username");
				user.setBounds(100, 250, 200, 30);  
				user.setFont(new Font("Arial", Font.PLAIN, 20));
				f2.add(user);
				usertext=new TextField();
				usertext.setBounds(350, 250, 200, 30);
				f2.add(usertext);
				pass=new Label("Enter password");
				pass.setBounds(100, 300, 200, 30); 
				pass.setFont(new Font("Arial", Font.PLAIN, 20));
				f2.add(pass);
				passtext=new TextField();
				passtext.setBounds(350, 300, 200, 30);
				f2.add(passtext);
				login=new Button("Login");
				login.setBounds(200, 400, 200, 30);
				login.setFont(new Font("Arial", Font.PLAIN, 20));
				f2.add(login);
				res=new Label();
				res.setFont(new Font("Arial", Font.PLAIN, 20));
				res.setBounds(170, 500, 400, 30);
				f2.add(res);
				f2.setLayout(null);
				f2.setSize(700, 700);
				f2.setVisible(true);
				login.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver"); 
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/name","root","6884");
							Statement stmt=con.createStatement();
							String u=usertext.getText();
							String p=passtext.getText();
							String sql ="SELECT password FROM online_examination WHERE username='" + u + "' AND password='" + p + "'";
							ResultSet rs=stmt.executeQuery(sql);
							if(rs.next()) {
								f3=new JFrame("");
								f2.dispose();
								f3.getContentPane().setBackground(Color.pink); 
								f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								Button update,start;
								Label welcome;
								welcome=new Label("You can start test now!");
								welcome.setBounds(150, 100, 600, 100);
								welcome.setFont(new Font("Arial", Font.PLAIN, 40));
								f3.add(welcome);
								update=new Button("Update password");
								update.setBounds(250, 250, 200, 30);  
								update.setFont(new Font("Arial", Font.PLAIN, 20));
								f3.add(update);
								start=new Button("Start Test");
								start.setBounds(250, 350, 200, 30);  
								start.setFont(new Font("Arial", Font.PLAIN, 20));
								f3.add(start);
								f3.setLayout(null);
								f3.setSize(700, 700);
								f3.setVisible(true);
								update.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										f6=new JFrame();
										f6.getContentPane().setBackground(Color.pink);
//										f3.dispose();
										Label current,newpass,res1;
										TextField currenttext,newpasstext;
										current=new Label("Current Password");
										current.setBounds(100, 250, 200, 30);  
										current.setFont(new Font("Arial", Font.PLAIN, 20));
										f6.add(current);
										currenttext=new TextField();
										currenttext.setBounds(350, 250, 200, 30);
										f6.add(currenttext);
										newpass=new Label("New Password");
										newpass.setBounds(100, 300, 200, 30); 
										newpass.setFont(new Font("Arial", Font.PLAIN, 20));
										f6.add(newpass);
										newpasstext=new TextField();
										newpasstext.setBounds(350, 300, 200, 30);
										f6.add(newpasstext);
										Button up=new Button("Update");
										up.setBounds(200, 400, 200, 30);
										up.setFont(new Font("Arial", Font.PLAIN, 20));
										f6.add(up);
										Button back=new Button("Go Back");
										back.setBounds(200, 500, 200, 30);
										back.setFont(new Font("Arial", Font.PLAIN, 20));
										f6.add(back);
										res1=new Label();
										res1.setFont(new Font("Arial", Font.PLAIN, 20));
										res1.setBounds(250, 450, 300, 30);
										back.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												f6.dispose();
											}
										});
										up.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												try {
													Class.forName("com.mysql.cj.jdbc.Driver"); 
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/name","root","6884");
													Statement stmt=con.createStatement();
													String np=newpasstext.getText();
													String cp=currenttext.getText();
													String sql ="SELECT password FROM online_examination WHERE username='" + u + "' AND password='" + cp + "'";
													ResultSet rs=stmt.executeQuery(sql);
													if(rs.next()) {
														String sql1 ="UPDATE online_examination set password='" + np + "' WHERE username='" + u + "'";
														stmt.executeUpdate(sql1);
														res1.setText("Updated");
													}
													else {
														res1.setText("Incorrect current password");
													}
												}
												catch(Exception error1) {
													res1.setText("Error");
												}
											}
										});
										f6.add(res1);
										f6.add(up);
										f6.setLayout(null);
										f6.setSize(700, 700);
										f6.setVisible(true);
									}
								});
								start.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										f4=new JFrame("");
										f3.dispose();
										f4.getContentPane().setBackground(Color.pink); 
										f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										Label question,time;
										Button save;
										time=new Label();
										time.setBounds(100, 100, 200, 30);
										f4.add(time);
										Timer timer = new Timer();
										timer.scheduleAtFixedRate(new TimerTask() {
								            int i = 600;
								            public void run() {  
								                time.setText("Time left: " + i);
								                i--;   
								                if (i < 0) {
								                    timer.cancel();
								                    f4.dispose();
								                    f5=new JFrame();
								                    f5.getContentPane().setBackground(Color.pink);
								                    Label l=new Label("Your session out! Please click exit");
								                    l.setBounds(100, 100, 600, 100);
								            		l.setFont(new Font("Arial", Font.PLAIN, 30));
								                    f5.add(l);
								                    Button exit1=new Button("Exit");
								                    exit1.setBounds(250, 300, 100, 30);
													exit1.setFont(new Font("Arial", Font.PLAIN, 20));
								                    f5.add(exit1);
								                    exit1.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															f5.dispose();
														}
													});

								                    f5.setLayout(null);
													f5.setSize(700, 700);
													f5.setVisible(true);
								                } 
								            }
								        }, 0, 1000);  
										save=new Button("Save And Next");
										save.setBounds(450, 500, 200, 30);
										save.setFont(new Font("Arial", Font.PLAIN, 15));
										f4.add(save);
										question=new Label("Number of primitive data types in java are?");
										question.setBounds(100, 150, 500, 30);  
										question.setFont(new Font("Arial", Font.PLAIN, 20));
										f4.add(question);
										JRadioButton o1,o2,o3,o4;
										o1=new JRadioButton("6");
										o1.setBounds(100, 250, 400, 30);
										o2=new JRadioButton("7");
										o2.setBounds(100, 300, 400, 30);
										o3=new JRadioButton("8");
										o3.setBounds(100, 350, 400, 30);
										o4=new JRadioButton("9");
										o4.setBounds(100, 400, 400, 30);
										ButtonGroup bg=new ButtonGroup();
										bg.add(o1);
										bg.add(o2);
										bg.add(o3);
										bg.add(o4);
										f4.add(o1);
										f4.add(o2);
										f4.add(o3);
										f4.add(o4);
										f4.setLayout(null);
										f4.setSize(700, 700);
										f4.setVisible(true);
										save.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												if(i==2) {
													if(o3.isSelected()) {
														bestscore++;
													}
													bg.clearSelection();
													question.setText("What is the size of float and double in java?");
													o1.setText("32 and 64");
													o2.setText("32 and 32");
													o3.setText("64 and 64");
													o4.setText("64 and 32");
													i++;
												}
												else if(i==3) {
													if(o1.isSelected()) {
														bestscore++;
													}
													bg.clearSelection();
													i++;
													question.setText("Select the valid Statement");
													o1.setText("char[] ch= new char(5)");
													o2.setText("char[] ch= new char[5]");
													o3.setText("char[] ch= new char()");
													o4.setText("char[] ch= new char[5]");
												}
												else if(i==4) {
													if(o2.isSelected()) {
														bestscore++;
													}
													bg.clearSelection();
													i++;
													question.setText("Arrays in java are?");
													o1.setText("object references");
													o2.setText("objects");
													o3.setText("primitive data type");
													o4.setText("None");
												}
												else if(i==5) {
													if(o2.isSelected()) {
														bestscore++;
													}
													bg.clearSelection();
													i++;
													question.setText("CompareTo returns");
													o1.setText("true");
													o2.setText("false");
													o3.setText("An int value");
													o4.setText("None");
												}
												else if(i==6) {
													if(o3.isSelected()) {
														bestscore++;
													}
													bg.clearSelection();
													i++;
													question.setText("Total constructor string class have");
													o1.setText("3");
													o2.setText("7");
													o3.setText("13");
													o4.setText("20");
												}
												else if(i==7) {
													if(o3.isSelected()) {
														bestscore++;
													}
													bg.clearSelection();
													i++;
													question.setText("Output of Math.floor(3.6)");
													o1.setText("3");
													o2.setText("3.0");
													o3.setText("4");
													o4.setText("4.0");
												}
												else if(i==8) {
													if(o2.isSelected()) {
														bestscore++;
													}
													bg.clearSelection();
													i++;
													question.setText("Identify the infinite loop");
													o1.setText("for(;;)");
													o2.setText("for(int i=0;i<1;i--)");
													o3.setText("for(int i=0;;i++)");
													o4.setText("All of the above");
												}
												else if(i==9) {
													if(o4.isSelected()) {
														bestscore++;
													}
													bg.clearSelection();
													i++;
													question.setText("What is runnable?");
													o1.setText("abstract class");
													o2.setText("interface");
													o3.setText("class");
													o4.setText("method");
												}
												else {
													if(o2.isSelected()) {
														bestscore++;
													}
													bg.clearSelection();
													question.setText("Where is System class defined?");
													o1.setText("java.lang.package");
													o2.setText("java.util.package");
													o3.setText("java.io.package");
													o4.setText("None");
													save.setVisible(false);
													Button submit=new Button("Submit");
													submit.setBounds(450, 500, 200, 30);
													submit.setFont(new Font("Arial", Font.PLAIN, 15));
													f4.add(submit);
													submit.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															if(o1.isSelected()) {
																bestscore++;
															}
															Label score=new Label("Your score is:"+bestscore);
															score.setBounds(250, 550, 200, 30);
															score.setFont(new Font("Arial", Font.PLAIN, 20));
															f4.add(score);
															Button exit=new Button("Exit");
															exit.setBounds(250, 600, 100, 30);
															exit.setFont(new Font("Arial", Font.PLAIN, 20));
															f4.add(exit);
															exit.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent e) {
																	f4.dispose();
																}
															});
														}
													});
												}
											}
										});
									}
								});
							}
							else {
								res.setText("Invalid username or password!");
							}
						}
						catch(Exception error) {
							res.setText("error");
						}
					}
				});
			}
		});
		
		Reg.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/name","root","6884");
					PreparedStatement ps=con.prepareStatement("insert into online_examination values(?,?,?,?)");
					Statement stmt=con.createStatement();
					String s=t2.getText();
					String SQL ="SELECT * FROM online_examination WHERE emailid='" + s + "'";
					ResultSet rs=stmt.executeQuery(SQL);
					if(rs.next()) {
						l7.setText("Already Exists you can use another emailid!");
					}
					else {
						ps.setString(1,t1.getText());
						ps.setString(2,t2.getText());
						ps.setString(3,t3.getText());
						ps.setString(4,t4.getText());
						ps.executeUpdate();
						l7.setText("Registered now you can login!");
					}
					con.close();
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
	}
	public void windowClosing (WindowEvent e) {    
	    f.dispose();  
	}
	public static void main(String[] args) {
		new OIBSIP_Task2_Online_Examination();
	}
}
