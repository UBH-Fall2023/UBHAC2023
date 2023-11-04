// This is the server class that will run on the computer hosting the game.

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameServer {
    private ServerSocket serverSocket;
    private final List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());

    public GameServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);
    }

    public void start() {
        while (true) {
            try {
                // Accept a new client connection
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Create a new handler for this client, then add to the list of clients
                ClientHandler clientHandler = new ClientHandler(socket, this);
                clients.add(clientHandler);

                // Start the new thread for handling the client
                new Thread(clientHandler).start();
            } catch (IOException e) {
                System.out.println("Error accepting client connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // This method can be called to send a message to all clients
    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    // Entry point of the server program
    public static void main(String[] args) {
        int port = 7777; // Default port

        // Check for command-line arguments to change the default port
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid port number. Using default port: " + port);
            }
        }

        try {
            GameServer server = new GameServer(port);
            System.out.println("Starting the game server...");
            server.start();
        } catch (IOException e) {
            System.out.println("Cannot start the server on port: " + port);
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private GameServer server;
    private PrintWriter out;

    public ClientHandler(Socket socket, GameServer server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Read messages from the client and broadcast them
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);
                server.broadcastMessage(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Error in client handler: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Clean up
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error when closing the socket: " + e.getMessage());
            }
        }
    }

    // Method to send a message to this client
    public void sendMessage(String message) {
        out.println(message);
    }
}
