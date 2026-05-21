package ClientUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Objects;

public class Client extends Application {
    Stage primaryStage;
    Chat chatUI;
    DataOutputStream out;
    DataInputStream in;
    String username;
    Socket conn;

    @Override
    public void start(Stage stage) throws Exception {
        // Create a socket and connect to server
        try {
            conn = new Socket("localhost", 8000);
            this.primaryStage = stage;

            // Get and assign io streams
            in = new DataInputStream(conn.getInputStream());
            out = new DataOutputStream(conn.getOutputStream());

            // Create components
            UsernameInput usernameInput = new UsernameInput(this);
            Scene startScene = new Scene(usernameInput, 500, 500);
            stage.setScene(startScene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error when connecting to server : " + e.getMessage());
        }
    }

    public void startListening() {
        Thread listenerThread = new Thread(() -> {
            try {
                while (true) {
                    String incomingMessage = in.readUTF();
                    System.out.println("Got message from server : " + incomingMessage);

                    String[] parts = incomingMessage.split(":");
                    String from = parts[0];
                    String msg = parts[1];
                    String to = parts[2];
                    System.out.println("Got message from : " + from + " to : " + to + " message : " + msg);
                    System.out.println("I am " + username);
                    if (!Objects.equals(to, username)) {
                        continue;
                    }
                    Platform.runLater(() -> {
                        chatUI.addMessageToUI(msg, from);
                    });
                }
            } catch (Exception e) {
                System.out.println("Error when reading input from server : " + e.getMessage());
            }
        });
        listenerThread.setDaemon(true);
        listenerThread.start();
    }

    public void goToChat() {
        chatUI = new Chat(this);
        Scene chatScene = new Scene(chatUI, 500, 700);
        primaryStage.setScene(chatScene);
        primaryStage.show();
        startListening();
    }

    public void sendMessage(String message, String to) {
       try {
           out.writeUTF(username + ":" + message + ":" + to);
           out.flush();
       } catch (Exception e) {
           System.out.println("Error when sending a message : " + e.getMessage());
       }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void stop() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error when closing client connection : " + e.getMessage());
        }
    }
}
