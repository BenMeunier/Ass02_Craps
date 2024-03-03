import java.util.Random;
import java.util.Scanner;

 class Ass02_Craps {
    private static final Random randomNumbers = new Random();

    // add 2 dice rolls to = sum
    private static int rollDice() {
        int roll1 = 1 + randomNumbers.nextInt(6); // 1st roll
        int roll2 = 1 + randomNumbers.nextInt(6); // 2nd roll
        int sum = roll1 + roll2; // sum of 2 roles
        System.out.printf("Player rolled %d + %d = %d%n", roll1, roll2, sum);
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String playAgain = "y";

        while (playAgain.equalsIgnoreCase("y")) {
            int myPoint = 0; // points if no win of 1st roll
            boolean continuePlaying = true; // decide if game is over or goes on
            int sumOfDice = rollDice(); // first roll

            // decide if they win on first roll
            switch (sumOfDice) {
                case 7, 11: // 7 or 11 = Natural win
                    System.out.println("Natural win");
                    continuePlaying = false;
                    break;
                case 2, 3, 12: // If roles 2 3 or 12 = loss
                    System.out.println("Lost");
                    continuePlaying = false;
                    break;
                default: // Keep points because they didn't win
                    myPoint = sumOfDice;
                    System.out.printf("Point is set to %d%n", myPoint);
                    break;
            }

            // game is not complete
            while (continuePlaying) {
                sumOfDice = rollDice(); // roll again

                if (sumOfDice == myPoint) { // made point
                    System.out.println("Made point win");
                    continuePlaying = false;
                } else if (sumOfDice == 7) { // lose rolling 7
                    System.out.println("7 loss.");
                    continuePlaying = false;
                }
            }

            // Ask if they want to play again
            System.out.print("Play again? (y/n): ");
            playAgain = input.nextLine();
        }
    }
}
