package com.trioptimum.shodan;

import java.util.concurrent.TimeUnit;

/**
 * Created by stan on 12/01/17.
 */
public class Main {

    public static void main(String[] args) {
        new Thread(Main::muckuj).start();
        Runtime.getRuntime().addShutdownHook(new Thread(Main::sleep));
    }


    private static void muckuj() {
        for (;;) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("jebat");
            }
            System.out.println("matej");
        }
    }

    private static void sleep() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("jebat");
            }

    }
}
