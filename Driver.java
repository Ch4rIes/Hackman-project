import java.util.*;

public class Driver {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangingMan hangingMan = new HangingMan();
        Puzzle puzzle = new Puzzle();
        while (puzzle.isUnsolved() && hangingMan.isntDead()) {
            // keep looping before a player guessed all right or loses all its lives
            hangingMan.show();
            puzzle.show();
            // show the puzzle and health state
            System.out.print("\nMake a guess: ");
            String guess = scanner.nextLine();
            // user type in his/her guess
            if (!puzzle.makeGuess(guess)) {
                hangingMan.dieSomeMore();
            }
            clearScreen();
        }

        if (hangingMan.isntDead()) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose! The word was " + puzzle.getWord());
        }
    }

    public static void clearScreen() {
        System.out.println("\f");
    }
}

