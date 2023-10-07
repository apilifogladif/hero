public class Position {
    private static int x;
    private static int y;

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        Position.y = y;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        Position.x = x;
    }

    public Position(int a, int b) {
        setX(a);
        setY(b);
    }
    public static void setPosition(Position pos) {
        setX(pos.getX());
        setY(pos.getY());
    }

}
