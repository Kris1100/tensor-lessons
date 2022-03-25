import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
public class Deck{
    private static ArrayList<Card> list = new ArrayList<>(54);
    private Deck(){
        String[] allowedSuit = {"clubs","diamonds", "spades", "hearts"};
        for (int i = 2; i <= 14; i++){
            for (int j = 0; j <= 3; j++)
                list.add(new Card(i, allowedSuit[j]));
        }
        list.add(new Card(15, "clubs"));
        list.add(new Card(15, "diamonds"));
    }
    static public Deck createDeck(){
        return new Deck();
    }
    
    static public Card randomCard(){
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
    
    public void mix(){
        Collections.shuffle(list);
    }
    
    public Card getCard(){
        Random random = new Random();
        int idx = random.nextInt(list.size());
        Card card = list.get(idx);
        list.remove(idx);
        return card;
    }
    
    public void pushCard(Card card){
        if (list.indexOf(card) == -1)
            list.add(card);
    }
    
    public boolean isEmpty(){
        if (list.size() == 0) return true;
        return false;
    }
    
    public void sort(){
        Collections.sort(list);
    }
    
        @Override
    public String toString() {
        return list.toString();
    }
}