import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PubSubTest {
    public static void main(String[] args) {
        PubSubController pubSubController = new PubSubController();
        ExecutorService executor = Executors.newFixedThreadPool(6);

        String topicName = "TechUpdates";

        // Step 1: Create Topic before subscriptions and publishing
        executor.execute(() -> {
            pubSubController.createTopic(topicName);
            System.out.println(Thread.currentThread().getName() + " - Topic Created: " + topicName);
        });

        // Step 2: Create Subscribers
        Subscriber sub1 = new Subscriber();
        Subscriber sub2 = new Subscriber();
        sub1.setPubsubcontroller(pubSubController);
        sub2.setPubsubcontroller(pubSubController);

        // Step 3: Subscribe Users (Executed After Topic Creation)
        executor.execute(() -> {
            pubSubController.subscribe(topicName, sub1);
            System.out.println(Thread.currentThread().getName() + " - Subscriber 1 Subscribed");
        });

        executor.execute(() -> {
            pubSubController.subscribe(topicName, sub2);
            System.out.println(Thread.currentThread().getName() + " - Subscriber 2 Subscribed");
        });

        // Step 4: Publish Messages Concurrently (After Subscription)
        executor.execute(() -> {
            try { TimeUnit.MILLISECONDS.sleep(100); } catch (InterruptedException ignored) {} // Ensure topic exists
            pubSubController.publish(topicName, new Message("1", "Hello Subscribers!"));
            System.out.println(Thread.currentThread().getName() + " - Message 1 Published");
        });

        executor.execute(() -> {
            try { TimeUnit.MILLISECONDS.sleep(100); } catch (InterruptedException ignored) {} // Ensure topic exists
            pubSubController.publish(topicName, new Message("2", "New Update Available!"));
            System.out.println(Thread.currentThread().getName() + " - Message 2 Published");
        });

        // Step 5: Push Notifications Concurrently
        executor.execute(() -> {
            try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException ignored) {} // Ensure messages exist
            sub1.getNotification(topicName);
        });

        executor.execute(() -> {
            try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException ignored) {} // Ensure messages exist
            sub2.getNotification(topicName);
        });

        executor.shutdown();
    }
}
