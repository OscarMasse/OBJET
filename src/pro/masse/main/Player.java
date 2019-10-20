package pro.masse.main;

public class Player extends Entity {

    public float velocityX, velocityY;

    Player() {
        posY = 64;
    }

    @Override
    public void update() {
        super.update();
        float deltaTime = Time.getDeltaTime();

        if(posY > 20f) {
            velocityY -= 9.81f;
        }

        posX += velocityX * deltaTime;
        posY += velocityY * deltaTime;

        if(posY < 20f)  {
            posY = 20f;
            velocityY = 0f;
        }
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(1f, 0f, 0f);
        graphics2D.drawRect(posX - 16, posY -16, 32, 32);
    }
}
