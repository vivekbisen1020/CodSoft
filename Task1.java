import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRoundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {

            int secretNumber = random.nextInt(100) + 1;
            int maximumAttempts = 5;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maximumAttempts + " attempts to guess it.");

            while (attemptsUsed < maximumAttempts && !guessedCorrectly) {

                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsUsed++;

                if (userGuess == secretNumber) {
                    guessedCorrectly = true;
                    totalRoundsWon++;
                    System.out.println("Correct! You guessed the number in " + attemptsUsed + " attempts.");
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println(" You've used all attempts. The correct number was: " + secretNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String userChoice = scanner.next();

            playAgain = userChoice.equalsIgnoreCase("yes");
        }

        System.out.println(" Game Over!");
        System.out.println("Total rounds won: " + totalRoundsWon);

        scanner.close();
    }
}
