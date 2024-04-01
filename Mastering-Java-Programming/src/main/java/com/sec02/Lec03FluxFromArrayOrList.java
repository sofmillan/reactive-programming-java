package com.sec02;

import com.utils.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a","b","c","d");

        Flux.fromIterable(strings)
                .subscribe(Util.onNext());

        Integer[] intArray = {1,2,3,4};

        Flux.fromArray(intArray)
                .subscribe(Util.onNext());
    }
}
