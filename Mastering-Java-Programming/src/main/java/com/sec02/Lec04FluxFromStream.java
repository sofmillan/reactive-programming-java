package com.sec02;

import com.utils.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);
        Stream<Integer> stream = list.stream();

        Flux<Integer> integerFlux = Flux.fromStream(list::stream);
        /*Flux<Integer> integerFlux = Flux.fromStream(stream); It will throw an exception for the second one*/

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
