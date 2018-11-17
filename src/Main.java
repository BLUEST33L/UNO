import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        // Read from keyboard
        Scanner kb = new Scanner(System.in);

        // Create the deck for the game
        Deck theDeck = new Deck();

        // Get first player's name
        System.out.println("Player 1, What is your name?");
        String player1Name = kb.nextLine();
        System.out.println();

        // Get second player's name
        System.out.println("Player 2, What is your name?");
        String player2Name = kb.nextLine();

        // Create both hands, give each one a name
        Hand player1Hand = new Hand(player1Name);
        Hand player2Hand = new Hand(player2Name);

        // Deal each player seven cards
        for (int counter = 1; counter < 8; counter++) {
            Card dealtCard = theDeck.popTopCard();
            player1Hand.giveToHand(dealtCard);
            Card dealtCard2 = theDeck.popTopCard();
            player2Hand.giveToHand(dealtCard2);
        }

        // Get the starting card for the pile
        Stack<Card> thePile = new Stack<>();
        Card pileTopCard = theDeck.popTopCard();
        thePile.push(pileTopCard);

        // Start the pile with a valid card
        while (thePile.peek().getSymbol() > 10) {
            thePile.push(theDeck.popTopCard());
        }

        //System.out.println(thePile.peek());

        // Start the game with player 1 going first
        boolean player1Turn = true;

        // Continue as long as both players have at least 1 card
        while (player1Hand.numCards() > 0 && player2Hand.numCards() > 0) {

            // Set up hand references for each turn
            Hand currentHand = player1Turn ? player1Hand : player2Hand;
            Hand otherHand = player1Turn ? player2Hand : player1Hand;

            // Print out the current player's name
            System.out.println(currentHand.getName() + " it is your turn.");


            // User needs to know the current pile card
            System.out.println("Top card is: " + thePile.peek());

            // User needs to know what cards they have
            currentHand.print();
            System.out.println("Do you want to draw from the deck or pick from your hand?");
            String userInput = kb.nextLine();

            // Ensure that they cannot proceed unless they type in "draw or "pick"
            while (!userInput.equalsIgnoreCase("draw") && !userInput.equalsIgnoreCase("pick")) {
                System.out.println("That is not a valid choice. Choose \"draw\" or \"pick\"");
                userInput = kb.nextLine();
            }

            // Process their choice
            if (userInput.equalsIgnoreCase("draw")) {
                Card drawn = theDeck.popTopCard();
                System.out.println("You drew a " + drawn);
                if (drawn.canStackOn(pileTopCard)) {
                    thePile.push(drawn);
                    System.out.println("You placed" + drawn + " on the pile.");
                }
                else
                    currentHand.giveToHand(drawn);

            } else { // Guaranteed to have been "pick"

                while (true) {
                    currentHand.print();
                    System.out.println("Which card in your hand do you want to put on the pile?");
                    int choice = Integer.parseInt(kb.next());
                    kb.nextLine();
                    // As long as the choice is invalid
                    while (choice < 1 || choice > currentHand.numCards()) {
                        System.out.println("You don't have that card. Pick a card you have: ");
                        choice = Integer.parseInt(kb.next());
                        kb.nextLine();
                    }
                    Card chosenCard = currentHand.getCard(choice);
                    if (chosenCard.canStackOn(thePile.peek())) {
                        thePile.push(chosenCard);
                        currentHand.remove(choice -1);
                        break;
                    } else
                        System.out.println("That card cannot be placed on the pile. ");
                }
                // Guaranteed they placed a valid card

                // check for skips
                if (thePile.peek().getSymbol() == 10){
                    player1Turn = !player1Turn;
                }
                // check for draw 2
                if (thePile.peek().getSymbol() == 12){
                    otherHand.giveToHand(theDeck.popTopCard());
                    otherHand.giveToHand(theDeck.popTopCard());
                    player1Turn = !player1Turn;
                }
                // check for draw 4
                if (thePile.peek().getSymbol() == 14){
                        otherHand.giveToHand(theDeck.popTopCard());
                        otherHand.giveToHand(theDeck.popTopCard());
                        otherHand.giveToHand(theDeck.popTopCard());
                        otherHand.giveToHand(theDeck.popTopCard());
                        player1Turn = !player1Turn;
                }
                // check for wild
                if (thePile.peek().getSymbol() == 13){
                    System.out.println("What color would you like to set the pile");
                    System.out.println("1. Red\n 2.Green\n 3. Blue\n 4. Yellow");
                    int color =Integer.parseInt(kb.next());
                    pileTopCard.setDescription(color);
                    player1Turn = !player1Turn;
                }
            }


            // Only to prevent infinite looping while we write/test the program
            player1Turn = !player1Turn;
        }

    }
}
