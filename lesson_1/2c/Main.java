public class Main
{
	public static void main(String[] args) {
	        Card d1 = new Card(4, "diamonds");
	        Card d2= new Card("diamonds");
	        Card d3 = new Card(2, "diamonds");
	        Card d4 = new Card("diamonds");

            System.out.println(d1.getRank() + " " + d2.getRank() + " " 
            + d3.getRank() + " " + d4.getRank());
            
            Card c1 = new Card(4, "clubs");
	        Card c2 = new Card("clubs");
	        Card c3 = new Card(2, "clubs");
	        Card c4 = new Card("clubs");

            System.out.println(c1.getRank() + " " + c2.getRank() + " " 
            + c3.getRank() + " " + c4.getRank());
        
        }
}
