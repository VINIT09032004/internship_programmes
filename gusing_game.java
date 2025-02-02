package internship_programmes;

import java.util.Scanner;
import java.util.Random;

class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1; // Lower bound of the range
        int upperBound = 100; // Upper bound of the range
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound; // Random number to guess
        int numberOfTries = 0; // Counter for the number of attempts
        int guess = 0; // Variable to store the player's guess

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Can you guess it?");

        while (guess != numberToGuess) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numberOfTries++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + numberOfTries + " tries.");
            }
        }

        scanner.close();
    }
}
