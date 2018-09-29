import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        // Read from Keyboard
        Scanner kb = new Scanner(System.in);

        // Create the deck for the game
        Deck theDeck = new Deck();

        // Track whose turn it is
        boolean p1Turn = true;

        System.out.print("Player 1 what art thy name? >>> ");
        Hand player1Hand = new Hand(kb.nextLine());
        System.out.print("Player 2 what art thy name? >>> ");
        Hand player2Hand = new Hand(kb.nextLine());

        // Give both hands 7 cards to start
        for (int i = 0; i < 7; i++) {
            player1Hand.takeCard(theDeck.giveCard());
            player2Hand.takeCard(theDeck.giveCard());
        }

        // Created the discard pile
        Stack<Card> discard = new Stack<>();

        // Make sure it starts with a valid card
        do
            discard.push(theDeck.giveCard());
        while (discard.peek().getSymbol() > 9);

        // While both have at least one card - each loop is one person's turn
        while(player1Hand.numberOfCards() > 0 && player2Hand.numberOfCards() > 0){

            // Establish whose hand is active this turn
            Hand activeHand = p1Turn ? player1Hand : player2Hand;
            Hand otherHand = p1Turn ? player2Hand : player1Hand;

            // Print out prompt for current player
            System.out.println("It is Player " + (p1Turn ? "1" : "2") + "s turn!");

            System.out.println("The other player has " + otherHand.numberOfCards() + " cards.");
            System.out.println("The top card on the pile is a " + discard.peek().toString() + " .");
            activeHand.printHand();


            break;

        }
    }
}

