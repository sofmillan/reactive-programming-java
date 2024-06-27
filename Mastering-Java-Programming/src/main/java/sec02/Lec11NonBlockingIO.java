package sec02;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sec02.client.ExternalServiceClient;

public class Lec11NonBlockingIO {
    private static final Logger logger = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {
        var client = new ExternalServiceClient();

        logger.info("Starting process");

        //one thread handles all the  requests
        for (int i = 1; i <= 30; i++) {
            client.getProductName(i)
                    .subscribe(Util.subcriber());

        }

        Util.sleepSeconds(2);
    }
}
