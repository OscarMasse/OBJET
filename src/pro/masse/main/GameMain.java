package pro.masse.main;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL11;

public class GameMain {

    private GLFWErrorCallback errorCallback;

    private boolean running;
    private Display display;
    private Scene loadedScene;
    private Graphics2D graphics2D;
    private InputManager inputManager;
    private Player player;

    public void start() {
        if (running) return;
        running = true;

        inputManager = new InputManager(this);
        display = new Display(this, 1600, 900, "Game Title");
        loadedScene = new Scene();

        ///////////////////////////////////////
        loadedScene.addEntity(player = new Player());
        graphics2D = new Graphics2D();
        ///////////////////////////////////////

        gameLoop();
    }

    public void gameLoop() {

        /* Set viewport and clear screen */
        GL11.glViewport(0, 0, display.getWidth(), display.getHeight());
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

        /* Set ortographic projection */
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0f, 400f, 0f, 225f, 1f, -1f);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        while (running) {

            Time.update();

            display.update();

            loadedScene.update();
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
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

    public InputManager getInputManager() {
        return this.inputManager;
    }

    public Player getPlayer() {
        return this.player;
    }
}
