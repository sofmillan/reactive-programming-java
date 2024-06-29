package sec03;

import common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec09FluxInternal {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .map(i -> Util.faker().name().firstName())
                .subscribe(Util.subcriber());

        Util.sleepSeconds(5);
    }
}
