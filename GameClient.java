import java.io.*;
import java.net.*;

public class GameClient {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private final String serverAddress;
    private final int serverPort;

    public GameClient(String address, int port) {
        this.serverAddress = address;
        this.serverPort = port;
    }

    public void start() throws IOException {
        // Establish a connection
        socket = new Socket(serverAddress, serverPort);
        System.out.println("Connected to the server at " + serverAddress + ":" + serverPort);

        // Set up input and output streams
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Create a thread to read messages from the server
        Thread readThread = new Thread(() -> { //will recieve moves from the server
            while (true) {
                try {
                    String serverMessage = in.readLine();
                    if (serverMessage == null) {
                        break;
                    }
                    System.out.println("Server says: " + serverMessage);
                } catch (IOException e) {
                    System.out.println("Error reading from server: " + e.getMessage());
                    closeEverything();
                    break;
                }
            }
        });

        readThread.start();

        // For this example, we'll just send a greeting to the server.
        sendMessage("Hello from " + socket.getLocalAddress());
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }

    private void closeEverything() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
            System.out.println("Connection closed");
        } catch (IOException e) {
            System.out.println("Error when closing the connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // localhost
        int serverPort = 7777; // Default port

        // Optionally, accept server address and port from command-line arguments
        if (args.length >= 2) {
            serverAddress = args[0];
            try {
                serverPort = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid port number. Using default port: " + serverPort);
            }
        }

        GameClient client = new GameClient(serverAddress, serverPort);
        try {
            client.start();
        } catch (IOException e) {
            System.out.println("Cannot connect to the server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

