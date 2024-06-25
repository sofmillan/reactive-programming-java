package sec02;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec05MonoFromSupplier {
    private static final Logger logger = LoggerFactory.getLogger(Lec01LazyStream.class);

    public static void main(String[] args) {
        var list = List.of(1,2,3);
        //Mono.just(sum(list)); // even if we do not subscribe, the method sum is being called

        Mono.fromSupplier(()-> sum(list))
                .subscribe(Util.subcriber());
    }
    private static int sum(List<Integer> list){
        logger.info("finding the sum of {}", list);
        return list.stream().mapToInt(a->a).sum();
    }
}
