package sec02;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec10MonoDefer {
    private static final Logger logger = LoggerFactory.getLogger(Lec10MonoDefer.class);

    public static void main(String[] args) {
        //three seconds will pass
     //   createPublisher();


        //if you have a mono creation that is time-consuming, delay it by using defer
        //in this case it will exit immediately
        //if we uncomment the subscribe it will execute everything (6 seconds)
        Mono.defer(()-> createPublisher());
                //.subscribe(Util.subcriber());
    }

    private static Mono<Integer> createPublisher(){
        logger.info("Creating publisher");
        var list = List.of(1,2,3);
        Util.sleepSeconds(3);
        return  Mono.fromSupplier(()-> sum(list));
    }


    //time-consuming business operation
    private static int sum(List<Integer> list){
        logger.info("finding the sum of {}", list);
        Util.sleepSeconds(3);
        return list.stream().mapToInt(a->a).sum();
    }

}
