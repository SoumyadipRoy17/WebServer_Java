
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    
    public void run() throws UnknownHostException, IOException
   
    {
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost"); // Use loopback address for local testing
        Socket socket = new Socket(address, port);

        PrintWriter toServer = new PrintWriter(socket.getOutputStream());
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
        toServer.println("Hello from client!"); // Send greeting to server
        toServer.flush(); // Ensure the message is sent immediately
        String line = fromServer.readLine(); // Read response from server
        System.out.println("Server response: " + line); // Print server response

        toServer.close(); // Close the output stream to signal end of communication
        fromServer.close(); // Close the input stream to signal end of communication
        socket.close(); // Close the socket connection
        
    }
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
