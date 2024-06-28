package sec03;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import sec02.Lec01LazyStream;

public class Lec05FluxRange {
    public static void main(String[] args) {

        //Accepts starting point and how many items you want to emit
        Flux.range(3, 10)
                .subscribe(Util.subcriber());

        Flux.range(1, 10)
                .map(i->Util.faker().name().firstName())
                .subscribe(Util.subcriber());
    }
}
