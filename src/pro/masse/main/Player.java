package pro.masse.main;

public class Player extends Entity {

    public float velocityX, velocityY;

    Player() {
        posX = 100f;
        posY = 20f;
    }

    @Override
    public void update() {
        super.update();
        float deltaTime = Time.getDeltaTime();

        if(posY > 20f) {
            if (velocityY > 0) velocityY -= 9.81f * deltaTime;
            else velocityY -= 2 * 9.81f * deltaTime;
        }

        posX += velocityX * deltaTime * 3;
        posY += velocityY * deltaTime * 150;

        if(posY < 20f)  {
            posY = 20f;
            velocityY = 0f;
        }
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(1f, 1f, 1f);
        graphics2D.drawRect(posX + 16, posY, 32, 32);
    }
}
