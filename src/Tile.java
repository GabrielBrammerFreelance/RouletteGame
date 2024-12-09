
public class Tile {
	
	TileColor Color;
	int Number;
	
	Tile(TileColor C, int N){
		this.Color = C;
		this.Number = N;
	}
	
	
	public TileColor getColor(){
		return this.Color;
		}
	public int getNumber() {
		return this.Number;
	}
	
	public void PrintTile(){
		System.out.println(this.Color + " " + this.Number);
	}
	
	public String toString() {
		return this.Color + " " + this.Number;
	}
	
}
