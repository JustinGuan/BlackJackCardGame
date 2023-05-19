public class BlackJackAI {
    public char makeDecision(int playerTotal, int dealerCard, int dealerTotal) {
        if (playerTotal < 17) {
            return 'y'; // Always hit if player total is less than 17
        } else if (playerTotal >= 17 && playerTotal <= 21) {
            if (dealerCard >= 7 && dealerCard <= 10) {
                return 'n'; // Stand if player total is between 17 and 21 and dealer card is favorable
            } else {
                return 'y'; // Hit if player total is between 17 and 21 and dealer card is not favorable
            }
        } else if (playerTotal > 21) {
            return 'n'; // Stand if player total is over 21 (bust)
        } else {
            if (dealerTotal > 21) {
                return 'w'; // Win if dealer busts
            } else {
                return 'n'; // Stand if dealer total is less than or equal to 21
            }
        }
    }
}
