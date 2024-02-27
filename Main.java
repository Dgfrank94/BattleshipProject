/**
 * Dalayno Franklin, Sami Alzoubi, Rachel Slabenak
 * CPSC-24500-LT1: Object-Oriented Programming
 * Dr. Rinderer
 * 02/26/2024
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Tutorial block
        Scanner scan = new Scanner(System.in);
        System.out.println("************************");
        System.out.println("Battleship");
        System.out.println("************************\n");
        System.out.print("Have you played Battleship before? (yes/no): ");
        String rules = scan.nextLine();

        if (rules.equalsIgnoreCase("no")) {
            System.out.println("Rules: ");
            System.out.println("The computer will randomly place their ships on this board.");
            System.out.println("You will attempt to guess where the computer has placed their ships");
            System.out.println("The goal is to sink all of the opponent's ships");
        } else {
            System.out.println("OK, LET US BEGIN!!!");
        }

        // Initialize game
        BattleshipGame game = new BattleshipGame();
        game.play();
    }
}