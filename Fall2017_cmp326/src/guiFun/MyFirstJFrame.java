package guiFun;

import javax.swing.JFrame;

public class MyFirstJFrame extends JFrame{
	
	public MyFirstJFrame(){
		
		MyFirstJP jp1 = new MyFirstJP();//construct an instance of MyFirstJPanel
		
		add(jp1);//add to jframe to be sure it is stuck there
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	
	public static void main(String[]args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				MyFirstJFrame gui = new MyFirstJFrame();
			}
		});
	}

}