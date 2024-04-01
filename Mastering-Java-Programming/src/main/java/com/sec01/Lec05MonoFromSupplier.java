package com.sec01;

import com.utils.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        //use just when you have the data already
        //Mono<String> mono = Mono.just(getName());

        Mono<String> mono = Mono.fromSupplier(()->getName());
        mono.subscribe(
                Util.onNext()
        );
        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );
    }

    private static String getName(){
        System.out.println("Generating name");
        return Util.faker().name().firstName();
    }
}
