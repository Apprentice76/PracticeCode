import java.util.Random;
import java.util.Scanner;

public class Stanford {
    String[] list = {"burst", "lexicon", "fizzbuzz", "eratosthenes"};
    void hangman() {
        Random rn = new Random();
        int ch = rn.nextInt(list.length);
        String secret = list[ch].toUpperCase();
        int len = secret.length();
        int lives = 8;
        System.out.println("Welcome to Hangman!");        
        System.out.print("The word now looks like this: ");
        String word = "";
        for (int i=0; i<len; i++) word+="-";
        System.out.println(word);
        Scanner sc = new Scanner(System.in);
        while (lives > 0) {
            System.out.print("Your guess: ");
            char guess = sc.next().toUpperCase().charAt(0);
            String tmp = word;
            // word = "";
            for (int i=0; i<len; i++) {
                if (guess == secret.charAt(i)) {
                    word = word.substring(0, i) + guess + word.substring(i+1, len);
                }
                
            }
            if (word == secret) {
                System.out.println("You guessed the word: " + secret + "\nYou win.");
                break;
            }
            else if (word == tmp) {
                lives--;
                System.out.println("There are no " + guess + "\'s in the word.");
            }
            else System.out.println("That guess is correct.");
            System.out.println("The word now looks like this: " + word);
            if (lives > 1) System.out.println("You have " + lives + " guesses left.");
            else if (lives == 1) System.out.println("You have only 1 guess left.");
            else System.out.println("You're completely hung.\nYou lose.");
        }
        sc.close();
    }

    public static void main(String[] args) {
        Stanford o = new Stanford();
        o.hangman();
    }
}
