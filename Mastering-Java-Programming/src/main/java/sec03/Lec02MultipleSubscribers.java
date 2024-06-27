package sec03;

import common.Util;
import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {
    public static void main(String[] args) {
        var flux = Flux.just(1,2,3,4,5,6);

        flux.subscribe(Util.subcriber("One"));

        flux
                .filter(i -> i > 7)
                .subscribe(Util.subcriber("Two"));

        flux
                .filter(i -> i%2 == 0)
                .map(i->i*10)
                .subscribe(Util.subcriber("Three"));
    }
}
