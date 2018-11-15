package MatchingGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class buttonPanel extends JPanel{
//	static String num;
//	static double count = 0;
//	static int countDiv = 0;
//	private JPanel gridPanel, buttonPanel, scorePanel;
//	JButton jbApple = null,
//			jbwaterMelon = null,
//			jbStrawberry = null,
//			jbBanana = null,
//			jbPear = null,
//			jbPeach = null,
//			jbApple1 = null,
//			jbwaterMelon1 = null,
//			jbStrawberry1 = null,
//			jbBanana1 = null,
//			jbPear1 = null,
//			jbPeach1 = null;
//    private int cards = 12;
//    private int[] btnID = new int[2];   
//    private int[] btnValue = new int[2]; 
//    Random rand = new Random();
//    JButton exit = new JButton("Exit"); 
//    exit.addActionListener(this);
//	
//	JButton buttons []= {jbApple, jbwaterMelon, jbStrawberry,
//						 jbBanana, jbPear, jbPeach,
//						 jbApple1,jbwaterMelon1, jbStrawberry1,
//						 jbBanana1,jbPear1,jbPeach1
//						 };
//	
//	public buttonPanel() {
//
//		gridPanel = new JPanel(); //(new GridLayout(3,4,8,8));
//		gridPanel.setBackground(Color.RED);
//		layoutButtons();
//			
//	    add(gridPanel);
//	    add(getResetButton(), BorderLayout.SOUTH);
//
//
//	ImageIcon ic_regwaterMelon = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/watermelon.jpg");
//	ImageIcon ic_logowaterMelon = new ImageIcon(((Image) ic_regwaterMelon.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST));
//	
//	ImageIcon ic_regbanana = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/banana.jpg");
//	ImageIcon ic_logobanana = new ImageIcon(((Image) ic_regbanana.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST));
//	
//	ImageIcon ic_regapple = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/apple.jpg");
//	ImageIcon ic_logoapple = new ImageIcon(((Image) ic_regapple.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST));
//	
//	ImageIcon ic_regstrawberry = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/strawberry.jpg");
//	ImageIcon ic_logostrawberry = new ImageIcon(((Image) ic_regstrawberry.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST));
//	
//	ImageIcon ic_regpear = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/pear.jpg");
//	ImageIcon ic_logopear = new ImageIcon(((Image) ic_regpear.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST));
//	
//	ImageIcon ic_regpeach = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/peach.jpg");
//	ImageIcon ic_logopeach = new ImageIcon(((Image) ic_regpeach.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST));
//	
//	ImageIcon ic_regfruitbasket = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/fruitbasket .jpg");
//	ImageIcon ic_logofruitbasket  = new ImageIcon(((Image) ic_regfruitbasket .getImage()).getScaledInstance(70, 70, Image.SCALE_FAST));
//	
//	jbApple = new JButton();
//	jbApple.setIcon(ic_logofruitbasket);
//	jbApple.setSelectedIcon(ic_logoapple);
//
//	jbPear = new JButton();
//	jbPear.setIcon(ic_logofruitbasket);
//	jbPear.setSelectedIcon(ic_logopear);
//	
//	jbwaterMelon = new JButton();
//	jbwaterMelon.setIcon(ic_logofruitbasket);
//	jbwaterMelon.setSelectedIcon(ic_logowaterMelon);
//	
//	jbStrawberry = new JButton();	
//	jbStrawberry.setIcon(ic_logofruitbasket);
//	jbStrawberry.setSelectedIcon(ic_logostrawberry);
//	
//	jbBanana = new JButton();
//	jbBanana.setIcon(ic_logofruitbasket);
//	jbBanana.setSelectedIcon(ic_logobanana);
//	
//	jbPeach = new JButton();	
//	jbPeach.setIcon(ic_logofruitbasket);
//	jbPeach.setSelectedIcon(ic_logopeach);
//	
//	jbApple1 = new JButton();	
//	jbApple1.setIcon(ic_logofruitbasket);
//	jbApple1.setSelectedIcon(ic_logoapple);
//
//	
//	jbPear1 = new JButton();	
//	jbPear1.setIcon(ic_logofruitbasket);
//	jbPear1.setSelectedIcon(ic_logopear);
//	
//	jbwaterMelon1 = new JButton();	
//	jbwaterMelon1.setIcon(ic_logofruitbasket);
//	jbwaterMelon1.setSelectedIcon(ic_logowaterMelon);
//	
//	jbStrawberry1 = new JButton();	
//	jbStrawberry1.setIcon(ic_logofruitbasket);
//	jbStrawberry1.setSelectedIcon(ic_logostrawberry);
//	
//	jbBanana1 = new JButton();
//	jbBanana1.setIcon(ic_logofruitbasket);
//	jbBanana1.setSelectedIcon(ic_logobanana);
//	
//	jbPeach1 = new JButton();
//	jbPeach1.setIcon(ic_logofruitbasket);
//	jbPeach1.setSelectedIcon(ic_logopeach);
//	
//	jbApple.addActionListener(new ActionListener(){
//    public void actionPerformed(ActionEvent e) {
//		
//    	Counter();
//    	                }
//	});
//	jbwaterMelon.addActionListener(new ActionListener(){
//	    public void actionPerformed(ActionEvent e) {
//			
//	    	Counter();
//	    	                }
//		});
//	jbStrawberry.addActionListener(new ActionListener(){
//	    public void actionPerformed(ActionEvent e) {
//			
//	    	Counter();
//	    	                }
//		});
//	jbBanana.addActionListener(new ActionListener(){
//	    public void actionPerformed(ActionEvent e) {
//			
//	    	Counter();
//	    	                }
//		});
//	jbPeach.addActionListener(new ActionListener(){
//	    public void actionPerformed(ActionEvent e) {
//			
//	    	Counter();
//	    	                }
//		});
//	jbPear.addActionListener(new ActionListener(){
//	    public void actionPerformed(ActionEvent e) {
//			
//	    	Counter();
//	    	                }
//		});
//	//----------------------------------------------------------------
//	jbApple1.addActionListener(new ActionListener(){
//	    public void actionPerformed(ActionEvent e) {
//			
//	    	Counter();
//	    	                }
//		});
//	jbwaterMelon1.addActionListener(new ActionListener(){
//	    public void actionPerformed(ActionEvent e) {
//			
//	    	Counter();
//	    	                }
//		});
//	jbStrawberry1.addActionListener(new ActionListener(){
//	    public void actionPerformed(ActionEvent e) {
//			
//	    	Counter();
//	    	                }
//		});
//	jbBanana1.addActionListener(new ActionListener(){
//	    public void actionPerformed(ActionEvent e) {
//			
//	    	Counter();
//	    	                }
//		});
//	jbPeach1.addActionListener(new ActionListener(){
//	    public void actionPerformed(ActionEvent e) {
//			
//	    	Counter();
//	    	                }
//		});
//	jbPear1.addActionListener(new ActionListener(){
//	    public void actionPerformed(ActionEvent e) {
//			
//	    	Counter();
//	    	                }
//		});
//	
//
//	//jbutton/cards
//	add(jbApple);
//	add(jbPear);
//	add(jbwaterMelon);
//	add(jbPeach);
//	add(jbStrawberry);
//	add(jbBanana);
//	//------------------
//	add(jbApple1);
//	add(jbPear1);
//	add(jbwaterMelon1);
//	add(jbPeach1);
//	add(jbStrawberry1);
//	add(jbBanana1);
//		
//	}
//	
////	public void shuffle() {
////		if(buttons != null) {
////			Collections.shuffle(Arrays.asList(buttons));
////			layoutButtons();
////		}
////	}
////	
////	public void layoutButtons() {
////		gridPanel.removeAll();
////		for(JButton button : buttons) {
////			gridPanel.add(button);
////		}
////		gridPanel.revalidate();
////		gridPanel.repaint();
////	}
//
////	private JButton[] getButtons(int size) {
////		JButton[] buttons = new JButton[size];
////        for (int i = 0; i < size; i++) {
////        	
////            JButton button = new JButton(new ImageIcon("fruit"+i+".jpg"));
////            button.addActionListener(new ActionListener(){
////                public void actionPerformed(ActionEvent e) {
////            		
////                	
////                	                }
////            });
////            buttons[i] = button;
////        }
////        return buttons;
//		
////	}
//	
//	 public static String Counter()  {    
//	        	count++;
//	        	if(count%2==0 ) {
//	        		countDiv++;
//	        	} 		
//			        System.out.println(count + " " + countDiv);
//			        num = "Attempts: " + countDiv;
//			        return num;        	
//	    }
//	
////	private JButton getResetButton() {
////        JButton button = new JButton("RESET");
////        button.addActionListener(new ActionListener(){
////            public void actionPerformed(ActionEvent e) {
////                shuffle();
////            }
////        });
////        return button;
////    }
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	

}
