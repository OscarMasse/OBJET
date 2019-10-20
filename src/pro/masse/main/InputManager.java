package pro.masse.main;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;

import static org.lwjgl.glfw.GLFW.*;

public class InputManager {

    private final GameMain gameMain;
    private GLFWKeyCallback keyCallback;

    InputManager(GameMain gameMain) {
        this.gameMain = gameMain;
        this.keyCallback = new GLFWKeyCallback() {

            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {

//                if (key == KEY && action == ACTION) {
//                    // Do something...
//                }

                if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
                    glfwSetWindowShouldClose(window, true);
                }

            }
        };
    }

    public GLFWKeyCallback getKeyCallback() {
        return keyCallback;
    }
}
