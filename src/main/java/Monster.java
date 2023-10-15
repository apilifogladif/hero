import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {

    public Monster(int x, int y) {super(x, y); }

    public Position move(Arena arena) {
        Random random = new Random();
        while (true) {
            Position newPos = new Position(this.getPosition().getX() + random.nextInt(3) - 1,
                    this.getPosition().getY() + random.nextInt(3) - 1);
            if (newPos.getX() > 0 && newPos.getX() < arena.getWidth() - 1 && newPos.getY() > 0 &&
                    newPos.getY() < arena.getHeight() - 1 && newPos != this.getPosition()) {
                return newPos;
            }
        }
    }


    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#008000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "#");
    }
}
