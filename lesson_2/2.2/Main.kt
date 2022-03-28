enum class Suit(mr:Int){
    CLUBS(1), DIAMONDS(1), SPADES(1), HEARTS(1);
    var maxRank: Int = mr
  		set(mr: Int){field = mr}
        get() = field
}

public class Card {
    private var rank: Int = -1
    	set(r: Int){field = r}
        get() = field
    private var suit: String = ""
    	set(s: String){field = s}
        get() = field
    constructor(r: Int, s: String){
    	
            when (s){
            "clubs"->{
                this.rank = r
                this.suit = s
                if (r > Suit.CLUBS.maxRank) Suit.CLUBS.maxRank = r 
            }
            "diamonds" -> {
                this.rank = r
                this.suit = s
                Suit.DIAMONDS.maxRank = if (r > Suit.DIAMONDS.maxRank) r else Suit.DIAMONDS.maxRank
            }
            "spades" -> {
                this.rank = r
                this.suit = s
                Suit.SPADES.maxRank = if (r > Suit.SPADES.maxRank) r else Suit.SPADES.maxRank
            }
            "hearts"->{
                this.rank = r
                this.suit = s
                Suit.HEARTS.maxRank = if (r > Suit.HEARTS.maxRank) r else Suit.HEARTS.maxRank
            }
            else->print("Передано неверное значение масти")
            
        }
    }
    constructor( s: String){
    when (s){
            "clubs"->{
                this.rank = Suit.CLUBS.maxRank + 1;
                this.suit = s;
                Suit.CLUBS.maxRank = this.rank;
            }
            "diamonds" -> {
                this.rank = Suit.DIAMONDS.maxRank + 1;
                this.suit = s;
                Suit.DIAMONDS.maxRank = this.rank;
            }
            "spades" -> {
                this.rank = Suit.SPADES.maxRank + 1;
                this.suit = s;
                Suit.SPADES.maxRank = this.rank;
            }
            "hearts"->{
                this.rank = Suit.HEARTS.maxRank + 1;
                this.suit = s;
                Suit.HEARTS.maxRank = this.rank;
            }
            else->print("Передано неверное значение масти")
            }
    }
    val allowedSuit = arrayOf("clubs","diamonds", "spades", "hearts")
    val stringRank = arrayOf("two", "three", "four", "five", "six", "seven", 
                             "eight", "nine", "ten", "jack", "queen", "king", "ace", "joker")
    fun isInDeck(): Boolean{
        val idx: Int = allowedSuit.indexOf(suit)
        if ((idx == 0 || idx == 1) && rank <= 15 && rank >= 2) return true
        if ((idx == 2 || idx == 3) && rank <= 14 && rank >= 2) return true
        return false
    }
    fun isStronger(card: Card): Boolean{
        val idx1 : Int = allowedSuit.indexOf(suit)
        val idx2 : Int = allowedSuit.indexOf(card.suit)
        if (idx1 != idx2) return false
        if (rank > card.rank) return true
        return false
    }
    fun compare(card: Card): Int{
        val idx1 : Int = allowedSuit.indexOf(suit)
        val idx2 : Int = allowedSuit.indexOf(card.suit)
        if (idx1 < idx2) return 1
        else if (idx1 == idx2){
            if (rank == card.rank) return 0
            else if (rank > card.rank) return 1
            else return -1
        }
        else return -1
    }
    companion object {
        fun compare(card: Card, other: Card): Int{
            return card.compare(other)
        }
    }
    override fun hashCode(): Int {
        val idx : Int = allowedSuit.indexOf(suit)
        return rank + 15 * idx;
    }
     
    override fun equals(other: Any?):Boolean {
        if (other !is Card) return false
        return this.suit == other.suit && this.rank == other.rank
    }
    override fun toString() : String
	{
        val idx : Int= allowedSuit.indexOf(suit)
        if (isInDeck()){
            if (rank == 15 && idx == 0)return "black " + stringRank[rank-2]
            if (rank == 15 && idx == 1)return "red " + stringRank[rank-2]
            return stringRank[rank-2] + " of " + suit
        }
        return  "$rank of $suit"
    }
    
}

fun main() {
    var d1 = Card(4, "diamonds")
	var d2= Card("diamonds")
	var d3 = Card(15, "hearts")
	var d4 = Card(15, "diamonds")
	println(d1)
    println(d2)
    println(d3)
    println(d4)
    val hc1 : Int = d1.hashCode()
    val hc2 : Int = d3.hashCode()
    println("Hash codes = $hc1, $hc2")
    println(d1.equals(d1))
    println(d1.equals(d3))
    println(d1.isStronger(d2))
    println(d1.compare(d3))
    println(Card.compare(d4, d1))
    println(d3.isInDeck())
    println(d4.isInDeck())

}