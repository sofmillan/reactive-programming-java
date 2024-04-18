package com.sec02.helper;

import com.utils.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNames(int times){
        List<String> nameList = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            nameList.add(getName());
        }

        return nameList;
    }

    public static Flux<String> getNamesFlux(int times){
        return Flux.range(0, times)
                .map(i->getName());
    }


    private static String getName(){
        Util.sleepSeconds(1);
        return Util.faker().name().firstName();
    }
}
