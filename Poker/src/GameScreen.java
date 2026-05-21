import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class GameScreen extends VBox {
    Player player, computer, judge;
    MessageDisplayer messageDisplayer;
    Controls playerControls;
    Deck deck;
    Main controller;
    public GameScreen(Main controller) {
        // Connect dependencies
        this.controller = controller;

        // Initialize components
        deck = new Deck();
        player = createNormalPlayer("Player1");
        computer = createNormalPlayer("Computer");
        judge = createJudge();
        player.flipCards();
        messageDisplayer = new MessageDisplayer();
        playerControls = new Controls(this);

        // Create restart button
        Button restart = new Button("Restart");
        restart.setOnAction(e -> {
            controller.reStart();
        });

        // Add components to main screen
        this.getChildren().addAll(computer,judge, player, playerControls, messageDisplayer, restart);

        // Some styling
        setAlignment(Pos.CENTER);
        setSpacing(10);
        
        // Starting Bid Round
        int smallBlind = 5;
        player.call(smallBlind);
        computer.call(smallBlind * 2);
    }

    public void gameOver(String reason) {
        String winner = whoWins();
        if (reason.equals("fold")) {
            messageDisplayer.sendMessage("Game Over! " + winner + " wins because of fold.");
        } else {
            messageDisplayer.sendMessage("Game Over! " + winner + " won.");
        }
    }

    public String whoWins() {
        if (player.folded) return "Computer";
        if (computer.folded) return "Player";

        // Get all cards on the table
        ArrayList<Card> playerCards = player.getCards();
        ArrayList<Card> computerCards = computer.getCards();
        ArrayList<Card> publicCards = judge.getCards();

        // Get all scores
        int publicScore = 0, playerScore = 0, computerScore = 0;
        for (Card c : publicCards) {
            publicScore += c.getCardValue();
        }

        for (Card c : playerCards) playerScore += c.getCardValue();
        for (Card c : computerCards) computerScore += c.getCardValue();

        if (playerScore >= computerScore) return "Player";
        return "Computer";
    }

    Player createNormalPlayer(String name) {
        Player p = new Player(this, 2, name);
        p.addCard(deck.getCard());
        p.addCard(deck.getCard());
        return  p;
    }

    Player createJudge() {
        Player j = new Player(this, 5, "Judge");
        j.addCard(deck.getCard());
        j.addCard(deck.getCard());
        j.addCard(deck.getCard());
        j.flipCards();
        return j;
    }
}
