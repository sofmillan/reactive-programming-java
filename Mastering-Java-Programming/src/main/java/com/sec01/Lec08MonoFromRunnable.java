package com.sec01;

import com.utils.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("a");
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                       () ->{
                           System.out.println("Process is done");
                       });
    }
    private static Runnable timeConsumingProcess(){
        return () ->{
            Util.sleepSeconds(3);
            System.out.println("op completed");
        };
    }
}
