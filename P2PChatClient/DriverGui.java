package homeWork6;

import java.net.*;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverGui {	
	
	static HashMap<String, Driver> frames = new HashMap<String, Driver>();
	static Socket socket = new Socket(64000);
	
	public static void main(String[] args) {
		GUI();
		
		DatagramPacket packet = null;
		
		do {
			packet = socket.receive();
			
			if(packet != null) {
				System.out.println("Receiving packet");
				String thisIP = packet.getAddress().getHostAddress();
				
				int thisPort = packet.getPort();
				
				String msg = new String(packet.getData());
				
				if(!frames.containsKey(thisIP)) {
					System.out.println("here");
					Driver newWindow = new Driver(thisIP, thisPort, socket);
					frames.put(thisIP, newWindow);
					newWindow.getJTArea().append("Them: " + msg + "\n");
					newWindow.setVisible(true);
				} else {
					Driver currentChat = frames.get(thisIP);
					currentChat.getJTArea().append("Them: " + msg + "\n");
					currentChat.setVisible(true);
				}
			}
		} while (true);
		
	}
	
	public static void GUI() {
		JFrame window = new JFrame("Networks Messaging");
		window.setLocationRelativeTo(null);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setLayout(new GridBagLayout());
	    window.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	    window.setSize(500,500);
	    
	    GridBagConstraints gridThing = new GridBagConstraints();
	    
	    JLabel destIP = new JLabel("IP Address:");
	    JLabel destPort = new JLabel("Port Number:");
	    JButton start = new JButton("Start Chat");
	    JTextField enterIP = new JTextField();
	    JTextField portField = new JTextField();
	    enterIP.setFont(new Font("Serif", Font.PLAIN, 15));
	    portField.setFont(new Font("Serif", Font.PLAIN, 15));
        
	    
	    gridThing.fill = GridBagConstraints.HORIZONTAL;
	    gridThing.insets = new Insets(20, 20, 20, 20);
		gridThing.weightx = 0.5;
	    gridThing.gridx = 0;
		gridThing.gridy = 0;
		window.add(destIP, gridThing);
			    
	    gridThing.fill = GridBagConstraints.HORIZONTAL;
	    gridThing.insets = new Insets(20, 20, 20, 20);
		gridThing.weightx = 0.5;
	    gridThing.gridx = 0;
		gridThing.gridy = 1;
		window.add(destPort, gridThing);	    
	    
	    gridThing.fill = GridBagConstraints.HORIZONTAL;
	    gridThing.insets = new Insets(20, 20, 20, 20);
		gridThing.weightx = 2;
	    gridThing.gridx = 1;
		gridThing.gridy = 0;
		gridThing.gridwidth = 2;
		window.add(enterIP, gridThing);
			    
	    gridThing.fill = GridBagConstraints.HORIZONTAL;
	    gridThing.insets = new Insets(20, 20, 20, 20);
		gridThing.weightx = 2;
	    gridThing.gridx = 1;
		gridThing.gridy = 1;
		gridThing.gridwidth = 2;
		window.add(portField, gridThing);
	    	    
	    
	    gridThing.fill = GridBagConstraints.HORIZONTAL;
	    gridThing.insets = new Insets(20, 40, 0, 80);
		gridThing.weightx = 0.5;
	    gridThing.gridx = 1;
		gridThing.gridy = 3;
		gridThing.gridwidth = 1;
		window.add(start, gridThing);
		
	    start.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!enterIP.getText().isEmpty() && !portField.getText().isEmpty()) {
					if(!frames.containsKey(enterIP.getText().toString().trim())) {
						Driver newWindow = new Driver(enterIP.getText().toString().trim(), 
							Integer.parseInt(portField.getText().toString().trim()), socket);
						
						frames.put(enterIP.getText().toString().trim(), newWindow);
					}
				}
			} 
	    } );
	    
	    window.setVisible(true);
	}
	
}

