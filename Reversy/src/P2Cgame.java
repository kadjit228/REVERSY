import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class P2Cgame {
    private Field f;
    P2Cgame() {
        f = new Field();
    }

    public void PlayGame() {
        System.out.println("START. White goes first");
        boolean whiteGo = true;
        Scanner in = new Scanner(System.in);
        f.printField();
        while (true) {
            if (whiteGo && f.isEndForWhite()) {
                System.out.println("END. Black is win!!");
                break;
            }
            if (!whiteGo && f.isEndForBlack()) {
                System.out.println("END. White is win!!");
                break;
            }
            if (whiteGo) {
                System.out.println("White, it is your step..You can go to this coordinates\n");
                ArrayList<Pair> m = f.whereWhiteCanGo();
                for (int i = 0; i < m.size(); i++) {
                    System.out.printf("x=%d; y=%d \n", m.get(i).first(), m.get(i).second());
                }
                //f.printStepsForWhite();
                int x, y;
                System.out.print("Input a x: ");
                try {
                    x = in.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("EXIT...");
                    return;
                }
                System.out.print("Input a y: ");
                try {
                    y = in.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("EXIT...");
                    return;
                }
                while (!f.CheckIsStepLegalWhite(x,y)) {
                    System.out.println("Incorrect input, try again");
                    System.out.print("Input a x: ");
                    try {
                        x = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("EXIT...");
                        return;
                    }
                    System.out.print("Input a y: ");
                    try {
                        y = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("EXIT...");
                        return;
                    }
                }
                f.StepWhitePlayer(x, y);
            } else {
                Pair s = f.chooseBlackStep();
                f.StepBlackPlayer(s.first(), s.second());
                System.out.println("Black comes to");
                System.out.printf("x=%d; y=%d \n", s.first(), s.second());
            }
            f.printField();
            if (whiteGo) {
                whiteGo = false;
            } else {
                whiteGo = true;
            }
            System.out.println();
        }
    }
}
