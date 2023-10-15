import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private final Hero hero;
    private final List<Wall> walls;
    private final List<Coin> coins;
    private final List<Monster> monsters;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Arena (int w, int h) {
        hero = new Hero(10, 10);
        setWidth(w);
        setHeight(h);
        walls = createWalls();
        coins = createCoins();
        monsters = createMonsters();
    }
    private List<Wall> createWalls() {
        List<Wall> ws = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            ws.add(new Wall(c, 0));
            ws.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            ws.add(new Wall(0, r));
            ws.add(new Wall(width - 1, r));
        }
        return ws;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1,
                    random.nextInt(height - 2) + 1));
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1,
                    random.nextInt(height - 2) + 1));
        return monsters;
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls) wall.draw(graphics);
        for (Coin coin: coins) coin.draw(graphics);
        for(Monster monster : monsters) monster.draw(graphics);
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
        verifyMonsterCollisions();
        moveMonsters();
        verifyMonsterCollisions();
    }
    public void moveMonsters() {
        for(Monster monster : monsters) monster.setPosition(monster.move(this));
    }
    private void moveHero(Position pos) {
        if (canHeroMove(pos)) {
            retrieveCoins();
            hero.setPosition(pos);
        }
    }

    public boolean verifyMonsterCollisions() {
        for (Monster monster: monsters) {
            if (monster.getPosition().equals(hero.getPosition())) return true;
        }
        return false;
    }
    private void retrieveCoins(){
        for(Coin coin : coins){
            if(hero.getPosition().equals(coin.getPosition())) {
                coins.remove(coin);
                break;
            }
        }
    }

    private boolean canHeroMove(Position position) {
        int x = position.getX();
        int y = position.getY();
        //if (x < 0 || y < 0 || x > getWidth() - 1 || y > getHeight() - 1) return false;
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }
}
