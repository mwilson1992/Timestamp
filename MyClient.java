import java.io.*;
import java.net.Socket;

public class MyClient{
	public static void main(String[] args) throws IOException{
		Socket clientSocket = null;
		BufferedReader in = null;
		System.out.println("Welcome to the Daytime client.");
			boolean scanning = true;
			while(scanning){
				try{
					clientSocket = new Socket("localhost", 4321);
					scanning = false;
					PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
					in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					out.println("");
					String s = in.readLine();
					System.out.println("Here is the timestamp received from the server: "+s);
					clientSocket.close();      
				}catch (IOException ioe){
					System.out.println("Connect failed, waiting and trying again");
			        try{
			            Thread.sleep(2000);//2 seconds
			        }
			        catch(InterruptedException ie){
			            System.out.println("Error: " + ie);
			        }
				}
			}   
	}
}

