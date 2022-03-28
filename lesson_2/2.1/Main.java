public class Main
{
	public static void main(String[] args) {
	        Card d1 = new Card(4, "diamonds");
	        Card d2= new Card("diamonds");
	        Card d3 = new Card(15, "hearts");
	        Card d4 = new Card(15, "diamonds");

            System.out.println(d1);
            System.out.println(d2);
            System.out.println(d3);
            System.out.println(d4);
            System.out.printf("Hash codes = %d, %d\n", d1.hashCode(), d3.hashCode());
            System.out.println(d1.equals(d1));
            System.out.println(d1.equals(d3));
            System.out.println(d1.isStronger(d2));
            System.out.println(d1.compare(d3));
            System.out.println(Card.compare(d4, d1));

            Card c1 = new Card(4, "clubs");
	        Card c2 = new Card("clubs");
	        Card c3 = new Card(15, "clubs");
	        Card c4 = new Card("clubs");

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3.isInDeck());
            System.out.println(c4.isInDeck());
        }
}
