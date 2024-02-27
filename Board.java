class Board {
    private static final int SIZE = 10;
    private char[][] grid;

    public Board() {
        grid = new char[SIZE + 1][SIZE + 1]; // plus one to make input easier and 1 based instead of 0
        initializeBoard();
    }

    /**
     * Initialize the board with a default size of 10.
     */
    private void initializeBoard() {
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                grid[i][j] = '.';
            }
        }
    }

    /**
     * Displays board on CLI after each turn.
     */
    public void display() {
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Checks is user input is valid
     * @param row out of 10
     * @param col out of 10
     * @return
     */
    public boolean isValidPosition(int row, int col) {
        return row >= 1 && row < SIZE && col >= 1 && col < SIZE;
    }

    /**
     * if ship is on specified tile
     * @param row
     * @param col
     * @return
     */
    public boolean isOccupied(int row, int col) {
        return grid[row][col] != '.';
    }

    /**
     * if ship is hit
     * @param row
     * @param col
     */
    public void markHit(int row, int col) {
        grid[row][col] = 'X';
    }

    /**
     * if no ship is hit
     * @param row
     * @param col
     */
    public void markMiss(int row, int col) {
        grid[row][col] = '-';
    }
}
