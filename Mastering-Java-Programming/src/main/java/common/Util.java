package common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class Util {
    private static final Faker faker = Faker.instance();
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

    public static Faker faker(){
        return faker;
    }
}
