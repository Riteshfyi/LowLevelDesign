public class Main {
    public static void main(String[] args) {
        CacheService<String, Integer> cache = CacheFactory.getInstance();  // Assuming a factory method
        int threadCount = 8;

        Thread[] threads = new Thread[threadCount];

        threads[0] = new Thread(() -> {
            cache.put("A", 1);
            System.out.println("Thread 1: Inserted A -> 1");
        });

        threads[1] = new Thread(() -> {
            cache.put("B", 2);
            System.out.println("Thread 2: Inserted B -> 2");
        });

        threads[2] = new Thread(() -> {
            cache.put("C", 3);
            System.out.println("Thread 3: Inserted C -> 3");
        });

        threads[3] = new Thread(() -> {
            cache.put("D", 4);
            System.out.println("Thread 4: Inserted D -> 4");
        });

        threads[4] = new Thread(() -> {
            cache.get("A");
            System.out.println("Thread 5: Retrieved A -> " + cache.get("A"));
        });

        threads[5] = new Thread(() -> {
            cache.put("E", 5);
            System.out.println("Thread 6: Inserted E -> 5 (Should cause eviction)");
        });

        threads[6] = new Thread(() -> {
            cache.get("B");
            System.out.println("Thread 7: Retrieved B -> " + cache.get("B"));
        });

        threads[7] = new Thread(() -> {
            cache.get("C");
            System.out.println("Thread 8: Retrieved C -> " + cache.get("C"));
        });

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nFinal Cache State After Execution:");
        System.out.println("A: " + cache.get("A"));
        System.out.println("B: " + cache.get("B"));
        System.out.println("C: " + cache.get("C"));
        System.out.println("D: " + cache.get("D"));
        System.out.println("E: " + cache.get("E"));
    }
}
