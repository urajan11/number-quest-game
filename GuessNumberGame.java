import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char playAgain = 'y';
        while (playAgain == 'y' || playAgain == 'Y') {

            Random rand = new Random();
            int randNum = rand.nextInt(90000) + 10000;
            System.out.println("Random No:" + randNum);
            int a[] = new int[5];
            int b[] = new int[5];
            int n = randNum;
            for (int i = 4; i >= 0; i--) {
                a[i] = n % 10;
                n = n / 10;
            }
            System.out.println("║      5-DIGIT NUMBER GUESSING     ║");
            int num;
            System.out.println(" \nTry to guess the number under 5 attemps:");

            int count = 0;
            int maxAttempts = 5;
            int temp = 0;

            System.out.println("You have " + maxAttempts + " attempts to guess it.\n");
            while (count < maxAttempts) {

                int remaining = maxAttempts - count;
                System.out.println("----------------------------------");
                System.out.println("Attempt " + (count + 1) + " of " + maxAttempts + " | Remaining: " + remaining);
                System.out.println("\nentere 5 digit number:");
                num = sc.nextInt();
                int n2 = num;
                if (n2 >= 10000 && n2 <= 99999) {

                    for (int i = 4; i >= 0; i--) {
                        b[i] = n2 % 10;
                        n2 = n2 / 10;
                    }
                    for (int i = 0; i < a.length; i++) {
                        for (int j = 0; j < b.length; j++) {

                            if (b[j] == a[i]) {

                                if (j == i) {
                                    System.out.println(
                                            "  Digit " + b[j] + " at position " + (j + 1) + " --> CORRECT POSITION ✓");
                                }
                                if (j != i) {
                                    System.out.println("  Digit " + b[j] + " at position " + (j + 1)
                                            + " --> WRONG POSITION (exists in number)");
                                }

                            }

                        }

                    }

                    if (num == randNum) {
                        temp = 1;
                        break;
                    }

                    count++;
                    System.out.println("Attempts used: " + count + " | Attempts left: " + (maxAttempts - count));
                } else {
                    System.out.println("⚠ WARNING ");
                    System.out.println("⚠ WARNING: " + num + " is NOT a 5-digit number!");
                    System.out.println(num + " is NOT a 5-digit number. Please enter between 10000 and 99999.");
                    continue;
                }

            }
            System.out.println("\n==================================");
            if (temp == 1) {
                System.out.println("congratutaions! \nYOU WON 💕");
            } else {
                System.out.println("Better luck next time! 😭");

                System.out.println("The correct number was: " + randNum);
            }

            System.out.println("==================================\n");

            System.out.print("Play again? (y/n): ");
            playAgain = sc.next().charAt(0);
        }
        System.out.println("\nThanks for playing. Goodbye!");
        sc.close();
    }

}
