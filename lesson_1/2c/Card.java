public class Card{
    private int rank;
    private String suit;
    static int maxDiamondsRank = 0;
    static int maxClubsRank = 0;
    static int maxHeartsRank = 0;
    static int maxSpadesRank = 0;

    
    Card(int rank, String suit){
        if (suit.equals("diamonds")){
            this.suit = suit;
            this.rank = rank;
            if (rank > maxDiamondsRank) maxDiamondsRank = rank;
        }
        else if (suit.equals("clubs")){
            this.suit = suit;
            this.rank = rank;
            if (rank > maxClubsRank) maxClubsRank = rank;
        }
        else if (suit.equals("hearts")){
            this.suit = suit;
            this.rank = rank;
            if (rank > maxHeartsRank) maxHeartsRank = rank;
        }
        else if (suit.equals("spades")){
            this.suit = suit;
            this.rank = rank;
            if (rank > maxSpadesRank) maxSpadesRank = rank;
        }
        else System.out.println("Передано неверное значение масти");
    }
    
    Card(String suit){
        if (suit.equals("diamonds")){
            this.suit = suit;
            this.rank = maxDiamondsRank + 1;
            maxDiamondsRank++;
        }
        else if (suit.equals("clubs")){
            this.suit = suit;
            this.rank = maxClubsRank + 1;
            maxClubsRank++;
        }
        else if (suit.equals("hearts")){
            this.suit = suit;
            this.rank = maxHeartsRank + 1;
            maxHeartsRank++;
        }
        else if (suit.equals("spades")){
            this.suit = suit;
            this.rank = maxSpadesRank + 1;
            maxSpadesRank++;
        }
        else System.out.println("Передано неверное значение масти");
    }
    
    public int getRank(){
        return rank;
    }
    
    public String getSuit(){
        return suit;
    }
}

