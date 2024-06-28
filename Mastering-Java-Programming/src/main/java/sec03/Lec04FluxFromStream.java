package sec03;

import common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        var list = List.of(1,2,3,4);
        var stream = list.stream();

        var flux = Flux.fromStream(stream);

        flux.subscribe(Util.subcriber());
        flux.subscribe(Util.subcriber()); //onError, stream has already closed

        //if you want multiple subscribers give a supplier

        var flux2 = Flux.fromStream(()->list.stream());
    }
}
