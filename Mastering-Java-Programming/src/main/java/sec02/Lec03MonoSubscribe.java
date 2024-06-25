package sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    private static final Logger logger = LoggerFactory.getLogger(Lec01LazyStream.class);

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);

        //the call to request is done automatically, it does not have to be explicit, but can
        //be provided as the fourth parameter

        //by providing only one consumer, we are defining the onNext behavior
        mono.subscribe(
                i -> logger.info("received {}",i));

        mono.subscribe(
                i -> logger.info("received {}",i),
                err -> logger.error("error",err),
                () -> logger.info("completed"),
                subscription -> subscription.cancel());



        Mono<Integer> mono2 = Mono.just(1)
                .map(i -> i /0);
        mono2.subscribe(
                i -> logger.info("received {}",i),
                err -> logger.error("error",err),
                () -> logger.info("completed"));
    }
}
