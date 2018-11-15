package homeWork6;

import java.net.*;

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

public class Driver extends JFrame {
	private JTextField messageBox;
	private JButton sendMessage;
	private JButton close;
	private JTextArea chatBox;
	
	public Driver(String IP, int port, Socket socket) {
    	JFrame frame = new JFrame("Destination IP: " + IP + " Port: " + port);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        
        //Creating the panel at bottom and adding components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel southPanel = new JPanel(); // the panel is not visible in output
        southPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridThing = new GridBagConstraints();
        
        close = new JButton("Close"); // Close current window
        sendMessage = new JButton("Send"); //send message
        
        messageBox = new JTextField(); // write message here
        messageBox.requestFocusInWindow();
        
        chatBox = new JTextArea();
        chatBox.setEditable(false);
        chatBox.setFont(new Font("Serif", Font.PLAIN, 16));
        chatBox.setLineWrap(true);
        gridThing.fill = GridBagConstraints.HORIZONTAL;
        gridThing.insets = new Insets(3, 1, 1, 3);
		gridThing.weightx = 3;
	    gridThing.gridx = 0;
		gridThing.gridy = 0;
		southPanel.add(messageBox, gridThing);
        
        
        gridThing.fill = GridBagConstraints.HORIZONTAL;
		gridThing.weightx = 0.5;
	    gridThing.gridx = 1;
		gridThing.gridy = 0;		
		southPanel.add(sendMessage, gridThing);
		
		
		gridThing.fill = GridBagConstraints.HORIZONTAL;
		gridThing.weightx = 0.5;
	    gridThing.gridx = 2;
		gridThing.gridy = 0;		
		southPanel.add(close, gridThing);

		JScrollPane scroll = new JScrollPane(chatBox);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(BorderLayout.SOUTH, southPanel);
        frame.getContentPane().add(BorderLayout.CENTER, scroll);
        frame.setVisible(true);
        
        sendMessage.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!messageBox.getText().isEmpty()) {
					String message = messageBox.getText().toString().trim();
					InetAddress destination = null;
					try {
			        	destination = InetAddress.getByName(IP);
			        } catch(UnknownHostException e) {
			        	e.printStackTrace();
			        }
					socket.send(message, destination, port);
					System.out.println(message);
					chatBox.append("Me: " + message + "\n");
					messageBox.setText("");
				}
			} 
	    } );
        
        close.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			} 
	    } );
	}
	
	public JTextArea getJTArea() {
		return this.chatBox;
	}
}
