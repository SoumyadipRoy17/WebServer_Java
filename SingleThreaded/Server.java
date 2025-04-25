import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Server{
    
    public void run() throws IOException
    {
        int port=8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000); // Set timeout to 10 seconds

        while (true) {
            try {
                // Accept incoming connections
                System.out.println("Server started on port: " + port);
                Socket acceptedConnection = socket.accept();
                System.out.println("Client connected: " + acceptedConnection.getRemoteSocketAddress());    
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Hello from server!"); // Send greeting to client
                toClient.flush(); // Ensure the message is sent immediately

                toClient.close(); // Close the output stream to signal end of communication
                fromClient.close(); // Close the input stream to signal end of communication
                acceptedConnection.close(); // Close the accepted connection

            } catch (Exception e) {
               e.printStackTrace(); // Handle exceptions (e.g., timeout, IO errors)
            }
        }

       
    }
    
    public static void main(String[] args) {
       Server server = new Server();
        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
     
    }
}