import java.util.ArrayList;

public class Field {
    private int[][] field;
    final int black = 1;
    final int white = 2;
    Field() {
        field = new int[8][8];
        field[3][3] = white;
        field[4][4] = white;
        field[3][4] = black;
        field[4][3] = black;
    }
    public boolean CheckIsStepLegalWhite(int x, int y) {
        ArrayList<Pair> m = whereWhiteCanGo();
        Pair a = new Pair(x,y);
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).isEqual(a)) {
                return true;
            }
        }
        return false;
    }
    public boolean CheckIsStepLegalBlack(int x, int y) {
        ArrayList<Pair> m = whereBlackCanGo();
        Pair a = new Pair(x,y);
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).isEqual(a)) {
                return true;
            }
        }
        return false;
    }
    public void StepWhitePlayer(int x, int y) {
        field[x][y] = white;
        ChangeColour(x, y);
    }
    public void StepBlackPlayer(int x, int y) {
        field[x][y] = black;
        ChangeColour(x, y);
    }
    public int countWhitePoints() {
        int w = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (field[i][j] == white) {
                    w += 1;
                }
            }
        }
        return w;
    }
    public int countBlackPoints() {
        int w = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (field[i][j] == black) {
                    w += 1;
                }
            }
        }
        return w;
    }
    private boolean isFieldFull() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (field[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean ChangeColourRightB(int x, int y) {
        int cury = y + 1;
        int secy = y + 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = black;
            reverseColour = white;
        } else {
            colour = white;
            reverseColour = black;
        }
        while(cury != 8) {
            if (field[x][cury] == 0) {
                return false;
            }
            if(field[x][cury] == colour) {
                secy = cury;
                return true;
            }
            cury++;
        }
        return false;
    }
    private boolean ChangeColourLeftB(int x, int y) {
        int cury = y - 1;
        int secy = y - 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = black;
            reverseColour = white;
        } else {
            colour = white;
            reverseColour = black;
        }
        while(cury != -1) {
            if (field[x][cury] == 0) {
                return false;
            }
            if(field[x][cury] == colour) {
                secy = cury;
                return true;
            }
            cury--;
        }
        return false;
    }

    private boolean ChangeColourDownB(int x, int y) {
        int curx = x + 1;
        int secx = x + 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = black;
            reverseColour = white;
        } else {
            colour = white;
            reverseColour = black;
        }
        while(curx != 8) {
            if (field[curx][y] == 0) {
                return false;
            }
            if(field[curx][y] == colour) {
                secx = curx;
                return true;
            }
            curx++;
        }
        return false;
    }

    private boolean ChangeColourUpB(int x, int y) {
        int curx = x - 1;
        int secx = x - 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = black;
            reverseColour = white;
        } else {
            colour = white;
            reverseColour = black;
        }
        while(curx != -1) {
            if (field[curx][y] == 0) {
                return false;
            }
            if(field[curx][y] == colour) {
                secx = curx;
                return true;
            }
            curx--;
        }
        return false;
    }

    private boolean ChangeColourLeftDiagonalUpB(int x, int y) {
        int cury = y - 1;
        int curx = x - 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = black;
            reverseColour = white;
        } else {
            colour = white;
            reverseColour = black;
        }
        while(cury != -1 && curx != -1) {
            if (field[curx][cury] == 0) {
                return false;
            }
            if(field[curx][cury] == colour) {
                return true;
            }
            curx--;
            cury--;
        }
        return false;
    }
    private boolean ChangeColourRightDiagonalDownB(int x, int y) {
        int cury = y + 1;
        int curx = x + 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = black;
            reverseColour = white;
        } else {
            colour = white;
            reverseColour = black;
        }
        while(cury != 8 && curx != 8) {
            if (field[curx][cury] == 0) {
                return false;
            }
            if(field[curx][cury] == colour) {
                return true;
            }
            curx++;
            cury++;
        }
        return false;
    }
    private boolean ChangeColourLeftDiagonalDownB(int x, int y) {
        int cury = y - 1;
        int curx = x + 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = black;
            reverseColour = white;
        } else {
            colour = white;
            reverseColour = black;
        }
        while(cury != -1 && curx != 8) {
            if (field[curx][cury] == 0) {
                return false;
            }
            if(field[curx][cury] == colour) {
                return true;
            }
            curx++;
            cury--;
        }
        return false;
    }
    private boolean ChangeColourRightDiagonalUpB(int x, int y) {
        int cury = y + 1;
        int curx = x - 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = black;
            reverseColour = white;
        } else {
            colour = white;
            reverseColour = black;
        }
        while(cury != 8 && curx != -1) {
            if (field[curx][cury] == 0) {
                return false;
            }
            if(field[curx][cury] == colour) {
                return true;
            }
            curx--;
            cury++;
        }
        return false;
    }

    private void ChangeColourRight(int x, int y) {
        double r = 0;
        int cury = y + 1;
        int secy = y + 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != 8) {
            if (field[x][cury] == 0) {
                return;
            }
            if(field[x][cury] == colour) {
                secy = cury;
                break;
            }
            cury++;
        }
        if (secy != y + 1) {
            for (int i = y + 1; i != secy; i++) {
                field[x][i] = colour;
            }
        }
    }
    private void ChangeColourLeft(int x, int y) {
        int cury = y - 1;
        int secy = y - 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != -1) {
            if (field[x][cury] == 0) {
                return;
            }
            if(field[x][cury] == colour) {
                secy = cury;
                break;
            }
            cury--;
        }
        if (secy != y - 1) {
            for (int i = y - 1; i != secy; i--) {
                field[x][i] = colour;
            }
        }
    }

    private void ChangeColourDown(int x, int y) {
        int curx = x + 1;
        int secx = x + 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(curx != 8) {
            if (field[curx][y] == 0) {
                return;
            }
            if(field[curx][y] == colour) {
                secx = curx;
                break;
            }
            curx++;
        }
        if (secx != x + 1) {
            for (int i = x + 1; i != secx; i++) {
                field[i][y] = colour;
            }
        }
    }

    private void ChangeColourUp(int x, int y) {
        int curx = x - 1;
        int secx = x - 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(curx != -1) {
            if (field[curx][y] == 0) {
                return;
            }
            if(field[curx][y] == colour) {
                secx = curx;
                break;
            }
            curx--;
        }
        if (secx != x - 1) {
            for (int i = x - 1; i != secx; i--) {
                field[i][y] = colour;
            }
        }
    }

    private void ChangeColourLeftDiagonalUp(int x, int y) {
        int cury = y - 1;
        int curx = x - 1;
        int secy = y - 1;
        int secx = x - 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != -1 && curx != -1) {
            if (field[curx][cury] == 0) {
                return;
            }
            if(field[curx][cury] == colour) {
                secx = curx;
                secy = cury;
                break;
            }
            curx--;
            cury--;
        }
        if (secy != y - 1) {
            for (int i = y - 1, j = x - 1; i != secy; i--, j--) {
                field[i][j] = colour;
            }
        }
    }
    private void ChangeColourRightDiagonalDown(int x, int y) {
        int cury = y + 1;
        int curx = x + 1;
        int secy = y + 1;
        int secx = x + 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != 8 && curx != 8) {
            if (field[curx][cury] == 0) {
                return;
            }
            if(field[curx][cury] == colour) {
                secx = curx;
                secy = cury;
                break;
            }
            curx++;
            cury++;
        }
        if (secy != y + 1) {
            for (int i = y + 1, j = x + 1; i != secy; i++, j++) {
                field[i][j] = colour;
            }
        }
    }
    private void ChangeColourLeftDiagonalDown(int x, int y) {
        int cury = y - 1;
        int curx = x + 1;
        int secy = y - 1;
        int secx = x + 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != -1 && curx != 8) {
            if (field[curx][cury] == 0) {
                return;
            }
            if(field[curx][cury] == colour) {
                secx = curx;
                secy = cury;
                break;
            }
            curx++;
            cury--;
        }
        if (secy != y - 1) {
            for (int i = y - 1, j = x + 1; i != secy; i--, j++) {
                field[i][j] = colour;
            }
        }
    }
    private void ChangeColourRightDiagonalUp(int x, int y) {
        int cury = y + 1;
        int curx = x - 1;
        int secy = y + 1;
        int secx = x - 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != 8 && curx != -1) {
            if (field[curx][cury] == 0) {
                return;
            }
            if(field[curx][cury] == colour) {
                secx = curx;
                secy = cury;
                break;
            }
            curx--;
            cury++;
        }
        if (secy != y - 1) {
            for (int i = y + 1, j = x - 1; i != secy; i++, j--) {
                field[i][j] = colour;
            }
        }
    }

    private void ChangeColour(int x, int y) {
        ChangeColourRight(x,y);
        ChangeColourLeft(x,y);
        ChangeColourDown(x,y);
        ChangeColourUp(x,y);
        ChangeColourLeftDiagonalDown(x, y);
        ChangeColourLeftDiagonalUp(x, y);
        ChangeColourRightDiagonalDown(x, y);
        ChangeColourRightDiagonalUp(x, y);
    }

    public void printField() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (field[i][j] == 0) {
                    System.out.print("  *");
                } else if (field[i][j] == white) {
                    System.out.print("  W");
                } else {
                    System.out.print("  B");
                }
            }
            System.out.print('\n');
        }
    }

    public ArrayList<Pair> whereWhiteCanGo() {
        ArrayList<Pair> mass = new ArrayList<Pair>();
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (field[i][j] == black) {
                    if ( i + 1 < 8 && field[i + 1][j] == 0 && ChangeColourUpB(i, j)) {
                        mass.add(new Pair(i + 1, j));
                    }
                    if (j + 1 < 8 && field[i][j + 1] == 0 && ChangeColourLeftB(i, j)) {
                        mass.add(new Pair(i, j + 1));
                    }
                    if (i - 1 > -1 && field[i - 1][j] == 0 && ChangeColourDownB(i, j)) {
                        mass.add(new Pair(i - 1, j));
                    }
                    if (j - 1 > -1 && field[i][j - 1] == 0 && ChangeColourRightB(i, j)) {
                        mass.add(new Pair(i, j - 1));
                    }
                    if (i + 1 < 8 && j + 1 < 8 && field[i + 1][j + 1] == 0 && ChangeColourLeftDiagonalUpB(i, j)) {
                        mass.add(new Pair(i + 1, j + 1));
                    }
                    if (j + 1 < 8 && i - 1 > -1 && field[i - 1][j + 1] == 0 && ChangeColourLeftDiagonalDownB(i, j)) {
                        mass.add(new Pair(i - 1, j + 1));
                    }
                    if (i + 1 < 8 && j - 1 > -1 && field[i + 1][j - 1] == 0 && ChangeColourRightDiagonalUpB(i, j)) {
                        mass.add(new Pair(i + 1, j - 1));
                    }
                    if (j - 1 > -1 && i - 1 > -1 && field[i - 1][j - 1] == 0 && ChangeColourRightDiagonalDownB(i, j)) {
                        mass.add(new Pair(i - 1, j - 1));
                    }
                }
            }
        }
        return mass;
    }

    public ArrayList<Pair> whereBlackCanGo() {
        ArrayList<Pair> mass = new ArrayList<Pair>();
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (field[i][j] == white) {
                    if ( i + 1 < 8 && field[i + 1][j] == 0 && ChangeColourUpB(i, j)) {
                        mass.add(new Pair(i + 1, j));
                    }
                    if (j + 1 < 8 && field[i][j + 1] == 0 && ChangeColourLeftB(i, j)) {
                        mass.add(new Pair(i, j + 1));
                    }
                    if (i - 1 > -1 && field[i - 1][j] == 0 && ChangeColourDownB(i, j)) {
                        mass.add(new Pair(i - 1, j));
                    }
                    if (j - 1 > -1 && field[i][j - 1] == 0 && ChangeColourRightB(i, j)) {
                        mass.add(new Pair(i, j - 1));
                    }
                    if (i + 1 < 8 && j + 1 < 8 && field[i + 1][j + 1] == 0 && ChangeColourLeftDiagonalUpB(i, j)) {
                        mass.add(new Pair(i + 1, j + 1));
                    }
                    if (j + 1 < 8 && i - 1 > -1 && field[i - 1][j + 1] == 0 && ChangeColourLeftDiagonalDownB(i, j)) {
                        mass.add(new Pair(i - 1, j + 1));
                    }
                    if (i + 1 < 8 && j - 1 > -1 && field[i + 1][j - 1] == 0 && ChangeColourRightDiagonalUpB(i, j)) {
                        mass.add(new Pair(i + 1, j - 1));
                    }
                    if (j - 1 > -1 && i - 1 > -1 && field[i - 1][j - 1] == 0 && ChangeColourRightDiagonalDownB(i, j)) {
                        mass.add(new Pair(i - 1, j - 1));
                    }
                }
            }
        }
        return mass;
    }

    public boolean isEndForWhite() {
        if (isFieldFull() || whereWhiteCanGo().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isEndForBlack() {
        if (isFieldFull() || whereBlackCanGo().isEmpty()) {
            return true;
        }
        return false;
    }

    public void printStepsForWhite() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (field[i][j] == black) {
                    if (i + 1 < 8 && field[i + 1][j] == 0 && ChangeColourUpB(i, j)) {
                        System.out.print("  !");
                    } else if (j + 1 < 8 && field[i][j + 1] == 0 && ChangeColourLeftB(i, j)) {
                        System.out.print("  !");
                    } else if (i - 1 > -1 && field[i - 1][j] == 0 && ChangeColourDownB(i, j)) {
                        System.out.print("  !");
                    } else if (j - 1 > -1 && field[i][j - 1] == 0 && ChangeColourRightB(i, j)) {
                        System.out.print("  !");
                    } else if (i + 1 < 8 && j + 1 < 8 && field[i + 1][j + 1] == 0 && ChangeColourLeftDiagonalUpB(i, j)) {
                        System.out.print("  !");
                    } else if (j + 1 < 8 && i - 1 > -1 && field[i - 1][j + 1] == 0 && ChangeColourLeftDiagonalDownB(i, j)) {
                        System.out.print("  !");
                    } else if (i + 1 < 8 && j - 1 > -1 && field[i + 1][j - 1] == 0 && ChangeColourRightDiagonalUpB(i, j)) {
                        System.out.print("  !");
                    } else if (j - 1 > -1 && i - 1 > -1 && field[i - 1][j - 1] == 0 && ChangeColourRightDiagonalDownB(i, j)) {
                        System.out.print("  !");
                    } else {
                        System.out.print("  W");
                    }
                } else if (field[i][j] == 0) {
                    System.out.print("  *");
                } else {
                    System.out.print("  B");
                }
            }
            System.out.print('\n');
        }
    }
    public void printStepsForBlack() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (field[i][j] == white) {
                    if (i + 1 < 8 && field[i + 1][j] == 0 && ChangeColourUpB(i, j)) {
                        System.out.print("  !");
                    } else if (j + 1 < 8 && field[i][j + 1] == 0 && ChangeColourLeftB(i, j)) {
                        System.out.print("  !");
                    } else if (i - 1 > -1 && field[i - 1][j] == 0 && ChangeColourDownB(i, j)) {
                        System.out.print("  !");
                    } else if (j - 1 > -1 && field[i][j - 1] == 0 && ChangeColourRightB(i, j)) {
                        System.out.print("  !");
                    } else if (i + 1 < 8 && j + 1 < 8 && field[i + 1][j + 1] == 0 && ChangeColourLeftDiagonalUpB(i, j)) {
                        System.out.print("  !");
                    } else if (j + 1 < 8 && i - 1 > -1 && field[i - 1][j + 1] == 0 && ChangeColourLeftDiagonalDownB(i, j)) {
                        System.out.print("  !");
                    } else if (i + 1 < 8 && j - 1 > -1 && field[i + 1][j - 1] == 0 && ChangeColourRightDiagonalUpB(i, j)) {
                        System.out.print("  !");
                    } else if (j - 1 > -1 && i - 1 > -1 && field[i - 1][j - 1] == 0 && ChangeColourRightDiagonalDownB(i, j)) {
                        System.out.print("  !");
                    }  else {
                        System.out.print("  W");
                    }
                } else if (field[i][j] == 0) {
                    System.out.print("  *");
                } else {
                    System.out.print("  B");
                }
            }
            System.out.print('\n');
        }
    }

    private double ss(int x, int y) {
        if (x == 0 && y == 0 || x == 0 && y == 7 || x == 7 && y == 0 || x == 7 && y == 7) {
            return 0.8;
        } else if (x == 0 || y == 7 || y == 0 || x == 7) {
            return 0.4;
        }
        return 0;
    }

    private double si(int x, int y) {
        if (x == 0 || y == 7 || y == 0 || x == 7) {
            return 2;
        }
        return 1;
    }

    private double countR(int x, int y) {
        double r = ChangeColourUpR(x, y) + ChangeColourDownR(x, y) + ChangeColourLeftR(x, y) + ChangeColourRightR(x, y) + ChangeColourRightDiagonalDownR(x, y) + ChangeColourRightDiagonalUpR(x, y) + ChangeColourLeftDiagonalDownR(x, y) + ChangeColourLeftDiagonalUpR(x, y);
        r += ss(x,y);
        return r;
    }

    private double ChangeColourRightR(int x, int y) {
        double r = 0;
        int cury = y + 1;
        int secy = y + 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != 8) {
            if (field[x][cury] == 0) {
                return 0;
            }
            if(field[x][cury] == colour) {
                secy = cury;
                break;
            }
            cury++;
        }
        if (secy != y + 1) {
            for (int i = y + 1; i != secy; i++) {
                r += si(x,i);
            }
        }
        return r;
    }
    private double ChangeColourLeftR(int x, int y) {
        int cury = y - 1;
        int secy = y - 1;
        double r = 0;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != -1) {
            if (field[x][cury] == 0) {
                return 0;
            }
            if(field[x][cury] == colour) {
                secy = cury;
                break;
            }
            cury--;
        }
        if (secy != y - 1) {
            for (int i = y - 1; i != secy; i--) {
                r += si(x,i);
            }
        }
        return r;
    }

    private double ChangeColourDownR(int x, int y) {
        int curx = x + 1;
        int secx = x + 1;
        double r = 0;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(curx != 8) {
            if (field[curx][y] == 0) {
                return 0;
            }
            if(field[curx][y] == colour) {
                secx = curx;
                break;
            }
            curx++;
        }
        if (secx != x + 1) {
            for (int i = x + 1; i != secx; i++) {
                r += si(i,y);
            }
        }
        return r;
    }

    private double ChangeColourUpR(int x, int y) {
        int curx = x - 1;
        int secx = x - 1;
        double r = 0;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(curx != -1) {
            if (field[curx][y] == 0) {
                return 0;
            }
            if(field[curx][y] == colour) {
                secx = curx;
                break;
            }
            curx--;
        }
        if (secx != x - 1) {
            for (int i = x - 1; i != secx; i--) {
                r += si(i, y);
            }
        }
        return r;
    }

    private double ChangeColourLeftDiagonalUpR(int x, int y) {
        int cury = y - 1;
        int curx = x - 1;
        double r = 0;
        int secy = y - 1;
        int secx = x - 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != -1 && curx != -1) {
            if (field[curx][cury] == 0) {
                return 0;
            }
            if(field[curx][cury] == colour) {
                secx = curx;
                secy = cury;
                break;
            }
            curx--;
            cury--;
        }
        if (secy != y - 1) {
            for (int i = y - 1, j = x - 1; i != secy; i--, j--) {
                r += si(i, j);
            }
        }
        return r;
    }
    private double ChangeColourRightDiagonalDownR(int x, int y) {
        int cury = y + 1;
        int curx = x + 1;
        int secy = y + 1;
        int secx = x + 1;
        int colour;
        double r = 0;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != 8 && curx != 8) {
            if (field[curx][cury] == 0) {
                return 0;
            }
            if(field[curx][cury] == colour) {
                secx = curx;
                secy = cury;
                break;
            }
            curx++;
            cury++;
        }
        if (secy != y + 1) {
            for (int i = y + 1, j = x + 1; i != secy; i++, j++) {
                r += si(i, j);
            }
        }
        return r;
    }
    private double ChangeColourLeftDiagonalDownR(int x, int y) {
        int cury = y - 1;
        int curx = x + 1;
        int secy = y - 1;
        double r = 0;
        int secx = x + 1;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != -1 && curx != 8) {
            if (field[curx][cury] == 0) {
                return 0;
            }
            if(field[curx][cury] == colour) {
                secx = curx;
                secy = cury;
                break;
            }
            curx++;
            cury--;
        }
        if (secy != y - 1) {
            for (int i = y - 1, j = x + 1; i != secy; i--, j++) {
                r += si(i, j);
            }
        }
        return r;
    }
    private double ChangeColourRightDiagonalUpR(int x, int y) {
        int cury = y + 1;
        int curx = x - 1;
        int secy = y + 1;
        int secx = x - 1;
        double r = 0;
        int colour;
        int reverseColour;
        if (field[x][y] == white) {
            colour = white;
            reverseColour = black;
        } else {
            colour = black;
            reverseColour = white;
        }
        while(cury != 8 && curx != -1) {
            if (field[curx][cury] == 0) {
                return 0;
            }
            if(field[curx][cury] == colour) {
                secx = curx;
                secy = cury;
                break;
            }
            curx--;
            cury++;
        }
        if (secy != y - 1) {
            for (int i = y + 1, j = x - 1; i != secy; i++, j--) {
                r += si(i, j);
            }
        }
        return r;
    }

    public Pair chooseWhiteStep() {
        ArrayList<Pair> m = whereWhiteCanGo();
        double max = 0;
        Pair imax = new Pair(0,0);
        for (int i = 0; i < m.size(); i++) {
            double ri = countR(m.get(i).first(), m.get(i).second());
            if (ri > max) {
                max = ri;
                imax = m.get(i);
            }
        }
        return imax;
    }

    public Pair chooseBlackStep() {
        ArrayList<Pair> m = whereBlackCanGo();
        double max = 0;
        Pair imax = new Pair(0,0);
        for (int i = 0; i < m.size(); i++) {
            double ri = countR(m.get(i).first(), m.get(i).second());
            if (ri > max) {
                max = ri;
                imax = m.get(i);
            }
        }
        return imax;
    }
}
