import java.util.Collections;
import java.util.Stack;

public class Deck {

    // Attributes
    private Stack<Card> cardStack;


    // Constructor
    public Deck() {
        reset();
    }


    /**
     * Initializes the deck as if in a new game of Uno.
     * Removes all card present in the deck.
     * Adds:    Four colored 0s
     * Eight colored 1s, 2s, 3s, 4s, 5s, 6s, 7s, 8s, 9s
     * Eight colored Skips, Reverses, Draw Twos
     * Four Wilds, Wild Draw Fours
     * The cards are then shuffled.
     */
    public void reset() {
        // Create a new stack, empty at start
        cardStack = new Stack<>();

        /*  Colors 1 -> 4, Primary colors
            1: Red      2: Green
            3: Blue     4: Yellow     5: Black
        */
        // For each color
        for (int color = 1; color < 5; color++) {
            // Add a zero
            cardStack.add(new Card(color, 0));

            // Add a regular Wild
            cardStack.add(new Card(5, 13));

            // Add a Draw 4
            cardStack.add(new Card(5, 14));

            // Loop from 1 to 9, two copies each
            // Also 10 for skip, 11 for reverse, 12 for draw two
            for (int i = 1; i < 13; i++) {
                cardStack.add(new Card(color, i));
                cardStack.add(new Card(color, i));
            }

        }

        // Shuffle the deck
        Collections.shuffle(cardStack);

    }

    /**
     * Removes the top card from the deck
     *
     * @return the removed card
     */
    public Card popTopCard() {
        return cardStack.pop();
    }

}
