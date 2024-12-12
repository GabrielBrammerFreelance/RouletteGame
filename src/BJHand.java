import java.util.ArrayList;
import java.util.Random;

public class BJHand {
ArrayList<BJCard> Cards;
int Score;
int SoftAces;
	
	BJHand(){
		this.Cards = new ArrayList<BJCard>();
		this.Score = 0;
		this.SoftAces = 0;
	}
	
	public void AddCard(BJCard Card) {
		this.Cards.add(Card);
		
		switch (Card) {
		case ACE:
			this.Score = this.Score + 11;
			this.SoftAces++;
			break;
		case EIGHT:
			this.Score = this.Score + 8;
			break;
		case FIVE:
			this.Score = this.Score + 5;
			break;
		case FOUR:
			this.Score = this.Score + 4;
			break;
		case JACK:
			this.Score = this.Score + 10;
			break;
		case KING:
			this.Score = this.Score + 10;
			break;
		case NINE:
			this.Score = this.Score + 9;
			break;
		case QUEEN:
			this.Score = this.Score + 10;
			break;
		case SEVEN:
			this.Score = this.Score + 7;
			break;
		case SIX:
			this.Score = this.Score + 6;
			break;
		case TEN:
			this.Score = this.Score + 10;
			break;
		case THREE:
			this.Score = this.Score + 3;
			break;
		case TWO:
			this.Score = this.Score + 2;
			break;
		
		}
		
	}
	
	
	private void CalcAces() {
		while ((this.SoftAces > 0) && (this.Score > 21)) {
			this.SoftAces = this.SoftAces -1;
			this.Score = this.Score - 10;
		}
	}
	
	public String toString() {
		String out = "";
		int i = 0;
		out = out + this.Cards.get(i);
		i++;
		while (i < this.Cards.size()) {
			out = out + " " + this.Cards.get(i);
			i++;
		}
		return out;
	}
	
	public int GetScore() {
		CalcAces();
		return this.Score;
	}
	
	public String ScoreString() {
		CalcAces();
		String out;
		if (this.SoftAces > 0) {
			out = "SOFT " + this.Score;
		}
		else {
			out = "HARD " + this.Score;
		}
		return out;
			
	}
	
	public boolean Bust() {
		CalcAces();
		if (this.Score > 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

}
