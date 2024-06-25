package sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sec01.subscriber.SubscriberImpl;

import java.util.stream.Stream;

public class Lec01LazyStream {
    private static final Logger logger = LoggerFactory.getLogger(Lec01LazyStream.class);
    public static void main(String[] args) {
        Stream.of(1)
                .peek(i -> logger.info("received {} ",i))
                .toList();
    }
}
