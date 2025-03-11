public class StarController implements Runnable {
    Star star = new Star();
    Counter counter = new Counter();

    public StarController(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        addStars();
    }
    synchronized public void addStars(){
        while(true){
            synchronized(counter){
        for (int i = 1; i <= 60; i++) {
            System.out.print(star.getStar());
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
}
