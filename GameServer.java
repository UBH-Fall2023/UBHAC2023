// This is the server class that will run on the computer hosting the game.

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Moves.*;

public class GameServer {
    private ServerSocket serverSocket;
    private final List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());
    int numPlayers = 4;
    boolean gameOver = false;
    int currentTurn = 0;
    boolean turnOver = false;
    CatanBoard board = new CatanBoard();

    public GameServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);
    }

    public void start() {
        // We first need to get all the players
        while (clients.size() < numPlayers) {
            try {
                // Accept a new client connection
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Create a new handler for this client, then add to the list of clients
                ClientHandler clientHandler = new ClientHandler(socket, this, clients.size());
                clients.add(clientHandler);


            } catch (IOException e) {
                System.out.println("Error accepting client connection: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // We now have all of our clients connected
        // Do the initial first 2 rounds to place a road and settlement
        for (int i = 0; i < numPlayers; i++) {
            currentTurn = i;
            int movesThisTurn = 0;
            while(movesThisTurn < 2) {
                Move move = clients.get(i).getMove();
                if(move instanceof PlaceMove) {
                    this.board = move.execute();
                    movesThisTurn++;
                }
            }
        }
        for (int i = numPlayers; i > 0; i--) {
            currentTurn = i;
            int movesThisTurn = 0;
            while(movesThisTurn < 2) {
                Move move = clients.get(i).getMove();
                if(move instanceof PlaceMove) {
                    this.board = move.execute(this.board);
                    movesThisTurn++;
                }
            }
        }

        // Begin main game loop
        currentTurn = 0;
        while (!gameOver) {
            while (!turnOver) {
                Move move = clients.get(currentTurn).getMove();
                this.board = move.execute(this.board);
                turnOver = (move instanceof EndTurnMove);
            }
            currentTurn = (currentTurn + 1) % numPlayers;
            turnOver = false;
        }
    }

    public void endTurn() {
        turnOver = true;
    }

    // // This method can be called to send a message to all clients
    // public void broadcastMessage(String message) {
    //     for (ClientHandler client : clients) {
    //         client.sendMessage(message);
    //     }
    // }

    // This method can be called to send a message to all clients
    public void updateBoards() {
        for (ClientHandler client : clients) {
            try {
                client.updateBoard(this.board);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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

    public void removeClient(ClientHandler client) { // someone disconnected, just end it.
        clients.remove(client);
        gameOver = true;
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private GameServer server; // Reference to the server to interact with other clients or server-wide actions
    private int playerNum;

    public ClientHandler(Socket clientSocket, GameServer server, int playerNum) {
        this.clientSocket = clientSocket;
        this.server = server;
        try {
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            System.out.println("Error setting up streams for client handler: " + e.getMessage());
            // Handle exception (e.g., logging and cleanup)
        }
    }

    @Override
    public void run() {
        try {
            while (!server.gameOver) { // if not their turn, ignore input

            }
        } catch (IOException e) {
            System.out.println("IOException in ClientHandler: " + e.getMessage());
            // This is where you handle client disconnection
            // You might also want to remove this client from the list of clients in the
            // server
            server.removeClient(this);
            // And possibly check if the game can continue, or if it needs to end or wait
            // for a new player
        } finally {
            // Clean up resources
            try {
                input.close();
                output.close();
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error when closing streams and socket in client handler: " + e.getMessage());
            }
        }
    }

    public Move getMove() {
        while (server.currentTurn == playerNum) {
            try {
                // Read a Move object from the client
                Move move = (Move) input.readObject();

                // Execute the move or handle it according to your game logic
                move.execute(); // This will depend on the implementation of your Move class

                // Depending on your game logic, you might want to broadcast this move to other
                // clients or perform other actions.
                // server.broadcastMove(move);

                // Check if it's the end of turn
                if (move instanceof EndTurnMove) { // Assuming EndTurnMove is a subclass of Move that represents
                                                   // ending a turn
                    server.endTurn();
                }

            } catch (ClassNotFoundException e) {
                System.out.println("Received an object that is not a Move: " + e.getMessage());
            }
        }
    }

    public void updateBoard(CatanBoard board) throws IOException {
        output.writeObject(board);
    }

    // Implement other methods as needed, for example for sending messages or game
    // state updates
}
