package sec04;

import common.Util;
import reactor.core.publisher.Flux;
import sec04.helpers.NameGenerator;

public class Lec02FluxCreateRefactor {
    public static void main(String[] args) {
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(Util.subcriber());
        generator.generate();
    }
}
