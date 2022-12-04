public class Pair {
    private int x;
    private int y;
    Pair(int x1, int y1) {
        x = x1;
        y = y1;
    }

    public int first() {
        return x;
    }

    public int second() {
        return y;
    }

    boolean isEqual(Pair p) {
        return p.first() == this.first() && p.second() == this.second();
    }
}
