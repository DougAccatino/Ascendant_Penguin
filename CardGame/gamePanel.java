package MatchingGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
//import javax.swing.Timer;

public class gamePanel extends JPanel{
	static JLabel jlScore, jlAttempts, jlMatches, jlStatus;
	int count = 0;
	public gamePanel() {
		setBackground(Color.YELLOW);
		setLayout(new GridLayout(2,2));
		
		jlScore = new JLabel("Score: " + Card.point);
		jlScore.setFont(new Font("Serif", Font.PLAIN, 22));
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
		    @Override
		    public void run() {
		        jlScore.setText("Score: " + Card.point);
		    }
		}, 1000, 250);
		
		jlAttempts = new JLabel("Attempts: " + Card.num);
		jlAttempts.setFont(new Font("Serif", Font.PLAIN, 22));
		
				timer = new Timer();
				timer.scheduleAtFixedRate(new TimerTask() {
				    @Override
				    public void run() {
				        jlAttempts.setText(Card.num);
				    }
				}, 1000, 250);
		
		jlMatches = new JLabel("Matches: ");
		jlMatches.setFont(new Font("Serif", Font.PLAIN, 22));
		
		jlStatus = new JLabel("Status: ");
		jlStatus.setFont(new Font("Serif", Font.PLAIN, 22));
		
		add(jlScore);
		add(jlAttempts);
		add(jlMatches);
		add(jlStatus);
		

	}


	
}