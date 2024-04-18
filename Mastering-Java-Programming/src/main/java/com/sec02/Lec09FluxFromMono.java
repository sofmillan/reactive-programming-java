package com.sec02;

import com.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
    /*    Mono<String> mono = Mono.just("a");

        Flux.from(mono)
                .subscribe(Util.onNext());*/

        Flux.range(1, 10)
                .filter(i->i>3)
                .next() //First item
                .subscribe(Util.onNext(),Util.onError(), Util.onComplete());
    }

    private static void doSomething(Flux<String> flux){

    }
}
