
public class Bond {
	int value;
	int MaturityTurn;
	
	Bond(int Value, int CurrentTurn){
		this.value = Value;
		this.MaturityTurn = CurrentTurn + 5;
	}
	
	public int Mature(){
		return ((this.value * 110) / 100);
	}
	public int GetMaturity() {
		return this.MaturityTurn;
	}
	public String toString(int CurrTurn) {
		int x = this.MaturityTurn - CurrTurn;
		return("Value: $" + this.value + ".  Matures in " + x + " turns.");
	}
}
