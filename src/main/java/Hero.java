import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;


public class Hero {
    private static Position position;

    public Hero(int a, int b) {
        Position.setX(a);
        Position.setY(b);
    }
    public static Position moveUp() {
        return new Position(Position.getX(), Position.getY() - 1);
    }
    public static Position moveDown() {
        return new Position(Position.getX(), Position.getY() + 1);
    }
    public static Position moveRight() {
        return new Position(Position.getX() + 1, Position.getY());
    }
    public static Position moveLeft() {
        return new Position(Position.getX() - 1, Position.getY());
    }
    public static void draw(Screen screen) {
        screen.setCharacter(Position.getX(), Position.getY(), TextCharacter.fromCharacter('X')[0]);
    }

    public void setPosition(Position pos) {
        Position.setX(pos.getX());
        Position.setY(pos.getY());
    }
}
