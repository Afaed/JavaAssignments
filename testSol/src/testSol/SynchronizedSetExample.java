package testSol;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SynchronizedSetExample {
    private static Set<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) {
        Thread addThread = new Thread(SynchronizedSetExample::addNumbers);
        Thread iterateThread = new Thread(SynchronizedSetExample::iterateNumbers);

        addThread.start();
        iterateThread.start();
    }

    private static void addNumbers() {
        for (int i = 0; i <= 50; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            numberSet.add(i);
            System.out.println("Thread 1: " + i);
        }
    }

    private static void iterateNumbers() {
        Iterator<Integer> iterator;
        while (true) {
            synchronized (numberSet) {
                iterator = numberSet.iterator();
                while (iterator.hasNext()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int num = iterator.next();
                    System.out.println("Thread 2: " + num);
                }
            }
        }
    }
}