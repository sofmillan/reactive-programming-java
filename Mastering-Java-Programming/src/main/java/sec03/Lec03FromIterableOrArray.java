package sec03;

import common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FromIterableOrArray {
    public static void main(String[] args) {
        var list = List.of("a","b");

        Flux.fromIterable(list)
                .subscribe(Util.subcriber());

        Integer[] arr = {1,2,3,4,5};
        Flux.fromArray(arr)
                .subscribe(Util.subcriber());
    }
}
