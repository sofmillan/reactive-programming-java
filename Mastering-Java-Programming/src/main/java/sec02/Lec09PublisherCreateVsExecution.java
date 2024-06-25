package sec02;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec09PublisherCreateVsExecution {
    private static final Logger logger = LoggerFactory.getLogger(Lec09PublisherCreateVsExecution.class);

    public static void main(String[] args) {
        getName(); //The first message will appear
        //We are creating a publisher. which is a lightweight operation

        //We are executing the publisher, what it's inside the supplier
        //business logic should be delayed
        getName().subscribe(Util.subcriber());
    }

    private static Mono<String> getName(){
        logger.info("Entered the method");
        return Mono.fromSupplier(()->{
            logger.info("Generating name");
            Util.sleepSeconds(3);
            return Util.faker().name().firstName();
        });
    }
}
