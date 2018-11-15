package MatchingGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//import java.util.Timer;
//import java.util.TimerTask;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Card extends JPanel implements ActionListener{
	JButton[] cardBtn = new JButton[12];
	JButton shuffle;
	JButton exit = new JButton("Exit");
	JPanel cardPanel = new JPanel(new GridLayout(3, 4));
	JPanel gameBtns = new JPanel();
    ImageIcon ic_regfruitbasket = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/fruitbasket.jpg");
    ImageIcon ic_logofruitbasket  = new ImageIcon(((Image) ic_regfruitbasket .getImage()).getScaledInstance(70, 70, Image.SCALE_FAST));
	ImageIcon[] ImageArray = new ImageIcon[12];
	static int score = 0;

	private ArrayList<Integer> cardNumVal = new ArrayList<Integer>();
	int[] cardValue = new int[2];
	int[] btnID = new int[2]; 
	static String point;
	int cards = 12;
	static double countNum = 0;
	static int countDiv = 0;
	int count = 0;
	static String num;
	//private final Timer timer = new Timer(40, this);
	
	public Card() {
		createCard();
		setArrayListText();
		createCardImage("");
		cardMatch();
		getResetButton();
		shuffleButtons();
		layoutButtons();
//        cardPanel.setLayout(new GridLayout(4,4));
        cardPanel.setVisible(true);

		gameBtns.setPreferredSize(new Dimension(150, 150));// hardCoded sizing
		gameBtns.setMaximumSize(new Dimension(250, 150));  // hardCoded sizing
		gameBtns.setMinimumSize(new Dimension(150, 150));  // hardCoded sizing
        gameBtns.add(exit);
        gameBtns.add(getResetButton());
        add(cardPanel);
        add(gameBtns);

        
        for(int i = 0; i< cardBtn.length; i++) {
        	cardPanel.add(cardBtn[i]);
        }

        ImageIcon ic_regapple = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/apple.jpg");
        cardBtn[0].setDisabledIcon(new ImageIcon(((Image) ic_regapple.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST)));
        cardBtn[4] = cardBtn[0];
        
        ImageIcon ic_regpeach = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/peach.jpg");
        cardBtn[1].setDisabledIcon(new ImageIcon(((Image) ic_regpeach.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST)));
        cardBtn[8] = cardBtn[8];
        
        ImageIcon ic_regpear = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/pear.jpg");
        cardBtn[2].setDisabledIcon(new ImageIcon(((Image) ic_regpear.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST)));
        cardBtn[11] = cardBtn[2];
        
        ImageIcon ic_regwaterMelon = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/watermelon.jpg");
        cardBtn[3].setDisabledIcon(new ImageIcon(((Image) ic_regwaterMelon.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST)));
        cardBtn[9] = cardBtn[3];
        
        ImageIcon ic_regbanana = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/banana.jpg");
        cardBtn[10].setDisabledIcon(new ImageIcon(((Image) ic_regbanana.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST)));
        cardBtn[6] = cardBtn[10];
        
        ImageIcon ic_regstrawberry = new ImageIcon("C:\\Users\\Doug\\Desktop/fruit/strawberry.jpg");
        cardBtn[5].setDisabledIcon(new ImageIcon(((Image) ic_regstrawberry.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST)));
        cardBtn[7] = cardBtn[5];
		
		}
		
	public void createCard() {
			
		for (int i = 0; i < cardBtn.length; i++) 
        {      
            cardBtn[i] = new JButton(ic_logofruitbasket);
            cardBtn[i].addActionListener(this); 
        } 
 
        exit.addActionListener(this);

		}
	
    public void shuffleButtons() {
        if (cardBtn != null) {
            Collections.shuffle(Arrays.asList(cardBtn));
            layoutButtons();
        }
    }
    public void layoutButtons() {
        for (JButton button : cardBtn) {
            cardPanel.add(button);
        }
        cardPanel.revalidate();
        cardPanel.repaint();
    }
    

    private JButton getResetButton() {
        JButton button = new JButton("Shuffle");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                shuffleButtons();
            }
        });
        return button;
    }
	
	public static ImageIcon createCardImage(String path) {
		java.net.URL imgURL = Card.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
			
	}

	public boolean cardMatch() {
	
		if(btnID[0] == btnID[1])
		{
			return true;
		}
		else
		{	
			return false;
		}
		
	}
	
	public static String clickCounter()  {    
    	countNum++;
    	if(countNum%2==0 ) {
    		countDiv++;
    	} 		
	        System.out.println(countNum + " " + countDiv);
	        num = "Attempts: " + countDiv;
	        return num;        	
}
	
	public static String Score()  {    
    		score++;    
    		System.out.println(score);
	        point = "Score: " + score;
	        return point;        	
}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(exit == e.getSource()) {
			
			JFrame exitWindow = new JFrame();
			JPanel exitPanel = new JPanel();
			JLabel quit = new JLabel("Are you sure you want to quit?");
		    JButton finalExit = new JButton("Exit");
		    JButton noExit = new JButton("Keep Playing");

			quit.setFont(new Font("Serif", Font.PLAIN, 22));
			exitWindow.setSize(500, 500);
		    exitWindow.setLocationRelativeTo(null);
		    exitWindow.setVisible(true);
		    exitWindow.toFront();
		    exitWindow.add(exitPanel);
		    exitPanel.setLayout(new GridLayout(3,0));
		    exitPanel.setSize(500,500);
		    exitPanel.add(quit, BorderLayout.NORTH);
		    exitPanel.add(finalExit, BorderLayout.EAST);
		    exitPanel.add(noExit, BorderLayout.WEST);
		    
		    finalExit.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		System.exit(0);
	    	}
	    	
	    		});
		    
		    noExit.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent arg0) {
		    	exitWindow.dispose();
		    }
		    	
		    	});
			    

		}
		  for (int i = 0; i < cardBtn.length; i++) 
          {  

              if (cardBtn[i] == e.getSource()) 
              { 
            	  clickCounter(); 
                  cardBtn[i].setEnabled(false);
                  count++;     
                  if (count == 3) 
                  { 
                      //this if statement disables and hides the cards/buttons if they match
                      if (cardMatch()) 
                      {    
                          cardBtn[0].setEnabled(false); 
                          cardBtn[0].setVisible(false);
                          cardBtn[1].setEnabled(false);
                          cardBtn[1].setVisible(false);
                          Score();
                          
                      } 
                      else
                      {  
                          
                          cardBtn[btnID[0]].setEnabled(true);
                          cardBtn[btnID[0]].setText("");
                          cardBtn[btnID[1]].setEnabled(true);
                          cardBtn[btnID[1]].setText("");

                      }    
                      count = 1;   
                      
                  }        

                  if (count == 1) 
                  {       
                      btnID[0] = i;   
                      cardValue[0] = cardNumVal.get(i); 
                  }      
                  if (count == 2) 
                  { 
                      btnID[1] = i;     
                      cardValue[1] = cardNumVal.get(i);  
                  }   
                  }
              } 
		}
            
   
  public void setArrayListText()
  {
      for (int x = 0; x < 2; x++)
      {
          for (int z = 1; z < (cardBtn.length / 2) + 1; z++)
          {
              cardNumVal.add(z);
          }
      }
  }
		
	}




