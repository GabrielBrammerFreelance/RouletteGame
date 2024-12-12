import java.util.ArrayList;
import java.util.Random;

public class BJDeck {
	ArrayList<BJCard> Cards;
	
	BJDeck(){
		this.Cards = new ArrayList<BJCard>();  //TODO: this could be initialized at 13, when completing change it.  (dont want to fuck up
	}												//the this.Cards.size() call below before it works initially for optimization.
	
	public BJCard DrawCard() {
		Random rand = new Random();
		return this.Cards.get(rand.nextInt(this.Cards.size()));
	}
	
	public void AddCard(BJCard Card) {
		this.Cards.add(Card);
	}
	
	
}
