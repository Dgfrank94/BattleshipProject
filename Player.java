class Player {
    public String name;
    public Board[] boards; // Index 0 for ships, index 1 for shots
    public Ship[] ships;

    public Player(String name) {
        this.name = name;
        this.boards = new Board[2];
        this.boards[0] = new Board(); // Ships
        this.boards[1] = new Board(); // Shots
        this.ships = new Ship[3]; // 3 ships per player
        initializeShips();
    }

    /**
     * Put all ships on board
     */
    private void initializeShips() {
        for (int i = 0; i < 3; i++) {
            ships[i] = new Ship(ShipType.DESTROYER);
        }
    }

    /**
     * Displays player board
     */
    public void displayBoards() {
        System.out.println(name + "'s Boards:");
        System.out.println("Ships Board:");
        boards[0].display();
        System.out.println("Shots Board:");
        boards[1].display();
    }

    /**
     * Check to see if ships are sunk
     * @return true if ships are sunk and false if not
     */
    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
}
