package sec04;

import common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
           fluxSink.next(1);
           fluxSink.next(2);
           fluxSink.next(3);
           String country;
           //emit data until some condition is met
           do{
               country = Util.faker().country().name();
               fluxSink.next(country);
           }while(!country.equalsIgnoreCase("canada"));
           fluxSink.complete();
        }).subscribe(Util.subcriber());
    }
}
