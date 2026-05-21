import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Card extends ImageView {
    boolean flipped = true;
    String type, num;

    public Card(String num, String type) {
        this.num = num;
        this.type = type;
        loadImage();
    }

    public void flip() {
        flipped = !flipped;
        loadImage();
    }

    void loadImage() {
        if (flipped) this.setImage(new Image("./Assets/card_back.png"));
        else this.setImage(new Image("./Assets/card_" + type + "_" + num +".png"));
    }

    public int getCardValue() {
        int val = getTypeValue();
        if (Objects.equals(num, "J")) return 11 + val;
        if (Objects.equals(num, "K")) return 12+ val;
        if (Objects.equals(num, "Q")) return 13+ val;
        if (Objects.equals(num, "A")) return 1+ val;

        return  Integer.parseInt(num);
    }

    int getTypeValue() {
        if (Objects.equals(type, "diamonds")) return 10;
        if (Objects.equals(type, "spades")) return 8;
        if (Objects.equals(type, "clubs")) return 6;
        return 4;
    }
}
