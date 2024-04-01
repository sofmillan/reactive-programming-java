package com.sec02;

import com.utils.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {
    public static void main(String[] args) {
        //when you have the data already
       Flux<Integer> flux = Flux.just(1, 2, 3, 4);

       flux.subscribe(Util.onNext(),
               Util.onError(),
               Util.onComplete());

       Flux<Integer> empty = Flux.empty();

        empty .subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
