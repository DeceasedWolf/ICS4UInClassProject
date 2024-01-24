import java.util.Arrays;

public class Grid {
	Cell[][] cellGridArray;
	public int numMines;

	public Grid(int width, int height, int numMines) {
		this.numMines = numMines;
		cellGridArray = new Cell[width][height];
		for (int i = 0; i < cellGridArray.length; i++) {
			for (int k = 0; k < cellGridArray[i].length; k++) {
				cellGridArray[i][k] = new Cell();
			}
		}
	}
	
	public String toString() {
		String builder = "";
		for (Cell[] CG: cellGridArray) {
			builder += Arrays.toString(CG) + "\n";
		}
		return builder;
	}
}
