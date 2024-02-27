import java.util.Scanner;

public class BattleshipGame {
    public Player[] players;
    public int currentPlayerIndex;
    public Scanner scanner;

    public BattleshipGame() {
        players = new Player[2];
        players[0] = new Player("Player 1");
        players[1] = new Player("Player 2");
        currentPlayerIndex = 0;
        scanner = new Scanner(System.in);
    }

    public void play() {
        while (!players[currentPlayerIndex].allShipsSunk()) {
            Player currentPlayer = players[currentPlayerIndex];
            Player opponent = players[(currentPlayerIndex + 1) % 2];

            System.out.println(currentPlayer.name + "'s turn");
            currentPlayer.displayBoards();

            System.out.println("Enter row and column to fire (e.g., 3 5):");
            int row = readInt("Row:") + 1;
            int col = readInt("Column:") + 1;

            if (opponent.boards[0].isValidPosition(row, col)) {
                if (opponent.boards[0].isOccupied(row, col)) {
                    System.out.println("Hit!");
                    opponent.boards[0].markHit(row, col);
                    opponent.boards[1].markHit(row, col);
                    // add code to see if ship was sunk
                } else {
                    System.out.println("Miss!");
                    opponent.boards[1].markMiss(row, col);
                }
            } else {
                System.out.println("Invalid position. Try again.");
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % 2; // Switch turn
        }

        System.out.println(players[currentPlayerIndex].name + " wins!");
    }

    /**
     * Validation for user input
     * @param message
     * @return number if valid input or error message if not a number
     */
    private int readInt(String message) {
        while (true) {
            System.out.print(message + " ");
            try {
                return Integer.parseInt(scanner.nextLine()) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}