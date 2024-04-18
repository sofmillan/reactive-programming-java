package com.sec02;

import com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {
    public static void main(String[] args) {
        //It will publish some item periodically
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());
        Util.sleepSeconds(5);
    }
}
