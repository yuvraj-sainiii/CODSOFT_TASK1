
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundsWon = 0;
        String playAgain;

        System.out.println("================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("================================");

        do {
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Enter an integer.");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println(
                        "Please enter a number between 1 and 100."
                    );
                    continue;
                }

                attempts++;

                if (guess == number) {
                    guessedCorrectly = true;
                    roundsWon++;

                    int points = (maxAttempts - attempts + 1) * 10;
                    totalScore += points;

                    System.out.println("Correct guess! Congratulations!");
                    System.out.println("Attempts used: " + attempts);
                    System.out.println("Points earned: " + points);
                    break;

                } else if (guess < number) {
                    System.out.println("Too low! Try a higher number.");

                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                System.out.println(
                    "Attempts remaining: " + (maxAttempts - attempts)
                );
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou have used all your attempts.");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("\nRounds won: " + roundsWon);
            System.out.println("Total score: " + totalScore);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n================================");
        System.out.println("          FINAL RESULTS");
        System.out.println("================================");
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Final score: " + totalScore);
        System.out.println("Thanks for playing!");

        sc.close();
    }
}


