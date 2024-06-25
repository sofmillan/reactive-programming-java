package sec02;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec08MonoFromFuture {
    private static final Logger logger = LoggerFactory.getLogger(Lec08MonoFromFuture.class);

    public static void main(String[] args) {
        //It is calling the method, even if we not subscribe, completable future it is not lazy
        Mono.fromFuture(getName())
                .subscribe(Util.subcriber());
        Util.sleepSeconds(1);

        //lazy
        Mono.fromFuture(() ->getName())
                .subscribe(Util.subcriber());
        Util.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(()->{
            logger.info("Generating name");
            return Util.faker().name().firstName();
        });
    }
}
