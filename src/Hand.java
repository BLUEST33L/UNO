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

    /**
     * Inserts the given card at the end of hand
     *
     * @param card the card to be inserted
     */
    public void giveToHand(Card card) {
        cards.add(card);
    }

    /**
     * @return the number of cards in the hand
     */
    public int numCards() {
        return this.cards.size();
    }

    /**
     * Needs to be formatted
     * Outputs all the cards contained in this hand to the display
     */
    public void print() {
        for (int cardNumber = 0; cardNumber < cards.size(); cardNumber++)
            System.out.println((cardNumber + 1) + ". " + cards.get(cardNumber).toString());
    }

    public String getName() {
        return name;
    }

    public Card getCard(int c) {
        return cards.get(c - 1);
    }

    public void remove(int c){
        cards.remove(c);
    }
}
