package guiFun;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NameAlreadyBoundException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFirstJP extends JPanel implements ActionListener{//step 1 implement the app
		private JLabel jlOutput, jlNum1, jlNum2;
		private JTextField jtf1, jtf2;
		private JButton jbAdd, jbSub;
		
	public MyFirstJP() { //constructor for jpanel
		setBackground(Color.GRAY);
		setLayout(new GridLayout(4,2,5,5));
		jlOutput = new JLabel ("\t\tYour answer will appear here.");
		jlOutput.setFont(new Font("Serif", Font.PLAIN,24));
		
		jlNum1 = new JLabel("Num1: ",JLabel.CENTER);
		jlNum1.setFont(new Font("Serif", Font.PLAIN, 22));
		

		jlNum2 = new JLabel("Num2: ",JLabel.CENTER);
		jlNum2.setFont(new Font("Serif", Font.PLAIN, 22));

		
		jtf1 = new JTextField(8);
		jtf2 = new JTextField(8);
		jbAdd = new JButton("Add");
		jbAdd.setFont(new Font("Serif", Font.PLAIN, 22));
		//jbAdd.setPreferredSize(new Dimension(100,100));

		
		jbSub = new JButton("Sub");
		jbSub.setFont(new Font("Serif", Font.PLAIN, 22));
		//jbSub.setPreferredSize(new Dimension(100,100));
		
		jbAdd.addActionListener(this);//step 2 add listener
		jbSub.addActionListener(this);
		
		add(jlNum1);
		add(jtf1);
		add(jlNum2);
		add(jtf2);
		add(jbAdd);
		add(jbSub);
		add(jlOutput);
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//step 3 complete the body for the action performed method
		//system.out.println("inside actionperformed");
		//system.out.println("OHHH + e.getActionCommand() + " was clicked");
		//jlOUTPUT.setText("Button"+e.getActionCommand() + "Was cliked");
		JButton btnClicked = (JButton) e.getSource();
		int num1, num2;
		try {
		num1 = getIntFromTextField(jtf1);
		num2 = getIntFromTextField(jtf2);
		if(btnClicked.equals(jbAdd)) {
			jlOutput.setText("SUM of: " + num1 + " & " + num2 +  " = " + (num1 + num2));	
		}
		else {
			jlOutput.setText("DIFF of: " + num1 + " & " + num2 +  " = " + (num1 - num2));	
		}
		}catch (Exception e1) {
		jlOutput.setText(e1.getMessage());
	}
		
}


private int getIntFromTextField(JTextField jtf)throws NumberFormatException,Exception {
	int val = 0;
	try {
	val = Integer.parseInt(jtf.getText());
	}
	catch(NumberFormatException nfe) {
		//jlOutput.setText("Numbers only please");	
		throw new NumberFormatException("Numbers only: " +jtf.getText()+" is invalid");
	}
	catch(Exception e) {
		//jlOutput.setText(e.getMessage());
		throw new Exception("BAD BAD");
	}
	return val;
}
}