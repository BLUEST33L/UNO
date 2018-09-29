public class Card {

    // Attributes
    private int color;
    private int symbol;

    // Constructor
    public Card(int color, int symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    // Getter
    public int getColor() {
        return color;
    }

    public int getSymbol() {
        return symbol;
    }

    public boolean canStack(Card c) {
        return false;
    }

    // Returns a description of the card
    public String toString() {
        String description = "";
        // TODO: Build it based on color and symbol
        switch (color) {
            case 1:
                description += "Red, ";
                break;
            case 2:
                description += "Green, ";
                break;
            case 3:
                description += "Blue, ";
                break;
            case 4:
                description += "Yellow, ";
                break;
            default:
                description += "Wild, ";
        }

        switch (symbol) {
            case 10:
                description += "Skip";
                break;
            case 11:
                description += "Reverse";
                break;
            case 12:
                description += "Draw 2";
                break;
            case 13:
                description += "";
                break;
            case 14:
                description += "Draw 4";
                break;
            default:
                description += String.valueOf(symbol);
        }

        return description;
    }
}
