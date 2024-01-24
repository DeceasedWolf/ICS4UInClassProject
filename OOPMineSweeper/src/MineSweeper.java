import java.util.Scanner;

public class MineSweeper {
	Grid playingGrid;
	long startTime;

	public MineSweeper(String difficulty) {
		startTime = System.currentTimeMillis();
		int width = 0, height = 0, numMines = 0;
		switch (difficulty) {
			case "Easy":
			case "easy":
			case "Ea":
			case "ea":
				width = 10;
				height = 8;
				numMines = 10;
				break;
			case "Hard":
			case "hard":
			case "H":
			case "h":
				width = 24;
				height = 20;
				numMines = 99;
				break;
			case "Medium":
			case "medium":
			case "Med":
			case "med":
			case "M":
			case "m":
			default:
				width = 18;
				height = 14;
				numMines = 40;
				break;
		}
		playingGrid = new Grid(width, height, numMines);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter a game difficulty (Easy, m, hard): ");
		MineSweeper game = new MineSweeper(scan.nextLine());

		String userInput = "";

		// generate mines on the field
		while (game.playingGrid.numMines > 0) {
			int x = (int) (Math.random() * game.playingGrid.cellGridArray.length);
			int y = (int) (Math.random() * game.playingGrid.cellGridArray[0].length);
			if (!game.playingGrid.cellGridArray[x][y].isMine) {
				game.playingGrid.cellGridArray[x][y].isMine = true;
				game.playingGrid.numMines--;
				System.out.println("BOMB GENERATED AT " + x + ", " + y + "!");
			}
		}

		do {
			System.out.print("\033[2J"); // Clears the console
			System.out.println((System.currentTimeMillis() - game.startTime) / 1000.0);
			System.out.println(game.playingGrid);
			System.out.println("Please enter a coordinate: ");
			userInput = scan.nextLine();
			String[] splitInput = userInput.split(",");
			int x = Integer.parseInt(splitInput[0].trim());
			int y = Integer.parseInt(splitInput[1].trim());

			if (game.playingGrid.cellGridArray[x][y].isMine) {
				System.out.println("You hit a mine!");
				break;
			}

			Coordinate coord = new Coordinate(x, y);
			System.out.println(coord);

		} while (!userInput.equals("halt"));

		
	}
}
