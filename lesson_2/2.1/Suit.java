public enum Suit{
    CLUBS(1), DIAMONDS(1), SPADES(1), HEARTS(1);
    private int maxRank;
    Suit(int mr){
        maxRank = mr;
    }
    public int getMaxRank(){
        return maxRank;
    }
    public void setMaxRank(int mr){
        maxRank = mr;
    }
}