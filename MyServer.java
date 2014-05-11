import java.io.*;
import java.net.*;
import java.util.*;

public class MyServer {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    System.out.println("Daytime server ready.");
    try {
        serverSocket = new ServerSocket(4321);
       
      while(true){
        clientSocket = serverSocket.accept();
        in= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    	 in.readLine();
    	 System.out.println("Request received.");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        Date timestamp = new Date ();
        System.out.println("timestamp sent: "+timestamp.toString());
    	 out.println(timestamp.toString());
      }
    } catch (IOException e) {
        System.out.println("Error: " + e);
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
        System.exit(0);
    }
    in.close();
    out.close();
    clientSocket.close();
    serverSocket.close();

  }
}

