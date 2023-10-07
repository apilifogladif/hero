import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
public class Arena {
    private static int width;
    private static int height;
    private static Hero hero;

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Arena.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Arena.height = height;
    }

    public Arena (int w, int h) {
        hero = new Hero(10, 10);
        setWidth(w);
        setHeight(h);
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
                graphics.fillRectangle(new TerminalPosition(0, 0), new
                        TerminalSize(width, height), ' ');
        hero.draw(graphics);
    }

    public void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case Character:
                break;
        }
    }
    private static void moveHero(Position pos) {
        if (canHeroMove(pos)) {
            hero.setPosition(pos);
        }
    }

    private static boolean canHeroMove(Position position) {
        boolean b = false;
        int x = position.getX();
        int y = position.getY();
        System.out.println(width);
        System.out.println(height);
        System.out.println(x);
        System.out.println(y);
        if ((x >= 0 && x < width) && (y >= 0 && y < height)) b = true;
        System.out.println(b);
        return b;
    }
}
