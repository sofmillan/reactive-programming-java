package sec01;

import sec01.publisher.PublisherImpl;
import sec01.subscriber.SubscriberImpl;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        demo4();
    }

    private static void demo1(){
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    //Request for more items that it can provide
    private static void demo2() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
        subscriber.getSubscription().request(2);
        Thread.sleep(3000);
        subscriber.getSubscription().request(4);
    }

    //Cancel the subscription
    private static void demo3() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
    }

    //onError
    private static void demo4() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(11);
        Thread.sleep(3000);
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
    }
}
