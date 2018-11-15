package homeWork6;

import java.net.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Socket {
   private InetAddress myAddress;

   private int port;
   
   private DatagramSocket socket = null;
   
   //private ConcurrentLinkedQueue<String> messageQueue = new ConcurrentLinkedQueue<String>();
   private ConcurrentLinkedQueue<DatagramPacket> messageQueue = new ConcurrentLinkedQueue<DatagramPacket>();
   
   public Socket(int port) {
	   this.port = port;
      try {
         //Retrieves IP address of local host
         this.myAddress = InetAddress.getLocalHost();
         
         // Creating a socket at this particular address
         this.socket = new DatagramSocket(port, this.myAddress);
      } catch (Exception e) {
         e.printStackTrace();
         System.exit(-1);
      }
      
      // Runnable thread that will execute receiving of messages
      Thread receiveThread = new Thread(
    		  	new Runnable() {
    		  		public void run() {
    		  			receiveThread();
    		  		}
    		  	}
    		  );
      
      receiveThread.setName("Receive thread for port = " + this.port);
      
      // Runs the thread
      receiveThread.start();
   }
   
   public void receiveThread() {
	   //byte[] inBuffer = new byte[1024];
	   
	   //DatagramPacket inPacket = new DatagramPacket(inBuffer, inBuffer.length);
	   
	   do {		   
		   byte[] inBuffer = new byte[1024];
		   //Clears buffer
		   for (int i = 0; i < inBuffer.length; i++) {
			   inBuffer[i] = ' ';
		   }
		   
		   DatagramPacket inPacket = new DatagramPacket(inBuffer, inBuffer.length);
		   
		   try {
			   socket.receive(inPacket);
		   } catch (Exception e) {
			   e.printStackTrace();
			   System.exit(-1);
		   }
		   
		   String message = new String(inPacket.getData());
		   
		   System.out.println("Receive Thread - Mesage on port: " + this.port 
				   + " Message: " + message + "\n" + " From IP: " + inPacket.getAddress()
				   + " From port: " + inPacket.getPort());

		   messageQueue.add(inPacket);
		   
	   } while (true);
   }

   public DatagramPacket receive() {
      return messageQueue.poll();
   }

   public void send(String s, InetAddress destIP, int destPort) {
      byte[] outBuffer;
      
      try {
    	  outBuffer = s.getBytes();
         
         DatagramPacket outPacket = new DatagramPacket(outBuffer, s.length());
         
         outPacket.setAddress(destIP);

         outPacket.setPort(destPort);

         socket.send(outPacket);
         
      } catch (Exception e) {
         
      }
   }
}