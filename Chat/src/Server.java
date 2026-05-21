import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    List<ClientHandler> activeClients = new CopyOnWriteArrayList<>();

    public void startServer() {
        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started on port 8000...");

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                ClientHandler handler = new ClientHandler(clientSocket, this);
                activeClients.add(handler);

                new Thread(handler).start();
            }
        } catch (Exception e) {
            System.out.println("Error when starting server: " + e.getMessage());
        }
    }

    public void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : activeClients) {
            if (client != sender) {
                System.out.println("Sending : " + message);
                client.sendMessage(message);
            }
        }
    }
}