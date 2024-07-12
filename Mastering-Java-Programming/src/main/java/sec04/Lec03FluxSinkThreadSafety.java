package sec04;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import sec02.Lec01LazyStream;
import sec04.helpers.NameGenerator;

import java.util.ArrayList;

public class Lec03FluxSinkThreadSafety {
    private static final Logger logger = LoggerFactory.getLogger(Lec01LazyStream.class);

    public static void main(String[] args) {
       // demo1(); // 5700 items
        demo2(); // 10000 items
    }

    private static void demo1(){
        var list = new ArrayList<Integer>();
        Runnable runnable = () ->{
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        Util.sleepSeconds(3);
        logger.info("Size "+list.size());
    }

    private static void demo2(){
        var list = new ArrayList<String>();
        NameGenerator generator = new NameGenerator();
        Flux<String> flux = Flux.create(generator);
        flux.subscribe(list::add);

        Runnable runnable = () ->{
            for (int i = 0; i < 1000; i++) {
                generator.generate();
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        Util.sleepSeconds(3);
        logger.info("Size "+list.size());
    }
}
