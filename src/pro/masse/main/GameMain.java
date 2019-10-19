package pro.masse.main;

public class GameMain {

    public static Frame window;
    public static int fps;

    private static boolean running;

    public static void start() {
        window = new Frame();
        if (running) return;
        running = true;
    }

    private static void update(double deltaTime) {

    }

    private static void render(double deltaTime) {

    }

    public static void gameLoop() {

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
                GameView.fps = fps;
                lastFpsTime = 0;
                fps = 0;
            }

            update(deltaTime);

            render(deltaTime);

            try {
                Thread.sleep((long) (Math.abs((lastLoopTime - System.nanoTime()) + nanoSecondPerTick)/Math.pow(10,9)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void stop() {
        if (!running) return;
        running = false;
    }

    public static void main(String[] args) {

        start();

        gameLoop();
    }
}
