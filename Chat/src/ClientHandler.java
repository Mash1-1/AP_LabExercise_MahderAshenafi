import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket socket;
    Server server;
    DataInputStream in;
    DataOutputStream out;

    public ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        try {
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            System.out.println("Error setting up streams: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = in.readUTF();

                System.out.println("Gonna broadcast message : " + message);
                server.broadcastMessage(message, this);
            }
        } catch (Exception e) {
            System.out.println("Client disconnected.");
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
            out.flush();
        } catch (Exception e) {
            System.out.println("Error sending message: " + e.getMessage());
        }
    }
}