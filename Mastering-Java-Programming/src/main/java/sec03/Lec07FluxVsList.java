package sec03;

import common.Util;
import sec01.subscriber.SubscriberImpl;
import sec03.helper.NameGenerator;

public class Lec07FluxVsList {
    public static void main(String[] args) {
      /*  var list = NameGenerator.getNamesList(10);
        System.out.println(list);*/

        var subscriber = new SubscriberImpl();

        NameGenerator.getNamesFlux(10)
                .subscribe(subscriber);

        subscriber.getSubscription().request(3);
        subscriber.getSubscription().cancel();
    }
}
