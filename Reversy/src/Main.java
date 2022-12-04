import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("If you want play P VS P, input 1. P VS C, input 2");
        System.out.println("IMPORTANT: IF YOU GET NOT INTEGER VALUE - PROGRAMM WILL EXIT");
        int input;
        try {
            input = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("EXIT...");
            return;
        }
        while (true) {
            if (input == 1 || input == 2) {
                break;
            }
            System.out.println("Incorrect input. Try again.");
            try {
                input = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("EXIT...");
                return;
            }
        }
        if (input == 1) {
            P2Pgame g = new P2Pgame();
            g.PlayGame();
        } else {
            P2Cgame c = new P2Cgame();
            c.PlayGame();
        }
        System.out.println("Exit...");
    }
}