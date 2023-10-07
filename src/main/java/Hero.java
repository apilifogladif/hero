import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


public class Hero {
    private static Position position;

    public Hero(int a, int b) {
        position = new Position(a, b);
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
    public static void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
                graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");    }

    public void setPosition(Position newPos) {
        position.setPosition(newPos);
    }
}
