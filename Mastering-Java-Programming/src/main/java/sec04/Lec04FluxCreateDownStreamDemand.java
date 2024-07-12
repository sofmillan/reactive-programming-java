package sec04;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateDownStreamDemand {
    private static final Logger logger = LoggerFactory.getLogger(Lec04FluxCreateDownStreamDemand.class);

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                String name = Util.faker().name().firstName();
                logger.info(name);
                fluxSink.next(name);
            }
            fluxSink.complete();
        }).subscribe(Util.subcriber());
    }
}
