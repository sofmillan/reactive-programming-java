package sec02;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;
import java.util.List;

public class Lec06MonoFromCallable {
    private static final Logger logger = LoggerFactory.getLogger(Lec06MonoFromCallable.class);

    public static void main(String[] args) {
        var list = List.of(1,2,3);
        //callable will not have any problem if the method it is using, has throws in the method signature, checked exception
        //supplier would make you use a try/catch
        Mono.fromCallable(()-> sum(list))
                .subscribe(Util.subcriber());
    }
    private static int sum(List<Integer> list) throws FileNotFoundException {
        logger.info("finding the sum of {}", list);
        return list.stream().mapToInt(a->a).sum();
    }
}
