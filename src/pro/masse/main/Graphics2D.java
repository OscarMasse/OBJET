package pro.masse.main;

import org.lwjgl.opengl.GL11;

public class Graphics2D {

    public void setColor(float r, float g, float b) {
        GL11.glColor3f(r, g, b);
    }

    public void drawRect(float x, float y, float width, float height) {
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x + width, y);
        GL11.glVertex2f(x + width, y + height);
        GL11.glVertex2f(x, y + height);
        GL11.glEnd();
    }

}
