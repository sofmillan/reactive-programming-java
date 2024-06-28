package sec03;

import common.Util;
import reactor.core.publisher.Flux;

public class Lec06Log {
    public static void main(String[] args) {
        //log will only print what comes before itself
        Flux.range(1,5)
                .log("range-map")
                .map(i -> Util.faker().name().firstName())
                .log("map-subscribe")
                .subscribe(Util.subcriber());
    }
}
