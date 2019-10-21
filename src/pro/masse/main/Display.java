package pro.masse.main;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

import java.nio.IntBuffer;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.glfw.GLFW.*;

public class Display {

    private final long id;
    private GameMain gameMain;
    private IntBuffer widthBuffer, heightBuffer;
    private int width, height;

    /**
     * This error callback will simply print the error to
     * <code>System.err</code>.
     */
    private static GLFWErrorCallback errorCallback
            = GLFWErrorCallback.createPrint(System.err);

    public Display(GameMain gameMain, int width, int height, String title) {

        /* Set the error callback */
        glfwSetErrorCallback(errorCallback);

        /* Initialize GLFW */
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        /* Make window non-resizable */
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        /* Create window */
        id = glfwCreateWindow(width, height, title, NULL, NULL);
        if (id == NULL) {
            glfwTerminate();
            throw new RuntimeException("Failed to create the GLFW window");
        }

        /* Center window on screen */
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(id,
                (vidmode.width() - width) / 2,
                (vidmode.height() - height) / 2
        );

        /* Create OpenGL context */
        glfwMakeContextCurrent(id);
        GL.createCapabilities();

//        /* Enable vertical synchronization */
//        glfwSwapInterval(1);

        /* Set the key callback */
        glfwSetKeyCallback(id, gameMain.getInputManager().getKeyCallback());

        widthBuffer = MemoryUtil.memAllocInt(1);
        heightBuffer = MemoryUtil.memAllocInt(1);

        this.width = width;
        this.height = height;

        this.gameMain = gameMain;
    }

    public void update() {
        glfwGetFramebufferSize(id, widthBuffer, heightBuffer);

        // Reset buffer pos
        widthBuffer.rewind();
        heightBuffer.rewind();

        width = widthBuffer.get();
        height = heightBuffer.get();

        /* Swap buffers and poll Events */
        glfwSwapBuffers(id);
        glfwPollEvents();

        widthBuffer.flip();
        heightBuffer.flip();

        if(glfwWindowShouldClose(id)) {
            gameMain.stop();
        }
    }

    public void dispose() {
        /* Free buffers */
        MemoryUtil.memFree(widthBuffer);
        MemoryUtil.memFree(heightBuffer);

        /* Release window and its callbacks */
        glfwDestroyWindow(id);
        gameMain.getInputManager().getKeyCallback().free();

        /* Terminate GLFW and release the error callback */
        glfwTerminate();
        errorCallback.free();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
