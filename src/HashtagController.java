public class HashtagController implements Runnable {
    Hashtag hashtag = new Hashtag();
    Star star = new Star();
    Counter counter = new Counter();
    public HashtagController(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        addHashtag();
    }
    synchronized public void addHashtag() {
        while (true) {
            synchronized (counter) {
        for (int i = 1; i <= 60; i++) {
            System.out.print(hashtag.getHashtag());
            counter.setCount(counter.getCount() + 1);
            if (i == 60) {
                System.out.println(counter.getCount());
                counter.notify();
                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }}
                }
            }
        }
    }
//    synchronized public void addStars() {
//        for (int i = 0; i < 60; i++) {
//            System.out.print(star.getStar());
//            counter.setCount(counter.getCount() + 1);
//            notify();
//        }
//    }
}

