public class Card {

    // Attributes
    private int color;
    private int symbol;
    private String description;

    // Constructor via color and symbol separately
    public Card(int color, int symbol) {
        this.color = color;
        this.symbol = symbol;
        this.description = null;
    }

    /**
     * @return the (integer) color of the Card
     */

    public String setDescription(int c) {
        switch (c) {
            case 1:
                description = "Red Wild";
                this.color = 1;
                return description;
            case 2:
                description = "Green Wild";
                this.color = 2;
                return description;
            case 3:
                description = "Blue Wild";
                this.color = 3;
                return description;
            case 4:
                description = "Yellow Wild";
                this.color = 4;
                return description;
            default:
                return null;
        }
    }

    public int getColor() {
        return color;
    }

    /**
     * @return the (integer) symbol of the Card
     */
    public int getSymbol() {
        return symbol;
    }

    /**
     * Not yet implemented
     *
     * @param lowerCard the card upon which this Card instance is trying to stack on top of
     * @return true if the current Card can be placed on top, false otherwise
     */
    public boolean canStackOn(Card lowerCard) {
        // same number
        if (lowerCard.getSymbol() == this.getSymbol()) return true;
        // same color
        if (lowerCard.getColor() == this.getColor()) return true;
        // wild
        if (this.getColor() == 5) return true;
        // otherwise
        return false;
    }

    /**
     * @return a human readable representation of the current Card instance
     */
    public String toString() {
        if (this.description != null) return this.description;
        String description = "";
        switch (color) {
            case 1:
                description += "Red ";
                break;
            case 2:
                description += "Green ";
                break;
            case 3:
                description += "Blue ";
                break;
            case 4:
                description += "Yellow ";
                break;
            case 5:
                description += "Wild ";
                break;
        }

        switch (symbol) {
            case 10:
                description += "Skip";
                break;
            case 11:
                description += "Reverse";
                break;
            case 12:
                description += "Draw Two";
                break;
            case 13:
                description += "Wild";
                break;
            case 14:
                description += "Draw Four";
                break;
            default:
                description += String.valueOf(symbol);
                break;
        }

        return description;
    }
}
