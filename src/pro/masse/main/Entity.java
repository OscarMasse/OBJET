package pro.masse.main;

public class Entity implements Renderable {

    protected float posX, posY;
    protected float lastPosX, lastPosY;

    public void update() {
        lastPosX = posX;
        lastPosY = posY;
    }

    @Override
    public void render(Graphics2D graphics2D) {

    }
}
