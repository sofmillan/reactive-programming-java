package sec01.publisher;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sec01.subscriber.SubscriberImpl;

public class SubscriptionImpl implements Subscription {
    private static final Logger logger = LoggerFactory.getLogger(SubscriberImpl.class);
    private Subscriber<? super String> subscriber;
    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber =subscriber;
    }

    @Override
    public void request(long l) {

    }

    @Override
    public void cancel() {

    }
}
