package com.sec01;

import com.utils.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {
        getName();
        String s = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(s);
        getName();

        Util.sleepSeconds(4);
    }
    private static Mono<String> getName(){
        System.out.println("Entered method");
        //Building pipeline
        return Mono.fromSupplier(()->{
            System.out.println("Generating name");
            Util.sleepSeconds(3);
            return Util.faker().name().firstName();
        }).map(String::toUpperCase);
    }
}
