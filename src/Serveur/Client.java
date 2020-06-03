package Serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import Etudiant.Application.ExamQCM;


public class Client{
	
	private Socket clientSocket;
	private int port;
	private String host;
	private ObjectOutputStream dataOut;
	private ObjectInputStream dataIn;
	
	public Client(String etudiant) throws UnknownHostException, IOException 
	{
		port = 1306;
		host = "localhost";
		clientSocket = new Socket(host, port);
		System.out.println("Connection establisehd with the Server");
		System.out.println("****************************************************");
		//Creating streams of communication
		dataOut = new ObjectOutputStream(clientSocket.getOutputStream());
		dataIn = new ObjectInputStream(clientSocket.getInputStream());
		
		dataOut.writeUTF(etudiant);
		dataOut.flush();
}
	
	synchronized public void envoyerExam(ExamQCM exam)
	{
		try {
			dataOut.writeObject(exam);
			dataOut.flush();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Envoi d'object au Serveur");
		System.out.println("*****************************************************");
	}
	
	
	
	
	// Shutting diwn the client properly
	synchronized public void shutDown()
	{
		// Closing Streams
		try {
			dataOut.close();
			dataIn.close();
			//Closing connection
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Connection released!");
		
	}
	/*public static void main(String[] args) throws UnknownHostException, IOException 
	{
		Client client = new Client();
	}*/

}
