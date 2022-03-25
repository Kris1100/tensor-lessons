public class Main
{
	public static void main(String[] args) {
	        Deck d = Deck.createDeck();
	        System.out.println(d);
	        Card c1 = d.getCard();
	        Card c2 = d.getCard();
	        Card c3 = d.getCard();
	        Card c4 = d.getCard();
            d.pushCard(c1);
            d.pushCard(c1);
            d.pushCard(c2);
            d.pushCard(c3);
            d.pushCard(c2);
            System.out.println(d);
            d.mix();
            System.out.println(d);
            d.sort();
            System.out.println(d);
            while (!d.isEmpty()) d.getCard();
            System.out.println(d);

        }
}
