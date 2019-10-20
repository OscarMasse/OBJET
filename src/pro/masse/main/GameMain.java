package pro.masse.main;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL11;

public class GameMain {

    private GLFWErrorCallback errorCallback;

    private boolean running;
    private Display display;
    private Timer timer;
    private Scene loadedScene;
    private Graphics2D graphics2D;

    public static int fps;

    public void start() {
        if (running) return;
        running = true;

        display = new Display(this, 1600, 900, "Game Title");
        loadedScene = new Scene();

        ///////////////////////////////////////
        loadedScene.addEntity(new Player());
        graphics2D = new Graphics2D();
        ///////////////////////////////////////

        gameLoop();
    }

    private void update(double deltaTime) {

    }

    private void render(double deltaTime) {

    }

    public void gameLoop() {

        int targetFPS = 144;
        int lastFpsTime = 0;
        long lastLoopTime = System.nanoTime();
        double nanoSecondPerTick = Math.pow(10,9) / targetFPS;

        while (running) {



            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;

            double deltaTime = updateLength / nanoSecondPerTick;

            lastFpsTime += updateLength;
            fps++;

            if (lastFpsTime >= Math.pow(10,9)) {
                System.out.println("FPS: " + fps);
                lastFpsTime = 0;
                fps = 0;
            }

            display.update();

            /* Set viewport and clear screen */
            GL11.glViewport(0, 0, display.getWidth(), display.getHeight());
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            /* Set ortographic projection */
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();
            GL11.glOrtho(0f, 400f, 225f, 0f, 1f, -1f);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);

            loadedScene.update();
            loadedScene.render(graphics2D);
        }
    }

    public void stop() {
        if (!running) return;
        running = false;
    }

    public static void main(String[] args) {

        GameMain gameMain = new GameMain();

        gameMain.start();
    }
}
