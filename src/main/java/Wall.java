import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


public class Wall extends Element {
    public Wall(int c, int i) {
        super(c, i);
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF5722"));
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), " ");
    }

}
