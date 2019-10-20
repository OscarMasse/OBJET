package pro.masse.main;

public class Time {

    private static long lastLoopTime;

    public static void update() {
        lastLoopTime = System.nanoTime();
    }

    public static float getDeltaTime() {
        return (float) (System.nanoTime() - lastLoopTime) / 1000000000;
    }
}
