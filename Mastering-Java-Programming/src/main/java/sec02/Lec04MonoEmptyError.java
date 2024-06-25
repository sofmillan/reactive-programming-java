package sec02;

import common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {
    public static void main(String[] args) {
        getUserName(3).subscribe(Util.subcriber());

        getUserName(3).subscribe(
                s -> System.out.println(s)
        );
    }

    private static Mono<String> getUserName(int userId){
        return switch(userId){
            case 1 -> Mono.just("ricky");
            case 2 -> Mono.empty();
            default -> Mono.error(new IllegalArgumentException("Invalid input"));
        };
    }
}
