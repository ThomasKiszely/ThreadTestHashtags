public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        HashtagController hashtagController = new HashtagController(counter);
        StarController starController = new StarController(counter);

        Thread hashtagThread = new Thread(hashtagController);
        Thread starThread = new Thread(starController);
        hashtagThread.start();
        starThread.start();

    }
}