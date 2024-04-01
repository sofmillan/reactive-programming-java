package com.sec01;

import java.util.stream.Stream;

public class Lec01Stream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3,4).map(i ->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return i*2;
        });

        System.out.println(stream);
        stream.forEach(System.out::print);
    }
}
