package sec02;

import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;
import sec01.subscriber.SubscriberImpl;

public class Lec02MonoJust {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Ricky");
        SubscriberImpl subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);

        subscriber.getSubscription().request(13);
        subscriber.getSubscription().request(13);
        subscriber.getSubscription().cancel();
    }
}
