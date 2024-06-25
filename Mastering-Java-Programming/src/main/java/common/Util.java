package common;

import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class Util {
    public static <T> Subscriber<T> subcriber(){
        return new DefaultSubscriber<>("");
    }

    public static <T> Subscriber<T> subcriber(String name){
        return new DefaultSubscriber<>(name);
    }

    public static void main(String[] args) {
        var mono = Mono.just(1);
        mono.subscribe(subcriber());
    }
}
