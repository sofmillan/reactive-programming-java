package sec03;

import common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec11FluxMono {
    public static void main(String[] args) {
        //Mono to Flux
        var mono = getUserName(3);
        save(Flux.from(mono));

        //Flux to Mono
        var flux = Flux.range(1,10);
        Mono<Integer> mono2 = flux.next();

        mono2.subscribe(Util.subcriber());

        //Mono.from(flux) is also possible
    }

    private static Mono<String> getUserName(int userId){
        return switch(userId){
            case 1 -> Mono.just("ricky");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("invalid input"));
        };
    }

    private static void save(Flux<String> flux){
        flux.subscribe(Util.subcriber());
    }
}
