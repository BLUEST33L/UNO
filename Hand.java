import java.util.ArrayList;

public class Hand {

    // Attributes
    private ArrayList<Card> cards;
    private String name;

    // Create a hand with a given name
    public Hand(String name) {
        this.name = name;
        // Initialize the card list as an empty
        this.cards = new ArrayList<>();
    }

    public void takeCard(Card c) {
        cards.add(c);
    }

    public int numberOfCards() {
        return cards.size();
    }

    public void printHand() {
        for (int i = 0; i < cards.size(); i++)
            System.out.println((i + 1) + ". " + cards.get(i).toString());
        System.out.println();

    }

}
