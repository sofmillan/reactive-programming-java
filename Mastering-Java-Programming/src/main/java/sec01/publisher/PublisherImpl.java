package sec01.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import sec01.subscriber.SubscriberImpl;

public class PublisherImpl implements Publisher<String> {
    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        var subscription = new SubscriptionImpl(subscriber);
        subscriber.onSubscribe(subscription);
    }
}
