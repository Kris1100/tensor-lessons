public class Card{
    private int rank;
    private String suit;
    static String[] allowedSuit = {"clubs","diamonds", "spades", "hearts"};
    static int[] maxRank = {1, 1, 1, 1};
    static String[] stringRank = {"two", "three", "four", "five", "six", "seven",
    "eight", "nine", "ten", "jack", "queen", "king", "ace", "joker"};


    Card(int rank, String suit){
        
        switch (suit){
            case "clubs" : {
                this.rank = rank;
                this.suit = suit;
                if (rank > Suit.CLUBS.getMaxRank()) Suit.CLUBS.setMaxRank(rank);
                break;
            }
             case "diamonds" : {
                this.rank = rank;
                this.suit = suit;
                if (rank > Suit.DIAMONDS.getMaxRank()) Suit.DIAMONDS.setMaxRank(rank);
                break;
            }
             case "spades" : {
                this.rank = rank;
                this.suit = suit;
                if (rank > Suit.SPADES.getMaxRank()) Suit.SPADES.setMaxRank(rank);
                break;
            }
             case "hearts" : {
                this.rank = rank;
                this.suit = suit;
                if (rank > Suit.HEARTS.getMaxRank()) Suit.HEARTS.setMaxRank(rank);
                break;
            }
            default: System.out.println("Передано неверное значение масти");
        }
    }

    Card(String suit){
        switch (suit){
            case "clubs" : {
                this.rank = Suit.CLUBS.getMaxRank() + 1;
                this.suit = suit;
                Suit.CLUBS.setMaxRank(rank);
                break;
            }
             case "diamonds" : {
                this.rank = Suit.DIAMONDS.getMaxRank() + 1;
                this.suit = suit;
                Suit.DIAMONDS.setMaxRank(rank);
                break;
            }
             case "spades" : {
                this.rank = Suit.SPADES.getMaxRank() + 1;
                this.suit = suit;
                Suit.SPADES.setMaxRank(rank);
                break;
            }
             case "hearts" : {
                this.rank = Suit.HEARTS.getMaxRank() + 1;
                this.suit = suit;
                Suit.HEARTS.setMaxRank(rank);
                break;
            }
            default: System.out.println("Передано неверное значение масти");
        }
    }

    public boolean isInDeck(){
        int idx = java.util.Arrays.asList(allowedSuit).indexOf(suit);
        if ((idx == 0 || idx == 1) && rank <= 15 && rank >= 2) return true;
        if ((idx == 2 || idx == 3) && rank <= 14 && rank >= 2) return true;
        return false;
    }

    public boolean isStronger(Card card){
        int idx1 = java.util.Arrays.asList(allowedSuit).indexOf(suit);
        int idx2 = java.util.Arrays.asList(allowedSuit).indexOf(card.suit);
        if (idx1 != idx2) return false;
        if (rank > card.rank) return true;
        return false;
    }

    public int compare(Card card){
        int idx1 = java.util.Arrays.asList(allowedSuit).indexOf(suit);
        int idx2 = java.util.Arrays.asList(allowedSuit).indexOf(card.suit);
        if (idx1 < idx2) return 1;
        else if (idx1 == idx2){
            if (rank == card.rank) return 0;
            else if (rank > card.rank) return 1;
            else return -1;
        }
        else return -1;
    }

    public static int compare(Card card, Card other){
        int idx1 = java.util.Arrays.asList(allowedSuit).indexOf(card.suit);
        int idx2 = java.util.Arrays.asList(allowedSuit).indexOf(other.suit);
        if (idx1 < idx2) return 1;
        else if (idx1 == idx2){
            if (card.rank == other.rank) return 0;
            else if (card.rank > other.rank) return 1;
            else return -1;
        }
        else return -1;
    }
    
    public int getRank(){
        return rank;
    }
    
    public String getSuit(){
        return suit;
    }
    
    @Override
    public int hashCode() {
        int idx = java.util.Arrays.asList(allowedSuit).indexOf(suit);
        return rank + 15 * idx;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
        return rank == other.rank && suit.equals(other.suit);
    }
    
    @Override
    public String toString() 
{
        int idx = java.util.Arrays.asList(allowedSuit).indexOf(suit);
        if (isInDeck()){
            if (rank == 15 && idx == 0)return "black " + stringRank[rank-2];
            if (rank == 15 && idx == 1)return "red " + stringRank[rank-2];
            return stringRank[rank-2] + " of " + suit;
        }
        return rank + " of " + suit;
    }

}

