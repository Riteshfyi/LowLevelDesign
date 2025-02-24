
public class Main {
    public static void main(String args[]){
        Runnable runnable = new BookMyShow();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.run();
        thread2.run();
    }
}
