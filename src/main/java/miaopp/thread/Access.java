package miaopp.thread;

/**
 * Created by miaoping on 16/9/7.
 */
public class Access {
    private Object lock = new Object();

    private volatile int count = 0;

    public void access() {
        synchronized (lock) {
            while (count >= 2) {
                try {
                    System.out.println("sleep....");
                    lock.wait();
                } catch (Exception e) {
                    //TODO 打logger
                }
            }
            count++;
        }
        System.out.println(Thread.currentThread().getName() + "    " + Thread.currentThread().getId());
        try {
            Thread.currentThread().sleep(500);
        } catch (Exception e) {

        }
        // 更新访问计数并唤醒等待的线程
        count--;
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
