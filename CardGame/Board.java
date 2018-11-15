package MatchingGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import javax.imageio.ImageIO;
import javax.naming.NameAlreadyBoundException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Board extends JFrame implements ActionListener{
	
	public Board() { 
		
		JFrame frame = new JFrame("Memory Matching Game");
	    //frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    
	    frame.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	        	int n = JOptionPane.showOptionDialog(new JFrame(), "Are you sure you want to exit?", 
	        	        "MemoryGame Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
	        	        null, new Object[] {"Yes", "No"}, JOptionPane.YES_OPTION);
	            if (n == JOptionPane.YES_OPTION) {
	            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                System.out.println("Yes");
	            } if (n == JOptionPane.NO_OPTION) {
	            	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	                System.out.println("No");
	            } 	            
	        }
	    });
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //frame.pack();
	    //frame.setLocation(screenSize.width/2, screenSize.height/2);
	    
	    frame.setVisible(true);

		frame.setSize(screenSize.width/2, screenSize.height/2);
		frame.setLocationRelativeTo(null);
		
		//buttonPanel buttons = new buttonPanel();//construct an instance of buttonPAnel()
		gamePanel labels = new gamePanel();
		Card cards = new Card();		
		frame.add(labels);
		//frame.add(buttons);	
		frame.add(labels, BorderLayout.NORTH);
		frame.add(cards.cardPanel, BorderLayout.CENTER);
		frame.add(cards.gameBtns, BorderLayout.SOUTH);


	}
	
	/*public void setBoard() {
	
	}*/
	
	public static void main(String[]args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				Board gui = new Board();
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
	



