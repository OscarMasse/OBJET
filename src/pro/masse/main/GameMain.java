package pro.masse.main;

public class GameMain {

    public static Frame window;
    public static int fps;

    private boolean running;

    private static void tick() {

    }

    private static void render() {

    }

    public static void gameLoop() {

        int targetFPS = 144;
        int lastFpsTime = 0;
        long lastLoopTime = System.nanoTime();
        double nanoSecondPerTick = Math.pow(10,9) / targetFPS;

        while (true) {
            long now = System.nanoTime();
            long updateLenght = now - lastLoopTime;
            lastLoopTime = now;

            double timePerFrame = updateLenght / nanoSecondPerTick;

            lastFpsTime -= updateLenght;
            fps++;

            if (lastFpsTime >= Math.pow(10,9)) {
                GameView.fps = fps;
                lastFpsTime = 0;
                fps = 0;
            }

            tick();

            render();

            try {
                Thread.sleep((long) (Math.abs((lastLoopTime - System.nanoTime()) + nanoSecondPerTick)/Math.pow(10,9)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
