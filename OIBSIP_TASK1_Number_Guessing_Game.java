package java1;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class OIBSIP_TASK1_Number_Guessing_Game extends WindowAdapter{
	Frame f;
	Random random=new Random();
	int comp =random.nextInt(1, 100);
	int count=0;
	int best_score=0;
	public OIBSIP_TASK1_Number_Guessing_Game() {
		f=new Frame();
		TextField t1,tf;
		TextArea t2,t3;
		Button b1,b2,b3;
		f.addWindowListener(this);
		f.setTitle("Guess the number");
		t1=new TextField();
		t1.setBounds(60, 150, 80, 30);
		tf=new TextField();
		tf.setBounds(170, 280, 80, 30);
		t2=new TextArea();
		t2.setBounds(25, 180, 300, 50);
		t3=new TextArea("Try to guess a number between 1 to 100. You have 5 tries in one round..");
		t3.setBounds(40, 70, 250, 50);
		Label l = new Label("Guess the number"); 
		l.setBounds(120, 30, 200, 30);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(l);
		f.add(tf);
		b1 = new Button("Guess");
		b1.setBounds(170,150,80,30);
		f.add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int user = java.lang.Integer.parseInt(t1.getText());
				count++;
				if((user==comp)&& count<=5) {
					t2.setText("Correct Guess. Click on next round");
					best_score++;
				}
				else if((user<comp)&& count<5){
					t2.setText("Number is less then computer number");
				}
				else if ((user>comp)&& count<5) {
					t2.setText("Number is greater then computer number");
				}
				else if(count>=5) {
					String result=String.valueOf(comp);
					t2.setText("You have completed your 5 try. Try in next round.\nCorrect number is:"+result);
				}
				else {
					t2.setText("Invalid number");
				}
				
			}
		});
		b2 = new Button("Next Round");
		b2.setBounds(120,240,80,30); 
		f.add(b2);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				count=0;
				t1.setText("");
				t2.setText("");
				comp =random.nextInt(1, 100);
			}
		});
		b3 = new Button("Best Score");
		b3.setBounds(60,280,80,30); 
		f.add(b3);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tf.setText(String.valueOf(best_score));
			}
		});
		f.setLayout(null);
		f.setSize(350, 350);
		f.setVisible(true);
		
	}
	public void windowClosing (WindowEvent e) {    
		    f.dispose();    
		}
	
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		OIBSIP_TASK1_Number_Guessing_Game g=new OIBSIP_TASK1_Number_Guessing_Game();
	}

}

