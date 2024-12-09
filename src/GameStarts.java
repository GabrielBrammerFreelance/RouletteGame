
public class GameStarts {
	
	//Returns a wheel with all of the tiles matching a standard American Roulette wheel.
	public static Wheel StandardAmerican() {
		Wheel w = new Wheel();
		w.addTile(TileColor.GREEN, 0);
		w.addTile(TileColor.BLACK, 28);
		w.addTile(TileColor.RED, 9);
		w.addTile(TileColor.BLACK, 26);
		w.addTile(TileColor.RED, 30);
		w.addTile(TileColor.BLACK, 11);
		w.addTile(TileColor.RED, 7);
		w.addTile(TileColor.BLACK, 20);
		w.addTile(TileColor.RED, 32);
		w.addTile(TileColor.BLACK, 17);
		w.addTile(TileColor.RED, 5);
		w.addTile(TileColor.BLACK, 22);
		w.addTile(TileColor.RED, 34);
		w.addTile(TileColor.BLACK, 15);
		w.addTile(TileColor.RED, 3);
		w.addTile(TileColor.BLACK, 24);
		w.addTile(TileColor.RED, 36);
		w.addTile(TileColor.BLACK, 13);
		w.addTile(TileColor.RED, 1);
		w.addTile(TileColor.GREEN, 0);
		w.addTile(TileColor.RED, 27);
		w.addTile(TileColor.BLACK, 10);
		w.addTile(TileColor.RED, 25);
		w.addTile(TileColor.BLACK, 29);
		w.addTile(TileColor.RED, 12);
		w.addTile(TileColor.BLACK, 8);
		w.addTile(TileColor.RED, 19);
		w.addTile(TileColor.BLACK, 31);
		w.addTile(TileColor.RED, 18);
		w.addTile(TileColor.BLACK, 6);
		w.addTile(TileColor.RED, 21);
		w.addTile(TileColor.BLACK, 33);
		w.addTile(TileColor.RED, 16);
		w.addTile(TileColor.BLACK, 4);
		w.addTile(TileColor.RED, 23);
		w.addTile(TileColor.BLACK, 35);
		w.addTile(TileColor.RED, 14);
		w.addTile(TileColor.BLACK, 2);
		return w;
	}

}
