// Enum for ship types
enum ShipType {
    DESTROYER, // 1 hit point ship
}

class Ship {
    private ShipType type;
    private int health;

    public Ship(ShipType type) {
        this.type = type;
        this.health = type == ShipType.DESTROYER ? 1 : 0; // Adjust health based on ship type
    }

    public ShipType getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public void hit() {
        health--;
    }

    /**
     * If ship health reaches 0, ship is sunk
     * @return
     */
    public boolean isSunk() {
        return health <= 0;
    }
}