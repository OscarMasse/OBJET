package pro.masse.main;

public class Player extends Entity {

    public float velocityX, velocityY;

    Player() {
        posY = 64;
    }

    @Override
    public void update() {
        posX += .5f;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(1f, 0f, 0f);
        graphics2D.drawRect(posX - 16, posY -16, 32, 32);
    }
}
