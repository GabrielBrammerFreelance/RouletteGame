import java.util.ArrayList;
import java.util.Random;

public class Wheel {
	ArrayList<Tile> Tiles;
	
	Wheel(){
		this.Tiles = new ArrayList<Tile>();
	}
	
	public void addTile(TileColor Color, int Number){
		this.Tiles.add(new Tile(Color, Number));
	}
	public void addTileDirect (Tile tile) {
		this.Tiles.add(tile);
	}
	public void removeTile(int index) {
		this.Tiles.remove(index);
	}
	
	public Tile Spin() {
		Random rand = new Random();
		return this.Tiles.get(rand.nextInt(this.Tiles.size()));
	}
	
	public int SpinIndex() {
		Random rand = new Random();
		return rand.nextInt(this.Tiles.size());
	}
	
	public void PrintIndexedTiles() {
		int size = this.Tiles.size();
		Tile curr;
		String num;
		for (int i = 0; i < size; i++) {
			curr = this.Tiles.get(i);
			num = "00" + Integer.toString(i+1);
			num = num.substring(num.length()-3,num.length());
			System.out.println(num + " -- " + curr.getColor() + " " + curr.getNumber() + ".");
		}
	}
	
	public Tile GetIndex(int i) {
		return Tiles.get(i);
	}
	
}
