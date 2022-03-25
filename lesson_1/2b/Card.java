public class Card{
    private int rank;
    private String suit;
    
    Card(int rank, String suit){
        this.rank = rank;
        if (!suit.equals("diamonds") && !suit.equals("clubs")
        && !suit.equals("hearts") && !suit.equals("spades")){
            System.out.println("Передано неверное значение масти");
        }
        else this.suit = suit;
    }
    
    public int getRank(){
        return rank;
    }
    
    public String getSuit(){
        return suit;
    }
}

