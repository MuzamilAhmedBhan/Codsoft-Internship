import java.util.*;
public class q1 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            int minRange = 1;
            int maxRange = 100;
            int maxAttempts = 10;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange);

            List<Integer> scores = new ArrayList<>();
            int totalRounds = 0;

            while (totalRounds < 5) {
                int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                int attempts = 0;

                System.out.println("Round " + (totalRounds + 1) + ": Can you guess the number?");

                while (attempts < maxAttempts) {
                    System.out.print("Your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == secretNumber) {
                        System.out.println("Congratulations! You guessed it in " + attempts + " attempts.");
                        scores.add(attempts);
                        break;
                    } else if (userGuess < secretNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The number was " + secretNumber);
                }

                totalRounds++;

                if (totalRounds < 5) {
                    System.out.print("Do you want to play another round? (yes/no): ");
                    String playAgain = scanner.next().toLowerCase();
                    if (!playAgain.equals("yes")) {
                        break;
                    }
                }
            }

            displayScores(scores);
            scanner.close();
        }

        private static void displayScores(List<Integer> scores) {
            System.out.println("Game over. Your scores for each round: ");
            for (int i = 0; i < scores.size(); i++) {
                System.out.println("Round " + (i + 1) + ": " + scores.get(i) + " attempts");
            }
        }
    }