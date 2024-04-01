package com.sec01;

import com.utils.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l->l/1);


        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }
}
