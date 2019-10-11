package pro.masse.main;

import javax.swing.*;

public class Frame {

    private JPanel gameView;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Title");
        frame.setContentPane(new Frame().gameView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void initEvents() {
    }
}
