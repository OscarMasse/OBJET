package pro.masse.main;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    public static int fps = 0;

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        drawBackground(graphics2D);
    }

    private void drawBackground(Graphics2D graphics2D) {
        graphics2D.setColor(Color.darkGray);
        graphics2D.fillRect(0,0, Frame.gameViewWidth, Frame.gameViewHeight);
    }
}
