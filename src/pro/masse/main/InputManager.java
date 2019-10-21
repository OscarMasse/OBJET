package pro.masse.main;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;

import static org.lwjgl.glfw.GLFW.*;

public class InputManager {

    private final GameMain gameMain;
    private GLFWKeyCallback keyCallback;

    private boolean rightInput, leftInput;

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

                if(key == GLFW_KEY_RIGHT) {
                    if(action == GLFW_PRESS) {
                        rightInput = true;
                    } else if (action == GLFW_RELEASE) {
                        rightInput = false;
                    }
                }

                if(key == GLFW_KEY_LEFT) {
                    if(action == GLFW_PRESS) {
                        leftInput = true;
                    } else if (action == GLFW_RELEASE) {
                        leftInput = false;
                    }
                }

                if(key == GLFW_KEY_UP && action == GLFW_PRESS && gameMain.getPlayer().posY <= 20f) {
                    gameMain.getPlayer().velocityY = 3f;
                }

                gameMain.getPlayer().velocityX = 0f - (leftInput ? 40f : 0f) + (rightInput ? 40f : 0f);

            }
        };
    }

    public GLFWKeyCallback getKeyCallback() {
        return keyCallback;
    }
}
