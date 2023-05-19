import java.util.Scanner;
import java.util.Random;

public class BlackJackCardGame {
    public static void main(String[] args) {
        int dealerCard1, dealerCard2, dealersTotal, playerCard1, playerCard2, playersTotal;
        char repeat = 'n';
        String input;
        Scanner keyboard = new Scanner(System.in);
        BlackJackAI ai = new BlackJackAI();

        do {
            dealerCard1 = 0;
            dealerCard2 = 0;
            Random random = new Random();

            System.out.println("Let's play a game of BlackJack.");
            dealerCard1 = random.nextInt(9) + 1;
            System.out.println("The Dealer starts with a " + dealerCard1);
            dealersTotal = dealerCard1 + dealerCard2;

            // Player's turn
            playerCard1 = random.nextInt(9) + 1;
            playerCard2 = random.nextInt(9) + 1;
            System.out.print("Your first cards: ");
            System.out.println(playerCard1 + " , " + playerCard2);
            playersTotal = playerCard1 + playerCard2;
            System.out.println("Total: " + playersTotal);

            char hit = 'n';
            do {
                System.out.println("Hit? ");
                System.out.println("Enter \"y\" for Yes or \"n\" for No");
                input = keyboard.nextLine();
                hit = input.charAt(0);

                if (hit == 'y' || hit == 'Y') {
                    int playerCard3 = random.nextInt(9) + 1;
                    System.out.println("Card: " + playerCard3);
                    playersTotal += playerCard3;
                    System.out.println("Total " + playersTotal + "\n");
                }

                if (hit == 'n' || hit == 'N') {
                    break;
                }
            } while (playersTotal < 22);

            if (playersTotal > 21) {
                System.out.println("Bust.\n");
            } else {
                // Dealer's turn
                char go;
                dealersTotal = dealerCard1;
                System.out.println("Dealer has " + dealersTotal);
                System.out.println("(c to continue)");
                input = keyboard.nextLine();
                go = input.charAt(0);

                if (go == 'c' || go == 'C') {
                    do {
                        int dealerCard3 = random.nextInt(9) + 1;
                        System.out.println("Card: " + dealerCard3);
                        dealersTotal += dealerCard3;
                        System.out.println("Total " + dealersTotal + "\n");

                        if (dealersTotal <= 21) {
                            if (dealersTotal > playersTotal) {
                                System.out.println("Dealer wins.");
                                break;
                            } else if (dealersTotal == playersTotal) {
                                System.out.println("Push!");
                                break;
                            }
                        } else {
                            System.out.println("Dealer busts. Player wins.");
                            break;
                        }

                        System.out.println("(c to continue)");
                        input = keyboard.nextLine();
                        go = input.charAt(0);
                    } while (dealersTotal < 17 || go == 'c' || go == 'C');
                }
            }

            System.out.println("Would you like to play again? ");
            System.out.println("Enter \"y\" for Yes or \"n\" for No");
            input = keyboard.nextLine();
            repeat = input.charAt(0);

        } while (repeat == 'y' || repeat == 'Y');

        keyboard.close();
    }
}
