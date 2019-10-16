package pro.masse.main;

import javax.swing.*;

public class Frame {

    public JFrame frame;
    public JPanel gameView;

    public static int gameViewWidth = 1600;
    public static int gameViewHeight = gameViewWidth / 16 * 3;

    public Frame() {
        initFrame();
    }

    public void initFrame() {
        JFrame frame = new JFrame("Game Title");
        GameView gameView = new GameView();
        frame.getContentPane().add(gameView);
        frame.setBounds((1920-gameViewWidth)/2,(1080-gameViewHeight)/2, gameViewWidth, gameViewHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
