package sec02;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec07MonoFromRunnable {
    private static final Logger logger = LoggerFactory.getLogger(Lec07MonoFromRunnable.class);

    public static void main(String[] args) {

        getProductName(2)
                .subscribe(Util.subcriber());
    }

    private static Mono<String> getProductName(int productId){
        if(productId==1){
            return Mono.fromSupplier(()-> Util.faker().commerce().productName());
        }
        return Mono.fromRunnable(()-> notifyBusiness(productId));
    }

    private static void notifyBusiness(int productId){
        logger.info("Unavailable product {}", productId);
    }
}
