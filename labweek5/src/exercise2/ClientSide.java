package exercise2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSide {

		public static void main(String[] args) {
			
			System.out.println("\n-----------------Client Side------------------------\n");

			// Request data
			ItemProduct ip = new ItemProduct();
			ip.setName("Orange Drink");
			ip.setPrice(2);

			try {

				// Data to establish connection to server
				int portNo = 9999;
				InetAddress serverAddress = InetAddress.getLocalHost();

				// To connect to the server at localhost for port 9999
				Socket socket = new Socket(serverAddress, portNo);

				// Open stream to send object to the server
				ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());

				// Send request to the server
				System.out.println("Send object to server: " + ip);
				objectOS.writeObject(ip);
				objectOS.flush();
				
				// to receive object from the server
				ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
				
				// Get object back from server and display details
				ip = (ItemProduct) objectIS.readObject();
				String validate = (String)objectIS.readObject();
				
				
				//display
				System.out.println("\nValidation Result : " +validate +"\n");
				System.out.println ("Id for " +"'" +ip.getName() +"'" + " is " + ip.getItemProductID());
				System.out.print("Product Price : RM "+ ip.getPrice()+"\n");
				
				// Close all closeable objects
				objectOS.close();
				objectIS.close();

			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("\n--------Client Side : End of application----------\n");

		}

	}