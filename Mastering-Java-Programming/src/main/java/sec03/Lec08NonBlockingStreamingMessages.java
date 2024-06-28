package sec03;

import common.Util;
import sec03.client.ExternalServiceClient;

public class Lec08NonBlockingStreamingMessages {
    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        client.getNames()
                .subscribe(Util.subcriber("one"));
        client.getNames()
                .subscribe(Util.subcriber("two"));
        Util.sleepSeconds(7);
    }
}
